package online.agatstudio.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import online.agatstudio.relationships.one_to_one.entity.Passport;
import online.agatstudio.relationships.one_to_one.entity.StudentOTO;

public class EnumEx {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            StudentOTO student1 = new StudentOTO("Serena", "Nilsen", 6.4);
//            Passport passport1 = new Passport("serena@email", 168, EyeColor.GREEN);
//            student1.setPassport(passport1);
//
//            entityManager.persist(student1);

            StudentOTO student2 = entityManager.find(StudentOTO.class, 1);

            transaction.commit();
            System.out.println(student2.getPassport());
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


    }
}
