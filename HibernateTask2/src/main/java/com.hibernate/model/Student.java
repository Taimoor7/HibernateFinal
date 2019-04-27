package com.hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private int sid;

    @Column(name = "first_name")
    private String first_name;


    @Column(name = "last_name")
    private String last_name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "courses_students",
            joinColumns = @JoinColumn(name = "sid"),
            inverseJoinColumns = @JoinColumn(name = "cid")
    )
    private List<Courses> courses;


    public void addCourses(Courses cs){
        if (courses==null){
            courses=new ArrayList<>();
        }
        courses.add(cs);
    }

    public void removeCourses(Courses cs){
        if(courses!=null && cs!=null){
            courses.remove(cs);
        }
    }

    @OneToOne(mappedBy = "student",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Addresses addresses;

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +

                '}';
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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



    public Student( String first_name, String last_name) {

        this.first_name = first_name;
        this.last_name = last_name;

    }

    //Default Constructor
    public Student(){

    }
}
