package com.michups.classregister.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by michups on 15.07.17.
 */
@Getter
@Setter
public class Grade {

    private Integer id;
    private Integer number;
    private String alfabetDigit;
    private Integer year;
    private Grade grade;



}
