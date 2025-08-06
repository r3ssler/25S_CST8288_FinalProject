import com.algonquin.www.domain.PerformanceMetricDTO;
import com.algonquin.www.domain.UserDTO;
import com.algonquin.www.model.LoginRequest;
import com.algonquin.www.model.RegisterRequest;
import com.algonquin.www.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService(); 
    }

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

    @Test
    public void testLogin_InvalidCredentials() {
        LoginRequest login = new LoginRequest();
        login.setUsername("wronguser");
        login.setPassword("wrongpass");

        UserDTO user = userService.login(login);
        assertNull(user);
    }

    @Test
    public void testPerformance_All() {
        List<PerformanceMetricDTO> allMetrics = userService.performance(null);
        assertNotNull(allMetrics);
    }

    @Test
    public void testPerformance_ByUsername() {

        List<PerformanceMetricDTO> data = userService.performance("testuser");
        assertNotNull(data);
    }
}
