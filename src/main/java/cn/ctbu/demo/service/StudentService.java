package cn.ctbu.demo.service;

import cn.ctbu.demo.domain.Student;
import cn.ctbu.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student insert(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }

    public Student getById(int id) {

        return studentRepository.findById(id).orElse(null);
    }

}
