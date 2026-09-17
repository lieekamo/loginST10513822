/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lieek
 */
public class LoginTest {
    private Login login;
    
    @BeforeEach
    public void setUp() {
        login = new Login("Kyle", "Smith");
    }
 
    
 
    @Test
    public void testUserNameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }
 
    @Test
    public void testUserNameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }
 
    @Test
    public void testPasswordMeetsComplexityRequirements() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
 
    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        assertFalse(login.checkPasswordComplexity("password"));
    }
 
    @Test
    public void testCellPhoneNumberCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
 
    @Test
    public void testCellPhoneNumberIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
 
    @Test
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
 
    @Test
    public void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("kyl_1", "wrongPassword"));
    }
 
    // ----- assertEquals tests -----
 
    @Test
    public void testUsernameNotCorrectlyFormattedMessage() {
        String result = login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your "
                   + "username contains an underscore and is no more than five "
                   + "characters in length.", result);
    }
 
    @Test
    public void testPasswordNotCorrectlyFormattedMessage() {
        String result = login.registerUser("kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the "
                   + "password contains at least eight characters, a capital "
                   + "letter, a number, and a special character.", result);
    }
 
    @Test
    public void testCellNumberIncorrectlyFormattedMessage() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals("Cell number is incorrectly formatted or does not contain an "
                   + "international code; please correct the number and try again.", result);
    }
 
    @Test
    public void testRegisterUserSuccessMessage() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username successfully captured. Password successfully captured. "
                   + "Cell number successfully captured. You have been registered successfully.", result);
    }
 
    @Test
    public void testReturnLoginStatusSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome Kyle, Smith it is great to see you again.",
                login.returnLoginStatus(true));
    }
 
    @Test
    public void testReturnLoginStatusFailure() {
        assertEquals("Username or password incorrect, please try again.",
                login.returnLoginStatus(false));
    }
}