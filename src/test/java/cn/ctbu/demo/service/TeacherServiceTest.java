package cn.ctbu.demo.service;

import cn.ctbu.demo.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    void findMax() {
        Teacher teacher = teacherService.findMax();

        assertEquals(teacher.getId(), 2020413331);
    }
}