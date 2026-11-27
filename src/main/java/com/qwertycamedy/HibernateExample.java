package com.qwertycamedy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qwertycamedy.config.HibernateConfig;
import com.qwertycamedy.entity.Address;
import com.qwertycamedy.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class HibernateExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Address address = entityManager.find(Address.class, 1);

            System.out.println(address);

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
