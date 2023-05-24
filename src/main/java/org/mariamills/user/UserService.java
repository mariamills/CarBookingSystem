package org.mariamills.user;

import java.util.List;
import java.util.UUID;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(UUID id) {
        return userDao.getUserById(id);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
