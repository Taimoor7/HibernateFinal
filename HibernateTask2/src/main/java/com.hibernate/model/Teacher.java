package com.hibernate.model;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private int tid;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @OneToMany(fetch = FetchType.LAZY
            ,mappedBy = "teacher" ,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
   private List<Courses> courses;


    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +

                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public Teacher(String first_name, String last_name) {

        this.first_name = first_name;
        this.last_name = last_name;

    }



    //Default Constructor
    public Teacher(){


    }


    //Adding a convenience method for bi-directional relationship

    public void add(Courses tempCourse){
        if (courses==null){
            courses=new ArrayList<>();
        }

        courses.add(tempCourse);
        tempCourse.setTeacher(this);
    }
}
