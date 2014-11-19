package pl.edu.agh.tools;

import java.util.regex.Pattern;

/**
 * Created by Krzysztof Kicinger on 2014-11-17.
 */
public class ValidationTools {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z]+[_A-Za-z0-9-]*(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,4})$");
    private static final Pattern LOGIN_PATTERN = Pattern.compile("^[a-zA-Z0-9\\.@!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]+$");
    private static final Pattern FIRSTNAME_PATTERN = Pattern.compile("^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+(\\x20[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+)*$");
    private static final Pattern LASTNAME_PATTERN = Pattern.compile("^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+(-[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+)*$");

    public static boolean validateEmail(String emailAddress) {
        return EMAIL_PATTERN.matcher(emailAddress).matches();
    }

    public static boolean validateLogin(String login) {
        return LOGIN_PATTERN.matcher(login).matches();
    }

    public static boolean validateFirstName(String name) {
        return FIRSTNAME_PATTERN.matcher(name).matches();
    }

    public static boolean validateLastName(String name) {
        return LASTNAME_PATTERN.matcher(name).matches();
    }

}
