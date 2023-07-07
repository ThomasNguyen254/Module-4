package repository;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    boolean add(Student student);

    boolean update(Student student) throws SQLException;

    boolean delete(String id);
}
