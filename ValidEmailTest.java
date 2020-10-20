package com.validemail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ValidEmailTest
{
    private String email ;
    private boolean expectedEmail;

    public ValidEmailTest( String email, boolean expectedEmail)
    {
        this.email = email;
        this.expectedEmail = expectedEmail;
    }

    @Parameterized.Parameters
    public static Collection input()
    {
        return Arrays.asList(new Object[][] { {"abc@yahoo.com", true},
                {"abc-100@yahoo.com", true}, {"abc.100@yahoo.com", true},
                {"abc111@abc.com", true}, {"abc-100@abc.net", true},
                {"abc.100@abc.com.au", true}, {"abc@1.com", true},
                {"abc@gmail.com.com", true}, {"abc+100@gmail.com ", true},
                {"abc", false}, {"abc@.com.my", false},
                {"abc123@gmail.a", false}, {"abc123@.com", false},
                {"abc123@.com.com ", false}, {".abc@abc.com", false},
                {"abc()*@gmail.com", false}, {"abc@%*.com", false},
                {"abc..2002@gmail.com", false}, {"abc.@gmail.com", false},
                {"abc@abc@gmail.com", false}, {"abc@gmail.com.1a", false},
                {"abc@gmail.com.aa.au", false}});
    }
    @Test
    public void givenEmail_HasVariable_ShouldReturn_AsPer_ParameterizedResult()
    {
        ValidEmail validEmail = new ValidEmail();
        boolean result = validEmail.validateEmail(this.email);
        Assert.assertEquals(result,this.expectedEmail);
    }

}
