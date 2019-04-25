package com.hibernate.model;


import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Addresses {

    public Addresses(String city, String street, String country){
        this.city = city;
        this.street = street;
        this.country = country;

    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private int aid;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "country")
    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sid")
    private Student student;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "tid")
//    private Teacher teacher;

    @Override
    public String toString() {
        return "Addresses{" +
                "aid=" + aid +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", country='" + country + '\'' +
                ", student=" + student +
//                ", teacher=" + teacher +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }

//    public Addresses(int aid, String city, String street, String country) {
//        this.aid=aid;
//        this.city = city;
//        this.street = street;
//        this.country = country;
//
//    }

public Addresses(){}

}
