package com.michups.classregister.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by michups on 15.07.17.
 */
@Getter
@Setter
public class Student {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Grade grade;
    private Date bithDate;


}
