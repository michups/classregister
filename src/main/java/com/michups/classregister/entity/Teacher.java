package com.michups.classregister.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by michups on 15.07.17.
 */
@Getter
@Setter
public class Teacher {

    private Integer id;
    private String firstName;
    private String lastName;
    private Grade mainClass;
    private String email;

}
