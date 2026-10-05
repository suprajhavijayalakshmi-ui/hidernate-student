package com.student.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.entity.Student;

public class StudentApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {

            session.beginTransaction();

            // Create students
            Student student2 = new Student(
                    2,
                    "Ananya",
                    "ananya@gmail.com",
                    "Computer Science"
            );

            Student student3 = new Student(
                    3,
                    "Priya",
                    "priya@gmail.com",
                    "Information Technology"
            );

            Student student4 = new Student(
                    4,
                    "Kavin",
                    "kavin@gmail.com",
                    "Data Science"
            );

            Student student5 = new Student(
                    5,
                    "Rahul",
                    "rahul@gmail.com",
                    "Computer Science"
            );

            // Insert students
            session.persist(student2);
            session.persist(student3);
            session.persist(student4);
            session.persist(student5);

            session.getTransaction().commit();

            System.out.println("4 students inserted successfully!");

        } finally {

            session.close();
            factory.close();
        }
    }
}