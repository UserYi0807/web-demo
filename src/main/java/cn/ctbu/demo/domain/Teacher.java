package cn.ctbu.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name="tb_teacher")
public class Teacher {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}
