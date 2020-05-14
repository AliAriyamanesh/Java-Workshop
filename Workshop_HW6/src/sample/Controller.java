package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML TableView<Product> carttableView;
    @FXML TableColumn<Product,String> cartnamecolumn;
    @FXML TableColumn<Product,Integer> cartcountcolumn;
    @FXML TableColumn<Product,Integer> cartpricecolumn;

    @FXML TableView<Product> hcarttableView;
    @FXML TableColumn<Product,String> hcartnamecolumn;
    @FXML TableColumn<Product,Integer> hcartcountcolumn;
    @FXML TableColumn<Product,Integer> hcartpricecolumn;

    @FXML TableView<Customer> historytable;
    @FXML TableColumn<Customer,String> historycolumnname;

    @FXML TextField productnameField;
    @FXML TextField productpriceField;
    @FXML TextField productstockField;
    @FXML TextField totalpriceField;
    @FXML Slider productSlider;
    @FXML Button buttonnewcustomer;
    @FXML Button buttonHistory;
    @FXML Button hcartback;
    @FXML MenuButton menubutton;
    @FXML Button buttontoggle;
    @FXML Button buttonsubmit;
    @FXML Button buttonaddtocart;
    @FXML TextField customernamefield;
    @FXML Pane customerPane;
    @FXML Pane productPane;
    @FXML Pane cartPane;
    @FXML Pane historyPane;
    ObservableList<Product> carttableobservable = FXCollections.observableArrayList();
    ObservableList<Customer> historytableobservable = FXCollections.observableArrayList();


    Map<String,Product> productsmap = new HashMap<>();
    public void newCustomer (ActionEvent event){
    customerPane.setDisable(false);
    historyPane.setVisible(false);
    }

    public void menuSelection (ActionEvent event){
        productPane.setDisable(false);
        productnameField.setText(productsmap.get(((MenuItem) event.getSource()).getText()).getName());
        productpriceField.setText(Integer.toString( productsmap.get(((MenuItem) event.getSource()).getText()).getPrice()));
        productstockField.setText(Integer.toString( productsmap.get(((MenuItem) event.getSource()).getText()).getStock()));
        totalpriceField.setText(Integer.toString( productsmap.get(((MenuItem) event.getSource()).getText()).getPrice()));
        productSlider.setVisible(true);
        productSlider.setDisable(false);
        menubutton.setText(((MenuItem) event.getSource()).getText());
    }
    public void addCustomer (ActionEvent event){
        if (customernamefield.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("هشدار");
            alert.setHeaderText("اطلاعات کامل نیست");
            alert.setContentText("نام متقاضی نمی تواند خالی باشد !");
            alert.showAndWait();
        }else if (carttableobservable.size() == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("هشدار");
            alert.setHeaderText("سبد خرید خالی است");
            alert.setContentText("از منوی افزودن محصول استفاده کنید !");
            alert.showAndWait();
        }
         else   {
                historytableobservable.add(new Customer(carttableobservable,customernamefield.getText()));
                carttableobservable.clear();
                carttableView.setItems(carttableobservable);
                cartPane.setVisible(false);
            buttontoggle.setText("مشاهده سبد خرید "+"("+ carttableobservable.size()+")");
            productSlider.setDisable(true);
            productnameField.setText("");
            totalpriceField.setText("");
            productstockField.setText("");
            productpriceField.setText("");
            productPane.setDisable(true);
            customernamefield.setText("");
            customerPane.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("عملیات موفقیت آمیز");
            alert.setHeaderText("متقاضی جدید افزوده شد !");
            alert.setContentText("از طریق دکمه بایگانی می توانید فهرست متقاضی ها را مشاهده کنید");
            alert.showAndWait();
            }
        }


    public void addToCard (ActionEvent event){
        int sliderval = (int) productSlider.getValue();
        carttableobservable.add(new Product(productnameField.getText(),Integer.parseInt(productpriceField.getText()),sliderval));
        carttableView.setItems(carttableobservable);
        buttontoggle.setText("مشاهده سبد خرید "+"("+ carttableobservable.size()+")");
        productSlider.setValue(1);
        productSlider.setDisable(true);
        productnameField.setText("");
        totalpriceField.setText("");
        productstockField.setText("");
        productpriceField.setText("");
        productPane.setDisable(true);
        menubutton.setText("افزودن محصول");
    }
    public void historyButton (ActionEvent event){
       historyPane.setVisible(true);
        hcarttableView.setVisible(false);
        hcartback.setVisible(false);
       historytable.setItems(historytableobservable);
    }
    public void toggleButton (ActionEvent event){
        if (cartPane.isVisible()){
            cartPane.setVisible(false);
            buttontoggle.setText("مشاهده سبد خرید "+"("+ carttableobservable.size()+")");
            menubutton.setDisable(false);
        }else{
            cartPane.setVisible(true);
            menubutton.setDisable(true);
            buttontoggle.setText("بازگشت");
        }

    }
    public void sliderChanged (){
      int sliderval = (int) productSlider.getValue();
      totalpriceField.setText(Integer.toString(sliderval * productsmap.get(productnameField.getText()).getPrice()));
    }
    public void hcartbackbutton (ActionEvent event){
        hcarttableView.setVisible(false);
        hcartback.setVisible(false);
        historytable.setVisible(true);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //------ Predefined products
        productsmap.put("سیب",new Product(1300,1000,"سیب"));
        productsmap.put("موز",new Product(12000,100,"موز"));
        productsmap.put("پرتقال",new Product(8000,500,"پرتقال"));
        productsmap.put("انار",new Product(5000,150,"انار"));
        productsmap.put("طالبی",new Product(6000,50,"طالبی"));
        productsmap.put("هندوانه",new Product(2750,60,"هندوانه"));
        //------ Predefined customers
        historytableobservable.addAll(new Customer(FXCollections.observableArrayList(new Product("سیب",1300,5),new Product("موز",12000,2)),"محمرضا کریمی") , new Customer(FXCollections.observableArrayList(new Product("طالبی",6000,3)),"احسان نقوی") , new Customer(FXCollections.observableArrayList(new Product("انار",5000,10)),"رضا شریعتی"));

        cartnamecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        cartcountcolumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        cartpricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        hcartnamecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        hcartcountcolumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        hcartpricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        historycolumnname.setCellValueFactory(new PropertyValueFactory<>("name"));
        addButtonToTableCart();
        addButtonToTableHistory();
        carttableView.setItems(carttableobservable);
        historytable.setItems(historytableobservable);
    }
    private void addButtonToTableCart() {
        TableColumn<Product, Void> colBtn = new TableColumn("");
        Callback<TableColumn<Product, Void>, TableCell<Product, Void>> cellFactory = new Callback<TableColumn<Product, Void>, TableCell<Product, Void>>() {
            @Override
            public TableCell<Product, Void> call(final TableColumn<Product, Void> param) {
                final TableCell<Product, Void> cell = new TableCell<Product, Void>() {
                    private final Button btn = new Button("حذف");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Product data = getTableView().getItems().get(getIndex());
                            carttableobservable.remove(data);
                            carttableView.setItems(carttableobservable);

                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        colBtn.setPrefWidth(74);
        carttableView.getColumns().add(colBtn);

    }
    private void addButtonToTableHistory() {
        TableColumn<Customer, Void> colBtn = new TableColumn("سبد خرید");
        Callback<TableColumn<Customer, Void>, TableCell<Customer, Void>> cellFactory = new Callback<TableColumn<Customer, Void>, TableCell<Customer, Void>>() {
            @Override
            public TableCell<Customer, Void> call(final TableColumn<Customer, Void> param) {
                final TableCell<Customer, Void> cell = new TableCell<Customer, Void>() {
                    private final Button btn = new Button("مشاهده سبد خرید");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Customer data = getTableView().getItems().get(getIndex());
                            hcarttableView.setItems(data.getObservableList());
                            historytable.setVisible(false);
                            hcarttableView.setVisible(true);
                            hcartback.setVisible(true);
                            });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        colBtn.setPrefWidth(130);
       historytable.getColumns().add(colBtn);

    }
}
