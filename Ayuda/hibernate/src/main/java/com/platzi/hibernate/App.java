package com.platzi.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.platzi.hibernate.model.Course;
import com.platzi.hibernate.model.SocialMedia;
import com.platzi.hibernate.model.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        
//        Teacher teacher = new Teacher("Anahi Salgado", "Avatar");
        Course course = new Course("Java Avanzado", "Tema 1", "Rest API");
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        
    }
}
