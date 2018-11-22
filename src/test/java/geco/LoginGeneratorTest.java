package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private LoginService loginService;
    private LoginGenerator loginGenerator;

    @Before
    public void setUp() {
        loginService = new LoginService(new String[] {"JROL",
                "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void casSujet() {
        assertEquals("Paul durand ne genere pas le bon login", "PDUR",
                loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul"));

        assertTrue("PDUR n'a pas ete ajoute a la liste", loginService.loginExists("PDUR"));
    }

    @Test
    public void testDubplicats() {
        assertEquals("Pas JRAL2 pour duplicat", "JRAL2",
                loginGenerator.generateLoginForNomAndPrenom("Ralling", "John"));

        assertTrue("JRAL2 n'a pas ete ajoute a la liste", loginService.loginExists("JRAL2"));
    }

    @Test
    public void testCT2() {
        assertEquals("Pas JROL1 pour duplicat", "JROL1",
                loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean"));

        assertTrue("JROL1 n'a pas ete ajoute a la liste", loginService.loginExists("JROL1"));
    }

    @Test
    public void testCT3() {
        assertEquals("Pas pdur pour paul durant", "PDUR",
                loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul"));

        assertTrue("PDUR n'a pas ete ajoute a la liste", loginService.loginExists("PDUR"));
    }

    @Test
    public void testNomInferieurTrois() {
        assertEquals("Login invalide pour taille du nom inferieur à 3", "PDU",
                loginGenerator.generateLoginForNomAndPrenom("Du", "Paul"));
    }


}