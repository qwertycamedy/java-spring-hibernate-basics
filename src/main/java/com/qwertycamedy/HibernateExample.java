package com.qwertycamedy;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qwertycamedy.config.HibernateConfig;
import com.qwertycamedy.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class HibernateExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("SELECT firstName, lastName FROM Student WHERE age >=22 AND age <= 32");
            List<Object[]> students = query.getResultList();

            for (Object[] student : students) {
                String firstName = (String) student[0];
                String lastName = (String) student[1];

                System.out.println(firstName + " " + lastName);
            }

            entityManager.getTransaction().commit();
        } catch (Exception error) {
            System.out.println("Exception caught, executing rollback... \n Error: " + error);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        context.close();
    }
}
