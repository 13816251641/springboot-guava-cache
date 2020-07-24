package com.lujieni.springbootguavacache.damain.po;

import com.lujieni.springbootguavacache.mybatis.entity.BasicEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_student")
@Data
@Accessors(chain = true)
public class StudentPO extends BasicEntity {

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;

    @Column(name="gender")
    private String gender;

}