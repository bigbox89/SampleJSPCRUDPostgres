package service;

import dao.UserDaoHibernate;
import entity.UserEntity;

import java.util.List;

public class UserService {

    private UserDaoHibernate UserDaoHibernate = new UserDaoHibernate();

    public UserService() {
    }

    public UserEntity findUser(int id) {
        return UserDaoHibernate.selectUser(id);
    }

    public void saveUser(UserEntity user) {
        UserDaoHibernate.save(user);
    }

    public void deleteUser(int id) {
        UserDaoHibernate.delete(id);
    }

    public void updateUser(UserEntity user) {
        UserDaoHibernate.update(user);
    }

    public List<UserEntity> findAllUsers() {
        return UserDaoHibernate.findAll();
    }




}