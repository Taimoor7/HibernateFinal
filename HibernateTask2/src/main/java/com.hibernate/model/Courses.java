package com.hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private int cid;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;


    @ManyToMany(fetch = FetchType.LAZY,
          cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "courses_students",
            joinColumns = @JoinColumn(name="cid"),
            inverseJoinColumns =@JoinColumn(name = "sid")
    )
    private List<Student> student;

    @ManyToOne(fetch = FetchType.LAZY
            ,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "tid",nullable = true)
    private Teacher teacher;


    //Default Constructor
    public Courses(){

    }

    public Courses(String name, String code) {
//        this.cid = cid;
        this.name = name;
        this.code = code;

    }

    @Override
    public String toString() {
        return "Courses{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
//                ", student=" + student +
//                ", teacher=" + teacher +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public List<Student> getStudents() {
        return student;
    }

    public void setStudents(List<Student> student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    //Adding Covenience Method to add Student to a course

    public void addStudent(Student theStudent){
        if (student==null){
            student=new ArrayList<>();
        }

        student.add(theStudent);

    }


}

