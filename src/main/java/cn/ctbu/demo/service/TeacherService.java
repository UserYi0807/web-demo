package cn.ctbu.demo.service;

import cn.ctbu.demo.domain.Teacher;
import cn.ctbu.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher findMax() {
        return teacherRepository.findByMaxId();
    }
}
