package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGenerationTest {

    @Test
    public void testPasswordGeneration() {
        assertEquals("Longueur différente de longueur demandée",
                PasswordGeneration.PASSWORD_LENGTH, PasswordGeneration.getRandomString().length());
    }

}