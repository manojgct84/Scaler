package com.scalar.lld.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Exam")
public class Exam extends  BaseModel {

    private int duration;
    private String name;
}
