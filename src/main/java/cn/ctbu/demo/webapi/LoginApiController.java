package cn.ctbu.demo.webapi;

import cn.ctbu.demo.domain.Student;
import cn.ctbu.demo.helper.RUtil;
import cn.ctbu.demo.service.StudentService;
import cn.ctbu.demo.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginApiController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public R student(String name, String password) throws Exception{
        Student student = studentService.findByNameAndPassword(name, password);
        return RUtil.success(student);
    }
}
