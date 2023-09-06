package com.example.demo.Student.Service;
import com.example.demo.Student.DAO.ClassRoomDAO;
import com.example.demo.Student.DAO.StudentDAO;
import com.example.demo.Student.Model.ClassRom;
import com.example.demo.Student.Model.Student;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;

public class StudentService {
     StudentDAO studentDAO;
     ClassRoomDAO classRoomDAO;
        public StudentService() {
        studentDAO = new StudentDAO();
        classRoomDAO = new ClassRoomDAO();
        }

        public Student findOne(int id) {
            return studentDAO.finOne(id);
        }

        public List<Student> finnAll(){
            return studentDAO.finAll();
        }


        public void create(HttpServletRequest request){
            Student student = returnObj(request);
            studentDAO.create(student);
        }
        public Student returnObj(HttpServletRequest request){
            Student student;
            String name =request.getParameter("name");
            String email =request.getParameter("email");
            LocalDate date = LocalDate.parse(request.getParameter("date"));
            String address =request.getParameter("address");
            String phone =request.getParameter("phone");
            int id = Integer.parseInt(request.getParameter("classRoom"));
            ClassRom classRom = finnOneClass(id);
            student = new Student(name, email, date, address, phone, classRom);
            return student;
        }
        public void update(HttpServletRequest request, int id) {
            Student student = returnObj(request);
            student.setId(id);
            studentDAO.update(student);
        }

        public void delete(int id) {
                studentDAO.delete(id);
        }
    public List<ClassRom> finnAllClass(){
        return classRoomDAO.finAll();
    }
    public ClassRom finnOneClass(int id){
        return classRoomDAO.finOne(id);
    }
    public List<Student> searchByName(String name){
        List<Student> students = finnAll();
        List<Student> studentList = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                studentList.add(s);
            }
        }
        return studentList;
    }
}
