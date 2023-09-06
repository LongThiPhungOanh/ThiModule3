package com.example.demo.Student.Controller;
import com.example.demo.Student.Model.ClassRom;
import com.example.demo.Student.Model.Student;
import com.example.demo.Student.Service.StudentService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    StudentService service;
    @Override
    public void init() throws ServletException {
        service = new StudentService();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                listProduct(request,response);
                break;
            case "create":
                createGetProduct(request,response);
                break;
            case "update":
                updateGetProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;

        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPostProduct(request, response);
                break;
            case "update":
                updatePostProduct(request, response);
                break;
            case "searchByName":
                searchByName(request, response);
                break;
        }
    }

    public void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = service.finnAll();
        List<ClassRom> classRoms = service.finnAllClass();
        request.setAttribute("students", students);
        request.setAttribute("classRoms",classRoms);
        RequestDispatcher rq = request.getRequestDispatcher("student/list.jsp");
        rq.forward(request, response);
    }

    public void updateGetProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ClassRom> classRoms = service.finnAllClass();
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = service.findOne((id));
        request.setAttribute("student", student);
        request.setAttribute("classRoms",classRoms);
        RequestDispatcher rq = request.getRequestDispatcher("student/update.jsp");
        rq.forward(request, response);
    }
    private void updatePostProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.update(request, id);
        response.sendRedirect("/students");
    }
    public void createGetProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ClassRom> classRoms = service.finnAllClass();
        request.setAttribute("classRoms", classRoms);
        RequestDispatcher rq = request.getRequestDispatcher("student/create.jsp");
        rq.forward(request, response);
    }
    public void createPostProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        service.create(request);
        response.sendRedirect("/students");
    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("/students");
    }
    public void searchByName( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Student> students = service.searchByName(name);
        request.setAttribute("students", students);
        RequestDispatcher rq = request.getRequestDispatcher("student/searchByName.jsp");
        rq.forward(request, response);
    }

}
