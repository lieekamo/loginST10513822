/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import java.util.Scanner;
/**
 *
 * @author lieek
 */
public class RegistrationApp {
    
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("=== Registration ===");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
 
        Login login = new Login(firstName, lastName);
 
        System.out.print("Enter username (must contain '_' and be no more than 5 characters): ");
        String username = scanner.nextLine();
        System.out.print("Enter password (8+ chars, capital letter, number, special char): ");
        String password = scanner.nextLine();
        System.out.print("Enter South African cell number (e.g. +27838968976): ");
        String cellPhoneNumber = scanner.nextLine();
 
        String registrationResult = login.registerUser(username, password, cellPhoneNumber);
        System.out.println(registrationResult);
 
        if (registrationResult.contains("registered successfully")) {
            System.out.println();
            System.out.println("=== Login ===");
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();
 
            boolean success = login.loginUser(loginUsername, loginPassword);
            System.out.println(login.returnLoginStatus(success));
        }
 
        scanner.close();
    }
}
