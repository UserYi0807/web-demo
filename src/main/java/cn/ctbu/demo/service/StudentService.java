package cn.ctbu.demo.service;

import cn.ctbu.demo.domain.Student;
import cn.ctbu.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();

    Student insert(Student student);

    void delete(Student student);

    Student getById(int id);

    /*只支持分页的查询*/
    Page<Student> findAll(Pageable pageable);
}
