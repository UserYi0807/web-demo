package cn.ctbu.demo.service.impl;

import cn.ctbu.demo.domain.Student;
import cn.ctbu.demo.exception.REnum;
import cn.ctbu.demo.exception.RException;
import cn.ctbu.demo.repository.StudentRepository;
import cn.ctbu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImplService implements StudentService {

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

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> findAll(Example<Student> studentExample, Pageable pageable) {
        return studentRepository.findAll(studentExample, pageable);
    }

    public Student findByNameAndPassword2(String name, String password) throws Exception{
        List<Student> byNameAndPassword = studentRepository.findByNameAndPassword(name, password);
        if (byNameAndPassword.size() > 0) {
            return byNameAndPassword.get(0);
        } else {
            throw new RException(REnum.LOGIN_ERR);
        }
    }

    public List<Student> findByNameAndPassword(String name, String password){
        return studentRepository.findByNameAndPassword(name, password);
    }
}
