package Controller;

import Model.Entity.CTCEntity;
import Model.Service.CTCService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField addfieldfrom;

    @FXML
    private TextField addfieldcost;

    @FXML
    private TextField addfieldto;

    @FXML
    private Button addbtn;

    @FXML
    private TableView<CTCEntity> table;

    @FXML
    private TableColumn<CTCEntity, Integer> columnid;

    @FXML
    private TableColumn<CTCEntity, Integer> columnfrom;

    @FXML
    private TableColumn<CTCEntity, Integer> columnto;

    @FXML
    private TableColumn<CTCEntity, Integer> columncost;

    @FXML
    private TextField editfieldfrom;

    @FXML
    private TextField editfieldcost;

    @FXML
    private TextField editfieldto;

    @FXML
    private TextField editfieldid;

    @FXML
    private Button editbtndelete;

    @FXML
    private Button editbtnsubmit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnfrom.setCellValueFactory(new PropertyValueFactory<>("from"));
        columnto.setCellValueFactory(new PropertyValueFactory<>("to"));
        columnid.setCellValueFactory(new PropertyValueFactory<>("id"));
        columncost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        refresh();

    }
    public void refresh(){
        table.setItems(CTCService.getInstance().getData());
    }
    @FXML
    public void btnadd(ActionEvent event) {
        if(addfieldto.getText().equals("") | addfieldcost.getText().equals("") | addfieldfrom.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Card To Card Application");
            alert.setHeaderText("خطا");
            alert.setContentText("اطلاعات کامل وارد نشده");
            alert.showAndWait();
        }else{
            CTCService.getInstance().add(addfieldfrom.getText(),addfieldto.getText(),addfieldcost.getText());
            refresh();
        }
    }

    @FXML
    void btndel(ActionEvent event) {
        if(editfieldid.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Card To Card Application");
            alert.setHeaderText("خطا");
            alert.setContentText("ردیف مورد نظر را وارد کنید");
            alert.showAndWait();
        }else{
            CTCService.getInstance().delete(editfieldid.getText());
            refresh();
        }
    }

    @FXML
    void btnedit(ActionEvent event) {
        if(editfieldid.getText().equals("") | editfieldfrom.getText().equals("") | editfieldcost.getText().equals("") |editfieldto.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Card To Card Application");
            alert.setHeaderText("خطا");
            alert.setContentText("اطلاعات کامل وارد نشده");
            alert.showAndWait();
        }else{
            CTCService.getInstance().edit(editfieldid.getText(),addfieldfrom.getText(),addfieldto.getText(),addfieldcost.getText());
            refresh();
        }

    }


}
