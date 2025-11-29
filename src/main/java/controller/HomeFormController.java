package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.dto.PurchaseTableModel;
import model.dto.Purchases;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HomeFormController implements Initializable {

    @FXML
    private Text txtPurchaseQty;

    @FXML
    private AreaChart<String, Number> AreaChart;

    @FXML
    private TableColumn<Purchases, String> ColDate;
    @FXML
    private TableColumn<Purchases, String> ColMount;

    @FXML
    private TableColumn<Purchases, String> ColTransAction;

    @FXML
    private TableColumn<Purchases, String> ColType;

    @FXML
    private LineChart<String, Number> LineChart;

    @FXML
    private TableView<PurchaseTableModel> tblRecentActivity;

    @FXML
    private Text txtPurchase;

    @FXML
    private Text txtStock;

    @FXML
    private Text txtTotalSale;

    @FXML
    private Label txtLowMedicine;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadMedicineStockAreaChart();
        loadAllMedicineStockTrend();
        loadTotalStock();
        loadTotalSalesAmount();
        loadRecentActivity();
        loadLowMedicineCount();


    }


    private void loadMedicineStockAreaChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Medicine Stock");

        try {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "SELECT name, quantity FROM medicines";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String medicineName = rs.getString("name");
                int stock = rs.getInt("quantity");
                series.getData().add(new XYChart.Data<>(medicineName, stock));
            }

            AreaChart.getData().add(series);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void loadAllMedicineStockTrend() {
        try {
            Connection con = DBConnection.getInstance().getConnection();
            Statement stmt = con.createStatement();

            ResultSet rsMedicine = stmt.executeQuery("SELECT DISTINCT name FROM medicines");

            while (rsMedicine.next()) {
                String medicineName = rsMedicine.getString("name");

                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName(medicineName);

                String stockQuery = "SELECT updated_at, quantity FROM medicines WHERE name=? ORDER BY updated_at";
                PreparedStatement ps = con.prepareStatement(stockQuery);
                ps.setString(1, medicineName);
                ResultSet rsStock = ps.executeQuery();

                while (rsStock.next()) {
                    String date = rsStock.getString("updated_at").substring(0, 10);
                    int stock = rsStock.getInt("quantity");
                    series.getData().add(new XYChart.Data<>(date, stock));
                }

                LineChart.getData().add(series);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTotalStock() {
        try {
            Connection con = DBConnection.getInstance().getConnection();

            String sql = "SELECT SUM(quantity) AS total_stock FROM medicines";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int totalStock = rs.getInt("total_stock");
                txtStock.setText(String.valueOf(totalStock));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTotalSalesAmount() {
        try {
            Connection con = DBConnection.getInstance().getConnection();

            String sql = "SELECT SUM(total_amount) AS total_sales FROM sales";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double totalSales = rs.getDouble("total_sales");
                txtTotalSale.setText(String.valueOf(totalSales));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void loadRecentActivity() {
        ObservableList<PurchaseTableModel> list = FXCollections.observableArrayList();

        try {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "SELECT id, created_at, total_amount FROM purchases " +
                    "ORDER BY created_at DESC LIMIT 10";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("created_at").substring(0, 19);
                double amount = rs.getDouble("total_amount");
                String type = "Purchase";

                list.add(new PurchaseTableModel(id, date, type, amount));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        ColTransAction.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        ColType.setCellValueFactory(new PropertyValueFactory<>("type"));
        ColMount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        tblRecentActivity.setItems(list);
    }
    private void loadLowMedicineCount() {
        try {
            Connection con = DBConnection.getInstance().getConnection();

            String sql = "SELECT COUNT(*) AS low_count FROM medicines WHERE quantity < 100";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                int lowCount = rs.getInt("low_count");
                txtLowMedicine.setText("" + lowCount);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}