package com.scalar.lld.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ModuleExam")
public class ModuleExam extends BaseModel {
    @ManyToOne
    private Exam exam;
    @ManyToOne
    private Module module;
    private Date examDate;
}
