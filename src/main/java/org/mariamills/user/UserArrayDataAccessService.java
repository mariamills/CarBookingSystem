package org.mariamills.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UserArrayDataAccessService implements UserDao {
    @Override
    public User getUserById(UUID id) {
        return getUsers().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("❌ User " + id + " does not exist"));
    }

    @Override
    public List<User> getUsers() {
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("users.csv")).getPath());
        List<User> users = new ArrayList<>();
        try {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    String[] parts = scanner.nextLine().split(",");
                    users.add(new User(UUID.fromString(parts[0]), parts[1].trim()));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
