package com.example.redis_demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author dengR
 * @date 2022/4/27 20:31
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private List<Integer> scores;
}
