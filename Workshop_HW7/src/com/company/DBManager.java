package com.company;
import java.sql.*;

public class DBManager {
    private static DBManager instance= null;
    private DBManager(){}
    public static DBManager getInstance()
    {
        if (instance == null)
            instance = new DBManager();

        return instance;
    }
    public void printStudents(){
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ariya",
                "myjava123")) {
            Class.forName("oracle.jdbc.driver.OracleDriver");// for old versions of JDBC

            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("select * from students");
            ResultSet rs = preparedStatement1.executeQuery();
            while(rs.next()){
                System.out.println("ID : "+rs.getInt("id")+"   Name : "+rs.getString("name")+"   Family : "+rs.getString("family")+"   Average : "+rs.getFloat("average"));
            }

            connection.close();


        } catch (ClassNotFoundException e)// if no lib files are added
        {
            System.out.println("DB Driver Not Exist!!");
        } catch (SQLException e)
        {
            System.out.println("DB ERROR " + e.getMessage());
        }

    }
    public float totalaverage(){
        float sum = 0;
        float average = 0;
        int count=0;
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ariya",
                "myjava123")) {
            Class.forName("oracle.jdbc.driver.OracleDriver");// for old versions of JDBC

            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("select average from students");
            ResultSet rs = preparedStatement1.executeQuery();
            while(rs.next()){
            sum += rs.getFloat("average");
            count +=1;
            }
            average=sum/(float)count;
            connection.close();


        } catch (ClassNotFoundException e)// if no lib files are added
        {
            System.out.println("DB Driver Not Exist!!");
        } catch (SQLException e)
        {
            System.out.println("DB ERROR " + e.getMessage());
        }
        return average;
    }
    public void insert(Student student){
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ariya",
                "myjava123")) {
            Class.forName("oracle.jdbc.driver.OracleDriver");// for old versions of JDBC

            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("insert into STUDENTS (id,name,family,average) values (?,?,?,?)");
            preparedStatement1.setInt(1, student.getId());
            preparedStatement1.setString(2, student.getName());
            preparedStatement1.setString(3, student.getFamily());
            preparedStatement1.setFloat(4, student.getAverage());
            preparedStatement1.executeUpdate();

            connection.close();

        } catch (ClassNotFoundException e)// if no lib files are added
        {
            System.out.println("DB Driver Not Exist!!");
        } catch (SQLException e)
        {
            System.out.println("DB ERROR " + e.getMessage());
        }
    }
    public void edit(Student student){
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ariya",
                "myjava123")) {
            Class.forName("oracle.jdbc.driver.OracleDriver");// for old versions of JDBC

            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("update students set name=?, family=? ,average=? WHERE id=?");
            preparedStatement1.setString(1, student.getName());
            preparedStatement1.setString(2, student.getFamily());
            preparedStatement1.setFloat(3, student.getAverage());
            preparedStatement1.setInt(4, student.getId());
            preparedStatement1.executeUpdate();

            connection.close();

        } catch (ClassNotFoundException e)// if no lib files are added
        {
            System.out.println("DB Driver Not Exist!!");
        } catch (SQLException e)
        {
            System.out.println("DB ERROR " + e.getMessage());
        }
    }
    public void delete(int id){
        try (Connection connection2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ariya",
                "myjava123")) {
            Class.forName("oracle.jdbc.driver.OracleDriver");// for old versions of JDBC

            PreparedStatement preparedStatement1 =
                    connection2.prepareStatement("delete from students WHERE id=?");
            preparedStatement1.setInt(1, id);
            preparedStatement1.executeUpdate();
            //connection2.commit();
            // connection2.close();

        } catch (ClassNotFoundException e)// if no lib files are added
        {
            System.out.println("DB Driver Not Exist!!");
        } catch (SQLException e)
        {
            System.out.println("DB ERROR " + e.getMessage());
        }
    }
}
