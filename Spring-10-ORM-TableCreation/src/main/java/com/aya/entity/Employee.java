package com.aya.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private int id;
    private String name;
}
