package cn.ctbu.demo.webapi;

import cn.ctbu.demo.domain.Student;
import cn.ctbu.demo.helper.RUtil;
import cn.ctbu.demo.service.StudentService;
import cn.ctbu.demo.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/webapi/login")
public class LoginApiController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public R student(String name, String password) throws Exception{
        Student student = studentService.findByNameAndPassword2(name, password);
        return RUtil.success(student);
    }

    @GetMapping("/user")
    public int user(HttpServletRequest httpRequest, String username, String password){
        List<Student> students = studentService.findByNameAndPassword(username, password);

        if (students.size() > 0) {
            HttpSession session = httpRequest.getSession();
            session.setAttribute("userid", students.get(0).getId());
            session.setAttribute("user", students.get(0));
            return 1;
        }

        return -1;
    }
}
