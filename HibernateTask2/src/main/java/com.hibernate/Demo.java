package com.hibernate;

import com.hibernate.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class Demo {
   static SessionFactory factory=new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Addresses.class)
            .addAnnotatedClass(Student.class)
            .addAnnotatedClass(Courses.class)
            .addAnnotatedClass(Teacher.class)
            .buildSessionFactory();

    static   Session session= factory.getCurrentSession();

    public static void main(String args[]){




        try {

//calling methods here

//assignStudentsToCourse();
//retrieveStudentsofCourse(7);
//retrieveCoursesofStudent(6);
//retrieveCourse(2);
//            addStudent();
//            updateTeacherofCourse(3);
//addTeacher();
//            deleteTeacher(3);
//            assignCoursesToTeacher();
//        retrieveStudentsOfTeacher(2);
       // retriveTeachersofStudent(6);


          //Ammar
//      retriveStusentsOfCourse(3);
//      checkIfStudentStudyCourse(1,3);
//      addCourse("SRE","568");
//      updateCourseDetails(3,"urdu","687");
//      removeCourseOfStudent(1,2);
//
        assignCourseToStudent(4,3);
//        addOnlyStudent();
//        addOnlyAddresse();
//        addStudentTOAddress();
//    addAddreessTOStudent();
//        retrieveStudent();
//  retrieveStudentTOAddress();
//          deleteOnlyStudent();
//            deleteOnlyAddress();
//        deleteStudentToAddress();
//            updateStudent();
//          addStudenttoCourse();
//deleteStudentofCourse();
            updateCourseofStudent();
        }
        finally {
            session.close();
            factory.close();
        }
    }


    public static void deleteCourse(int course_id){


        //ManytoOne  relation example Courses and Teacher (Deleting Course)
        session.beginTransaction();
//            Teacher teacher=session.get(Teacher.class,2);
        Courses course=session.get(Courses.class,course_id);

        System.out.println(course);

        session.delete(course);
        session.getTransaction().commit();

        System.out.println("Course Deleted: "+course);
    }
    public static void addCourseAndAssignToTeacher(){
//ManytoOne  relation example Courses and Teacher (Adding Courses)

            session.beginTransaction();
            Teacher teacher=session.get(Teacher.class,3);
            Courses course=new Courses("FCP","CS103");

            teacher.add(course);

            session.save(course);

            session.getTransaction().commit();

            System.out.println("DONE!");



    }
    //ManytoOne  relation example Courses and Teacher (Retrieving Courses)
    public static void retrieveCoursesOfTeacher(int teacher_id){

            session.beginTransaction();
            Teacher teacher=session.get(Teacher.class,teacher_id);


            System.out.println(teacher.getCourses());

            session.getTransaction().commit();

            System.out.println("DONE!");

    }
    public static void addStudent(){



//ONEtoOne mapping example Student and Address
        Addresses address=new Addresses("Boston","24 st","England");
        Student student=new Student("Azhar","Ch");

        address.setStudent(student);

            session.beginTransaction();

            session.save(address);

            session.getTransaction().commit();


    }
    //ManytoMAny mapping retriving courses of given student
    public static void retrieveCoursesofStudent(int student_id){

        session.beginTransaction();
        Student student=session.get(Student.class,student_id);
        System.out.println("The student is: "+student);

        System.out.println("Courses are :"+student.getCourses());
        session.getTransaction().commit();
    }
    //ManytoMAny mapping retrieving students of given courses
    public static void retrieveStudentsofCourse(int course_id){

        session.beginTransaction();
        Courses course=session.get(Courses.class,course_id);
        System.out.println("The course is: "+course);

        System.out.println("Students are :"+course.getStudents());
        System.out.println("Teacher is:"+course.getTeacher());
        session.getTransaction().commit();
    }
    public static void getTeacherOfCourse(int course_id){
        session.beginTransaction();
        Courses course=session.get(Courses.class,course_id);
        System.out.println("The course is: "+course);
        System.out.println("Teacher is:"+course.getTeacher());

    }
    //ManytoMany mapping :adding a course and assigning the that course to a new Student
    public static void newClass(){
        session.beginTransaction();

        //Creating new Course
        Courses course=new Courses("ICT","CS104");
//        Courses course=session.get(Courses.class,3);
        //Getting Teacher for the course
        Teacher teacher=session.get(Teacher.class,2);
        //Assigning Teacher to the course
        teacher.add(course);

        //Creating Students
        Student student1=new Student("Akram","Khan");
        Student student2=new Student("Tommy","Azhar");

        //Assigning courses to students
        course.addStudent(student1);
        course.addStudent(student2);

        //saving the students
        session.save(student1);
        session.save(student2);
        //saving the course
        session.save(course);

        System.out.println("Class Created");
        session.getTransaction().commit();
    }
    public static void updateTeacherofCourse(int course_id){
        session.beginTransaction();

        Courses course=session.get(Courses.class,course_id);

            System.out.println("Teacher of Course is:"+course.getTeacher());

            Teacher teacher=course.getTeacher();
            teacher.setFirst_name("Dr Hassan");

            System.out.println("Updated Teacher :"+teacher);
            session.getTransaction().commit();

        }
    public static void addTeacher(){
        session.beginTransaction();
        Teacher teacher=new Teacher("Mr Waqas","Azam");
        session.save(teacher);
        session.getTransaction().commit();

    }
    public static void deleteTeacher(int teacher_id){
        session.beginTransaction();
        Teacher teacher=session.get(Teacher.class,teacher_id);
        List<Courses> courses=teacher.getCourses();

        for (Courses course:courses
             ) {
            course.setTeacher(null);
        }
        session.delete(teacher);
        System.out.println("Deleted Teacher:"+teacher);

        session.getTransaction().commit();

    }
    public static void assignCoursesToTeacher(){
        session.beginTransaction();
        Courses course1=new Courses("SQE","CS107");
        Courses course2=session.get(Courses.class,5);
        Teacher teacher=session.get(Teacher.class,4);
        teacher.add(course1);
        teacher.add(course2);

        session.save(course1);
        session.save(course2);

        session.getTransaction().commit();

    }
    public static void removeTeacherFromCourse(int course_id){

        session.beginTransaction();
        Courses course=session.get(Courses.class,course_id);
        course.setTeacher(null);
        session.getTransaction().commit();
    }
    public static void retrieveStudentsOfTeacher(int teacher_id){

        session.beginTransaction();
        Teacher teacher=session.get(Teacher.class,teacher_id);
        List<Courses> courses=teacher.getCourses();


        for (Courses course: courses)
        {
            System.out.println(course.getStudents());

        }
        session.getTransaction().commit();

    }
    public static void retriveTeachersofStudent(int student_id){

        session.beginTransaction();
      Student student=session.get(Student.class,student_id);
        List<Courses> courses=student.getCourses();
        List<Teacher> teachers=new ArrayList<>();

        for (Courses course: courses)
        {
            teachers.add(course.getTeacher());

        }

        System.out.println("Teachers are :"+teachers);
        session.getTransaction().commit();
    }
    //Method to add Only Student :Azhar:
    public static void addOnlyStudent(){
        Student student=new Student("Ali","Mahmood");

        session.beginTransaction();

        session.save(student);
        session.getTransaction().commit();
    }
    //Method to add Only Address :Azhar:
    public static void addOnlyAddresse(){

        //Creating Addresses Object
        Addresses addressesObject=new Addresses("Lahore","NaseeraAbad","Pakistan");
        //Starting Transaction
        session.beginTransaction();
        //Saving Object into Database
        session.save(addressesObject);
        session.getTransaction().commit();
    }
    //Method to add Student References Address Unidirectional :Azhar:
    public static void addStudentTOAddress(){
        //Creating Student Object
        Student student=new Student("Rana","Azhar");

        //Creating Addresses Object
        Addresses addressesObject=new Addresses("Lahore","NaseeraAbad","Pakistan");

        //Set Address into Student
        addressesObject.setStudent(student);

        //Starting Transaction
        session.beginTransaction();

        //Saving Object into Database
        session.save(addressesObject);

        session.getTransaction().commit();
    }
    //Method to add Student References Address BiDirection :Azhar:
    public static void addAddreessTOStudent(){
        //Creating Student Object
        Student student=new Student("Rana","Azhar");

        //Creating Addresses Object
        Addresses addressesObject=new Addresses("Lahore","NaseeraAbad","Pakistan");

        //Set Student into Address
        student.setAddresses(addressesObject);
        //Starting Transaction
        session.beginTransaction();

        //Saving Object into Database
        session.save(student);

        session.getTransaction().commit();
    }
    //Method to GET Student References Address Bidirectional :Azhar:
    public static void retrieveStudentTOAddress(){


        //Starting Transaction
        session.beginTransaction();
        //retrieve Address
        Addresses addresses=session.get(Addresses.class,1);

        //Print Address
        System.out.println(addresses.toString());

        //print student throught address
        System.out.println(addresses.getStudent());

        session.getTransaction().commit();
    }
    //Method to Delete Only Student  :Azhar:
    public static void deleteOnlyStudent(){


        //Starting Transaction
        session.beginTransaction();

        //retrieve Student Object from database
        Student student=session.get(Student.class,4);

        //Print Student
        System.out.println(student.toString());
        student.getAddresses().setStudent(null);
        //delete Student
        session.delete(student);
        session.getTransaction().commit();
    }
    //Method to Delete Only Address  :Azhar:
    public static void deleteOnlyAddress(){


        //Starting Transaction
        session.beginTransaction();

        //retrieve Student Object from database
        Addresses addresses=session.get(Addresses.class,10);


        //Print Student
        System.out.println(addresses.toString());

        addresses.getStudent().setAddresses(null);

        //delete Student
        session.delete(addresses);
        session.getTransaction().commit();
    }


    //Method to Delete Student to Address :Azhar:
    //Only When in student Set Address Cascade Type to All
    public static void deleteStudentToAddress(){


        //Starting Transaction
        session.beginTransaction();

        //retrieve Student Object from database
        Student student=session.get(Student.class,2);

        //Print Student
        System.out.println(student.toString());
        System.out.println(student.getAddresses());

        //delete Student
        session.delete(student);
        session.getTransaction().commit();
    }

    //Method to update Student :Azhar:
    public static void updateStudent(){
        //Start session
        session.beginTransaction();

        //retrieve Student Object
        Student student=session.get(Student.class,2);

        //Set Student value ---Updating
        student.setFirst_name("Muhammad");
        student.setLast_name("Ali");

        session.getTransaction().commit();

    }
    //Method to add Student to Course only student :Azhar:
    private static void addStudenttoCourse() {
        session.beginTransaction();

        //Creating Student object
        Student student=new Student("Azhar","Mahmood");
        //Saving Student object
        session.save(student);
        //Creating Courses objects
        Courses courses1=new Courses("JavaWithApi","3321");
        Courses courses2=new Courses("Angular7 with Spring","3322");

        //Adding Courses to student
        student.addCourses(courses1);
        student.addCourses(courses2);

        //Saving Courses object
        session.save(courses1);
        session.save(courses2);


        session.getTransaction().commit();
    }
    //Method to retreive only student :Azhar:
    private static void retrieveStudent() {
        //start transaction
        session.beginTransaction();

        //Retrieve object
        Student student=session.get(Student.class,2);

        //print student
        System.out.println(student.toString());

        session.getTransaction().commit();

    }
    //method to delete Only Student not course :Azhar:
    private static void deleteStudentofCourse() {
        session.beginTransaction();

        //Getting Student object
        Student student=session.get(Student.class,10);
        //print student
        System.out.println(student.toString());
        //print courses
        System.out.println(student.getCourses());
        session.delete(student);
        session.getTransaction().commit();

    }
    //Method to update course of student       :Azhar:
    private static void updateCourseofStudent() {

        session.beginTransaction();
        //Getting Student Object
        Student student=session.get(Student.class,11);

        //Creating COurses object
        Courses courses=new Courses("SpringMVC with Java","1234");

        //Adding COurses
        student.addCourses(courses);

        //Saving COurse
        session.save(courses);

        //Getting course and Removing it from student
        student.removeCourses(session.get(Courses.class,3));

        session.getTransaction().commit();
    }

}


    public static void retriveStusentsOfCourse(int course_id){

        session.beginTransaction();
        Courses course=session.get(Courses.class,course_id);

        List<Student> students = course.getStudents();

        System.out.println("Students of Course are: "+students);

    }
    public static void checkIfStudentStudyCourse(int student_id,int course_id){

        session.beginTransaction();
        Student student=session.get(Student.class,student_id);
        Courses course = session.get(Courses.class,course_id);
        if(student.getCourses().contains(course)){
            System.out.println("Student Study this Course");
        }else {
            System.out.println("Student don't study this course");
        }

    }


    public static  void addCourse(String name,String code){
        session.beginTransaction();

        Courses course = new Courses();
        course.setName(name);
        course.setCode(code);
        session.save(course);
        session.getTransaction().commit();
        System.out.println("Course Added");
    }

    public static void updateCourseDetails(int course_id,String name,String code){
        session.beginTransaction();

        Courses course = session.get(Courses.class,course_id);
        course.setName(name);
        course.setCode(code);
        session.getTransaction().commit();

    }

    public static void removeCourseOfStudent(int course_id,int student_id){
        session.beginTransaction();
        Student student=session.get(Student.class,student_id);
        Courses course=session.get(Courses.class,course_id);

        List<Courses> courses = student.getCourses();
        courses.remove(course);
        student.setCourses(courses);
        session.getTransaction().commit();

    }

    public static void assignCourseToStudent(int course_id,int student_id){

        session.beginTransaction();

        Student student  = session.get(Student.class,student_id);
        Courses course = session.get(Courses.class,course_id);
        course.addStudent(student);
        session.getTransaction().commit();


    }

}