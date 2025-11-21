package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class HomeFormController {

    @FXML
    private AreaChart<?, ?> AreaChart;

    @FXML
    private TableColumn<?, ?> ColDate;

    @FXML
    private TableColumn<?, ?> ColMount;

    @FXML
    private TableColumn<?, ?> ColTransAction;

    @FXML
    private TableColumn<?, ?> ColType;

    @FXML
    private LineChart<?, ?> LineChart;

    @FXML
    private TableView<?> tblRecentActivity;

    @FXML
    private Text txtPurchase;

    @FXML
    private Text txtStock;

    @FXML
    private Text txtTotalSale;

}
