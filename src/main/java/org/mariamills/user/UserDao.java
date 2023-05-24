package org.mariamills.user;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    User getUserById(UUID id);

    List<User> getUsers();
}
