package cn.ctbu.demo.webapi;

import cn.ctbu.demo.core.PageUtils;
import cn.ctbu.demo.domain.Student;
import cn.ctbu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/student")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public List<Student> getAll() {

        return studentService.findAll();
    }

    @PostMapping("/insert")
    public Student insert(Student student) {

        return studentService.insert(student);
    }

    @PutMapping("/delete")
    public void delete(Student student) {

        studentService.delete(student);
    }

    @GetMapping("/get/{id}")
    public Student get(@PathVariable int id) {

        Student student = studentService.getById(id);
        student.setPassword("");
        return student;
    }

    @PutMapping("/update")
    public Student update(Student student) {
        return studentService.insert(student);
    }

    @GetMapping("/getByPage")
    public PageUtils getByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Student> studentPage = studentService.findAll(pageable);

        PageUtils pageUtils = new PageUtils(studentPage.getContent(), studentPage.getTotalElements());
        return pageUtils;
    }
}
