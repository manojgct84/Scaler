package com.scalar.lld.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Student")
public class Student extends BaseModel {

    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String password;
    @ManyToMany(mappedBy = "enrolledStudents")
    private List<Module> enrolledModules;
}
