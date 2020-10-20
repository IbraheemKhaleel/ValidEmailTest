package com.validemail;

import java.util.regex.Pattern;

public class ValidEmail
{
    public static final String EMAIL_PATTERN = "^(?!\\\\.)(?!.*\\\\.$)(?!.*?\\\\.\\\\.)[a-zA-Z0-9_.+]+[a-zA-Z0-9+_][@][a-z0-9]+[.][a-z]{2,}$";
    public boolean validateEmail(String email)
    {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }
}
