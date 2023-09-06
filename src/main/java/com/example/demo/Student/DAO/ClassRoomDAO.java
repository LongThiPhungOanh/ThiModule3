package com.example.demo.Student.DAO;
import com.example.demo.Student.Model.ClassRom;
import com.example.demo.Student.MyConnection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomDAO {
    String SELECT_ALL = "SELECT * FROM class_room;";
    String SELECT_BY_ID = " SELECT * FROM class_room where id = ?;";
    Connection connection;
    public ClassRoomDAO(){
        connection = new MyConnection().getConnection();
    }
    public List<ClassRom> finAll(){
        List<ClassRom> classRoms = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                classRoms.add(new ClassRom(id, name));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return classRoms;
    }

    public ClassRom finOne(int id) {
        ClassRom classRom = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("id");
                String name = resultSet.getString("name");
                classRom = new ClassRom(idDB, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classRom;
    }
}
