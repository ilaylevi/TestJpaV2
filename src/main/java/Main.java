import entity.Company;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Company dalia = new Company();
            dalia.setFirstname("savtasdhli");
            dalia.setAddress("atunasss");
            dalia.setAge(192);
            dalia.setNumber(054-20200530);
            dalia.setSalary(137020);
            entityManager.persist(dalia);

//            TypedQuery<Company> empByDeptQuery = entityManager.createNamedQuery("SELECT", Company.class);
//            empByDeptQuery.setParameter(1, "Java Advocacy");
//            for (Company company : empByDeptQuery.getResultList()) {
//                System.out.println(company);
//            }
//
//            Query countEmpByDept = entityManager.createNativeQuery("SELECT COUNT(*) FROM Employee INNER JOIN Department D on Employee.department_id = D.id WHERE D.name=:deptName");
//            countEmpByDept.setParameter("deptName", "Java Advocacy");
//            System.out.println("There are " + countEmpByDept.getSingleResult() + " Java Advocates.");

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}