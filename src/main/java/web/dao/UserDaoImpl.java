package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.merge(user);

    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    //    @Override
//    public List<User> listUser() {
//        return entityManager.createQuery("from User", User.class).getResultList();
//    }
    @Override
    public List<User> listUser() {

        String query = "SELECT u FROM User u";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        List<User> users = typedQuery.getResultList();
        return users;
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));

    }
}
