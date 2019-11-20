package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

public class JpaInsert {
    public static void run(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //트랜잭션은 아주 중요한 역할을 함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //엔티티매니저로 값을 넣고뺌
            Member mem = new Member();
            mem.setId(2L);
            mem.setName("HelloB");
            em.persist(mem);
            tx.commit();
        }catch (Exception e){
            tx.rollback();  //예외 발생 시 트랜잭션 롤
        }finally {
            em.close();
        }
        emf.close();
    }
}
