package cn.ctbu.demo.repository;

import cn.ctbu.demo.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value = "select * from tb_teacher order by id desc limit 1;", nativeQuery = true)
    Teacher findByMaxId();
}
