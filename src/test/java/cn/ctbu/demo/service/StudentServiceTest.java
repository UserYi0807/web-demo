package cn.ctbu.demo.service;

import cn.ctbu.demo.domain.Student;
import cn.ctbu.demo.repository.StudentRepository;
import cn.ctbu.demo.service.impl.StudentImplService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void findAll() {
        List<Student> students = studentService.findAll();

        assertNotNull(students);
    }

    @Test
    public void contextLoads() {
        Student student = new Student();
        student.setId(2020413329);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 10, sort);
        Example<Student> example = Example.of(student);
        Page<Student> page = studentService.findAll(example, pageable);
        System.out.println(page);
    }
}