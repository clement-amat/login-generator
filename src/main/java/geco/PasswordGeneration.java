package geco;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * Classe utilitaire permettant de générer un mot de passe aléatoire.
 *
 */
public class PasswordGeneration {

    /** Longueur par defaut du mot de passe généré */
    public static final int PASSWORD_LENGTH = 8;

    /**
     * Générer une chaine de caractère aléatoire.
     *
     * @return un mot de passe aléatoire
     */
    public static String getRandomString() {
        String generateString = "";
        Random r = new Random();

        for (int i = 0 ; i < PASSWORD_LENGTH ; i++) {
            generateString += (char)(r.nextInt(26) + 'a');
        }

        return generateString;
    }
}
