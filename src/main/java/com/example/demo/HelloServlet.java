package com.example.demo;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        switch (action) {
//            case "create":
//                createPost(req, resp);
//                break;
//            case "update":
//                updatePost(req, resp);
//                break;
//            case "login":
//                loginAcc(req, resp);
//                break;
//            case "search":
//                searchByName(req, resp);
//                break;
//            case "adminEdit":
//                adminEditPost(req, resp);
//                break;
//            case "roleUpdate":
//                roleUpdatePost(req, resp);
//                break;
//            case "roleCreate":
//                roleCreatePost(req, resp);
//                break;
//
//        }
//    }

    //------------------------

    private String create = "insert into book (idPublisher, idCategory, idLocation, name, img, description, status) values (?,?,?,?,?,?,?);";
//    private  String update= "update book set idPublisher = ?,idCategory =?,idLocation=?,name=?,img=?,description=?,status=?  where id=?;";
//    private String delete = "delete from book where id = ?;";
//    private  String search = "select * from book where name LIKE ?;";
//
//    public BookDAO() {
//        connection = new MyConnection().getConnection();
//        categoryDAO = new CategoryDAO();
//        locationDAO = new LocationDAO();
//        publisherDAO = new PublisherDAO();
//    }
//    @Override
//    public List<Book> findAll() {
//        List<Book> books = new ArrayList<>();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(list);){
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int id = Integer.parseInt(resultSet.getString("id"));
//                int idPublisher = Integer.parseInt(resultSet.getString("idPublisher"));
//                int idCategory = Integer.parseInt(resultSet.getString("idCategory"));
//                int idLocation = Integer.parseInt(resultSet.getString("idLocation"));
//                String name = resultSet.getString("name");
//                String img = resultSet.getString("img");
//                String description = resultSet.getString("description");
//                String status = resultSet.getString("status");
//                Publisher publisher = publisherDAO.findOne(idPublisher);
//                Category category = categoryDAO.findOne(idCategory);
//                Location location = locationDAO.findOne(idLocation);
//
//                Book book = new Book(id,publisher,category,location,name,img,description,status);
//                books.add(book);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return books;
//    }
//------------ connection---------------









    //-------------------------JSP---------------

//


}