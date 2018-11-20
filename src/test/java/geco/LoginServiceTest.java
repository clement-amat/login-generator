package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginServiceTest {

    private String[] cinqLogins = {"a", "ab", "ccc", "dddd", "eeeee"};
    private String[] emptyLogins = {};

    private LoginService cingLoginService;
    private LoginService emptyLoginService;

    @Before
    public void setUp() {
        cingLoginService = new LoginService(cinqLogins);
        emptyLoginService = new LoginService(emptyLogins);
    }

    @Test
    public void loginExistsTestWithExistingLogin() {
        assertTrue("Login existant non reconu", cingLoginService.loginExists(cinqLogins[0]));
    }

    @Test
    public void loginExistsTestWithNonExistingLogin() {
        assertFalse("Login non existant reconu", cingLoginService.loginExists(cinqLogins[0] + "/"));
    }

    @Test
    public void addLoginTest() {
        emptyLoginService.addLogin("toto");
        assertEquals("Ajout d'un login probleme", 1, emptyLoginService.findAllLogins().size());
    }

    @Test
    public void findAllLoginsStartingWithTestEmpty() {
        assertEquals("Liste non vide quand aucun prefixe ne correspond",
                Collections.EMPTY_LIST, emptyLoginService.findAllLoginsStartingWith("whatever"));
    }

    @Test
    public void findAllLoginsStartingWithTestNonEmpty() {
        List<String> result = new ArrayList<>();
        Collections.addAll(result, "a", "ab");
        assertEquals("Mauvais identifiants correspondants a un prefixe", result, cingLoginService.findAllLoginsStartingWith("a"));
    }

}