package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedHashSet;
import java.util.Set;

public class Customer {
    private ObservableList<Product> observableList;
    private SimpleStringProperty name;

    public Customer(ObservableList<Product> observableList, String name) {
        this.observableList = FXCollections.observableArrayList();
        this.observableList.setAll(observableList);
        this.name = new SimpleStringProperty(name);
    }

    public ObservableList<Product> getObservableList() {
        return observableList;
    }

    public Customer setObservableList(ObservableList<Product> observableList) {
        this.observableList = observableList;
        return this;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
