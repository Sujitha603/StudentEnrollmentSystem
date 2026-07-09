package com.hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Student;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {
                Configuration configuration = new Configuration();


                configuration.configure("hibernate.cgf.xml");
                configuration.addAnnotatedClass(Student.class);

                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("SessionFactory creation failed");
            }
        }

        return sessionFactory;
    }
}