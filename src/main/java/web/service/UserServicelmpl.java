package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;


@Service
@Transactional
public class UserServicelmpl implements web.service.UserService {

    private final UserDao userDao;

    @Autowired
    public UserServicelmpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Override
    public void deleteUser(int userId) {
        try {
            userDao.deleteUser(userId);
        } catch (Exception e) {
            throw new RuntimeException("no this user " + e);
        }
    }
    @Override
    public void updateUser(int id, User user) {
        try {
            userDao.updateUser(id, user);
        } catch (Exception e) {
            throw new RuntimeException("no this user " + e);
        }
    }
    @Override
    @Transactional(readOnly = true)
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }
}