package com.aya.model;

import com.aya.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Mentor {

    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
}
