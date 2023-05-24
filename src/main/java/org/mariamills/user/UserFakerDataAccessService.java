package org.mariamills.user;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFakerDataAccessService implements UserDao {
    @Override
    public User getUserById(UUID id) {
        return getUsers().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("❌ User " + id + " does not exist"));
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        Faker faker = new Faker();
        // Generate 20 random users
        for (int i = 0; i < 20; i++) {
            userList.add(new User(UUID.randomUUID(), faker.name().firstName()));
        }
        return userList;
    }
}
