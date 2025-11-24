package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HomeFormController implements Initializable {

    @FXML
    private AreaChart<String, Number> AreaChart;

    @FXML
    private TableColumn<?, ?> ColDate;

    @FXML
    private TableColumn<?, ?> ColMount;

    @FXML
    private TableColumn<?, ?> ColTransAction;

    @FXML
    private TableColumn<?, ?> ColType;

    @FXML
    private LineChart<String, Number> LineChart;

    @FXML
    private TableView<?> tblRecentActivity;

    @FXML
    private Text txtPurchase;

    @FXML
    private Text txtStock;

    @FXML
    private Text txtTotalSale;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadMedicineStockAreaChart();
        loadAllMedicineStockTrend();
        loadTotalStock();

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


}
