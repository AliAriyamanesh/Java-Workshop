package Model.Service;

import Model.Entity.CTCEntity;
import Model.Repository.CTCRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class CTCService {
    private static CTCService instance = new CTCService();
    private CTCService() {    }
    public static CTCService getInstance() {
        return instance;
    }
    public void add(String from , String to,String cost){
        CTCRepository repository;
        try {
            repository = new CTCRepository();
            CTCEntity entity = new CTCEntity(Integer.parseInt(from),Integer.parseInt(to),Integer.parseInt(cost));
            repository.insert(entity);
            repository.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void edit(String id,String from , String to,String cost) {
        CTCRepository repository;
        try {
            repository = new CTCRepository();
            CTCEntity entity = new CTCEntity(Integer.parseInt(from), Integer.parseInt(to), Integer.parseInt(cost),Integer.parseInt(id));
            repository.edit(entity);
            repository.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(String id) {
        CTCRepository repository;
        try {
            repository = new CTCRepository();
            repository.delete(Integer.parseInt(id));
            repository.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ObservableList getData() {
       ObservableList list = FXCollections.observableArrayList();
        CTCRepository repository;
        try {
            repository = new CTCRepository();
            List<CTCEntity> ctcEntityList=repository.select();
            for(CTCEntity entity :ctcEntityList){
                list.add(entity);
            }
            list.add(repository.select());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    }
