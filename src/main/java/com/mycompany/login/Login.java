/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import java.util.regex.Pattern;
/**
 *
 * @author lieek
 */
public class Login {

 private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;
 
    public Login() {
    }
 
    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
 
   
 
    public String getUsername() {
        return username;
    }
 
    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    
    public boolean checkUserName(String username) {
        if (username == null) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }
 
    
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecialChar = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
        return hasUpperCase && hasDigit && hasSpecialChar;
    }
 
    
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        if (cellPhoneNumber == null) {
            return false;
        }
        String regex = "^\\+27[0-9]{9}$";
        return Pattern.matches(regex, cellPhoneNumber);
    }
 
    
    public String registerUser(String username, String password, String cellPhoneNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your "
                 + "username contains an underscore and is no more than five "
                 + "characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the "
                 + "password contains at least eight characters, a capital "
                 + "letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell number is incorrectly formatted or does not contain an "
                 + "international code; please correct the number and try again.";
        }
 
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
 
        return "Username successfully captured. Password successfully captured. "
             + "Cell number successfully captured. You have been registered successfully.";
    }
 
    
    public boolean loginUser(String username, String password) {
        return this.username != null && this.username.equals(username)
            && this.password != null && this.password.equals(password);
    }
 
   
    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}    
//referencing
//Deitel, P.J. and Deitel, H.M., 2016. Java: How to program. 10th ed. Boston: Pearson
//Oracle, 2024. Class Pattern. [online] Available at:
//<https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html>
//[Accessed 17 September 2026].

//W3Schools, 2024. Java regular expressions. [online] Available at:
//<https://www.w3schools.com/java/java_regex.asp> [Accessed 17 September 2026].//