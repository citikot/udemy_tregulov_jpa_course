package online.agatstudio.jpa_entry.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import online.agatstudio.jpa_entry.entity.Student;

@SuppressWarnings("java:S2589")
public class UpdateExample {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        Student student = null;

        try {
            transaction.begin();
            student = entityManager.find(Student.class, 3);
            student.setAvgGrade(9.5);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }

        System.out.println(student);
    }
}
