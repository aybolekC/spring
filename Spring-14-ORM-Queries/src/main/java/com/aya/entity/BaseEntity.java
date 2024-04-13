package com.aya.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntity {

    @Id
    private Long id;




}
