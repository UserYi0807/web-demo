package cn.ctbu.demo.repository;

import cn.ctbu.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameAndPassword(String name, String password);
}
