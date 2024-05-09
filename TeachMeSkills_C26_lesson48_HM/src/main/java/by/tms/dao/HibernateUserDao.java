package by.tms.dao;

import by.tms.entity.Operation;
import by.tms.entity.NewUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HibernateUserDao implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(NewUser user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Override
    public NewUser findByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<NewUser> query = currentSession.createQuery("from NewUser where username = :username", NewUser.class);
        query.setParameter("username", username);
        NewUser result = query.getSingleResult();

        return result;
    }

    @Override
    public List<Operation> findAllOperationsByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<NewUser> query = currentSession.createQuery("from NewUser where username = :username", NewUser.class);
        query.setParameter("username", username);
        NewUser result = query.getSingleResult();
        List<Operation> operations = result.getOperations();
        return operations;
    }
}
