package cn.ctbu.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * 针对 tb_student 的实体类
 */
@Data
@Entity(name="tb_student")
public class Student {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 姓名
    private String name;
    // 密码
    private String password;
    // 性别
    private Integer sex;
    // 年龄
    private Integer age;
    // 成绩
    private Integer score;
}
