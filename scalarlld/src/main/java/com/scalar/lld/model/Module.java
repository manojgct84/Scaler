package com.scalar.lld.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Module")
public class Module extends BaseModel {
    private String name;
    @ManyToMany
    private List<Student> enrolledStudents;
    @OneToMany(mappedBy = "module")
    private List<ModuleExam> moduleExams;
}

