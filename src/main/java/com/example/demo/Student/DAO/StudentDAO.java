package com.example.demo.Student.DAO;
import com.example.demo.Student.Model.ClassRom;
import com.example.demo.Student.Model.Student;
import com.example.demo.Student.MyConnection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    String SELECT_ALL = "SELECT s.id,s.name,s.email,s.dateOfBirth,s.address,s.PhoneNumber, c.id as idClassRoom FROM student s JOIN class_room c ON s.idClassRoom= c.id;";
    String SELECT_BY_ID = "SELECT s.id,s.name,s.email,s.dateOfBirth,s.address,s.PhoneNumber, c.id as idClassRoom FROM student s JOIN class_room c ON s.idClassRoom= c.id where s.id = ?;";

    String ADD_STUDENT = "insert into student(name, email, dateOfBirth, address, PhoneNumber,idClassRoom) value (?,?,?,?,?,?);";
    String UPDATE_STUDENT = "update student set name = ?, email = ?, dateOfBirth = ?, address = ? , PhoneNumber = ?, idClassRoom = ? where id = ?";
    String DELETE_STUDENT = "delete from student where id = ?";
    ClassRoomDAO classRoomDAO;
    Connection connection;
    public StudentDAO(){
        classRoomDAO = new ClassRoomDAO();
        connection = new MyConnection().getConnection();
    }
    public List<Student> finAll(){
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                LocalDate dateOfBirth = LocalDate.parse(resultSet.getString("dateOfBirth"));
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("PhoneNumber");
                int idClass = resultSet.getInt("idClassRoom");
                ClassRom classRom = classRoomDAO.finOne(idClass);
                students.add(new Student(id, name, email, dateOfBirth, address, phoneNumber,classRom));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }
    public Student finOne(int id) {
        Student student = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                LocalDate dateOfBirth = LocalDate.parse(resultSet.getString("dateOfBirth"));
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("PhoneNumber");
                int idClass = resultSet.getInt("idClassRoom");
                ClassRom classRom = classRoomDAO.finOne(idClass);
                student = new Student(id, name, email, dateOfBirth, address, phoneNumber,classRom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void create(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_STUDENT)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getDateOfBirth().toString());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhoneNumber());
            preparedStatement.setInt(6, student.getClassRom().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getDateOfBirth().toString());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhoneNumber());
            preparedStatement.setInt(6, student.getClassRom().getId());
            preparedStatement.setInt(7, student.getId());
                        preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
