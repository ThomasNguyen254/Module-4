package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IStudentRepository;
import repository.StudentRepositoryImpl;

import java.sql.SQLException;
import java.util.List;
@Service
public class StudentImpl implements IStudentService{
    @Autowired
    IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.add(student);
    }

    @Override
    public boolean update(Student student) throws SQLException {
        return studentRepository.update(student);
    }

    @Override
    public boolean delete(String id) {
        return studentRepository.delete(id);
    }
}
