package repository;

import model.Student;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepositoryImpl implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student("Hung",25,1));
        studentList.add(new Student("Then",22,1));
        studentList.add(new Student("Nhi",21,2));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }

    @Override
    public boolean update(Student student) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return studentList.remove(id);
    }
}
