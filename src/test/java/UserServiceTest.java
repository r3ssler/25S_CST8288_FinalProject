import com.algonquin.www.domain.PerformanceMetricDTO;
import com.algonquin.www.domain.UserDTO;
import com.algonquin.www.model.LoginRequest;
import com.algonquin.www.model.RegisterRequest;
import com.algonquin.www.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit tests for the {@link UserService} class.
 * Tests user registration, login, and performance metric retrieval functionality.
 */

public class UserServiceTest {

    private UserService userService;
      /**
     * Initializes the {@link UserService} instance before each test.
     */

    @BeforeEach
    public void setUp() {
        userService = new UserService(); 
    }
     /**
     * Tests successful registration of a new user followed by a valid login.
     * Asserts that the user can be retrieved and the username matches.
     */

    @Test
    public void testRegisterAndLogin() {
        // Register new user
        RegisterRequest request = new RegisterRequest();
        request.setUsername("testuser");
        request.setPassword("testpass");
        request.setEmail("test@example.com");
        request.setName("Test User");
        request.setType("admin");

        userService.register(request);

        // Try login
        LoginRequest login = new LoginRequest();
        login.setUsername("testuser");
        login.setPassword("testpass");

        UserDTO user = userService.login(login);

        assertNotNull(user);
        assertEquals("testuser", user.getUsername());
    }
    
    /**
     * Tests login attempt with invalid credentials.
     * Asserts that the returned user is null.
     */

    @Test
    public void testLogin_InvalidCredentials() {
        LoginRequest login = new LoginRequest();
        login.setUsername("wronguser");
        login.setPassword("wrongpass");

        UserDTO user = userService.login(login);
        assertNull(user);
    }
      /**
     * Tests retrieval of all performance metrics when no username filter is provided.
     * Asserts that the returned list is not null.
     */

    @Test
    public void testPerformance_All() {
        List<PerformanceMetricDTO> allMetrics = userService.performance(null);
        assertNotNull(allMetrics);
    }
      /**
     * Tests retrieval of performance metrics filtered by a specific username.
     * Asserts that the returned list is not null.
     */

    @Test
    public void testPerformance_ByUsername() {

        List<PerformanceMetricDTO> data = userService.performance("testuser");
        assertNotNull(data);
    }
}
