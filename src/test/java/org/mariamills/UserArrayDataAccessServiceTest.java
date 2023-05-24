package org.mariamills;

import org.junit.jupiter.api.Test;
import org.mariamills.user.User;
import org.mariamills.user.UserArrayDataAccessService;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserArrayDataAccessServiceTest {

    @Test
    void getUsers_ReturnsListOfUsersFromFile() {
        // Create an instance of UserArrayDataAccessService
        UserArrayDataAccessService service = new UserArrayDataAccessService();

        // Call the getUsers() method
        List<User> users = service.getUsers();

        // Verify the result
        assertEquals(4, users.size());
        assertEquals(UUID.fromString("7e4b9220-a47a-45a7-a33b-7182ee0dc30e"), users.get(0).getId());
        assertEquals("Leila", users.get(0).getName());
    }
}
