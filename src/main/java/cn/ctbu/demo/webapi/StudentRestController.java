package cn.ctbu.demo.webapi;

import cn.ctbu.demo.core.PageUtils;
import cn.ctbu.demo.domain.Student;
import cn.ctbu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam(value = "name", defaultValue = "") String name,
                               @RequestParam(value = "id", defaultValue = "") String id) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Page<Student> studentPage;

        if (name.isEmpty() && id.isEmpty()) {
            Pageable pageable = PageRequest.of(page, size, sort);
            studentPage = studentService.findAll(pageable);
        }
        else if (!id.isEmpty()) {
            Student student = new Student();
            student.setName(name);
            student.setId(Integer.valueOf(id));

            Pageable pageable = PageRequest.of(page, size, sort);

            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                    .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.exact());

            Example<Student> example = Example.of(student, matcher);
            studentPage = studentService.findAll(example, pageable);
        }
        else {
            Student student = new Student();
            student.setName(name);

            Pageable pageable = PageRequest.of(page, size, sort);

            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Student> example = Example.of(student, matcher);
            studentPage = studentService.findAll(example, pageable);
        }

        PageUtils pageUtils = new PageUtils(studentPage.getContent(), studentPage.getTotalElements());
        return pageUtils;
    }
}
