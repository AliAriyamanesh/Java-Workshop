package Model.Repository;

import Model.Entity.CTCEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CTCRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public CTCRepository() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ariya", "myjava123");
        connection.setAutoCommit (false);     }
    public List<CTCEntity> select() throws Exception{
        preparedStatement=connection.prepareStatement ("SELECT * FROM CARDTOCARD");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<CTCEntity> ctcEntityList=new ArrayList<>();
        while (resultSet.next ()){
           CTCEntity entity=new CTCEntity();
           entity.setId(resultSet.getInt("id"));
           entity.setFrom(resultSet.getInt("CFROM"));
           entity.setTo(resultSet.getInt("cto"));
           entity.setCost(resultSet.getInt("cost"));
           ctcEntityList.add(entity);
        }
        return ctcEntityList;
    }
    public void insert(CTCEntity entity) throws SQLException {
        int id=1;
        preparedStatement=connection.prepareStatement ("select ID from CARDTOCARD ");
        ResultSet set = preparedStatement.executeQuery();
        if (set.next()){
            id=set.getRow() + 1;
        }
        preparedStatement=connection.prepareStatement ("insert into CARDTOCARD (ID , CFROM, CTO, COST) values (?,?,?,?)");
        preparedStatement.setInt (1,id);
        preparedStatement.setInt (2,entity.getFrom());
        preparedStatement.setInt (3,entity.getTo());
        preparedStatement.setInt (4,entity.getCost());
        preparedStatement.executeUpdate ();
    }
    public void edit (CTCEntity entity) throws SQLException {
        preparedStatement=connection.prepareStatement ("update CARDTOCARD set CFROM = ? , CTO = ? , COST = ? where ID =?");
        preparedStatement.setInt (1,entity.getFrom());
        preparedStatement.setInt (2,entity.getTo());
        preparedStatement.setInt (3,entity.getCost());
        preparedStatement.setInt (4,entity.getId());
        preparedStatement.executeUpdate ();
    }
    public void delete (int id) throws SQLException {
        preparedStatement=connection.prepareStatement ("DELETE FROM CARDTOCARD WHERE id =?");
        preparedStatement.setInt (1,id);
        preparedStatement.executeUpdate ();
    }
    @Override
    public void close() throws Exception {
        connection.close();
    }
    public void commit() throws Exception{
        connection.commit ();
    }
    public void rollback() throws Exception{
        connection.rollback ();
    }
}
