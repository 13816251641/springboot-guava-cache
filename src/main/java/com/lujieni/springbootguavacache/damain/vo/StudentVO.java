package com.lujieni.springbootguavacache.damain.vo;


import lombok.Data;

/**
 * 个人觉得VO比较偏向于和界面打交道,
 * 因为有些PO里的字段太多了,页面并
 * 不需要这么多所以就有了VO
 */
@Data
public class StudentVO {

    private Integer id;

    private String name;

    private Integer age;
}
