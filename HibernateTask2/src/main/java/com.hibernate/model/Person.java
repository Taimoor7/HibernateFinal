package com.hibernate.model;


import javax.persistence.*;

@Entity
@Table(name ="person")
public class Person {

    public Person(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactno")
    private int contact_no;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    public Person(String name, int contact_no, String email, String address) {
        this.name = name;
        this.contact_no = contact_no;
        this.email = email;
        this.address = address;
    }

    public Person(int id, String name, int contact_no, String email, String address) {
        this.id = id;
        this.name = name;
        this.contact_no = contact_no;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact_no=" + contact_no +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
