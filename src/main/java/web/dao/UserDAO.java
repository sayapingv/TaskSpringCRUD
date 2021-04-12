package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.model.UserCreationList;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAllUsers() {
        EntityManager em = sessionFactory.createEntityManager();
        List<User> list =  em.createQuery("from User").getResultList();
        em.close();
        return list;
    }

    public void save(List<User> userList) {
        EntityManager em = sessionFactory.createEntityManager();
        System.out.println(userList);
        em.getTransaction().begin();
        for (User user : userList) {
            em.merge(user);
        }
        em.getTransaction().commit();
        em.close();
    }
}
