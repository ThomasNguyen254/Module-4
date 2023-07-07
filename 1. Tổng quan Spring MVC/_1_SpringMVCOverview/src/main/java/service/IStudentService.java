package service;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    boolean add(Student student);

    boolean update(Student student) throws SQLException;

    boolean delete(String id);
}
