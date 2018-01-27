import java.util.Scanner;

/**
This program:
reads input from the keyboard using a Scanner Object and its methods
uses selection (if and if else) statements 
uses iteration (while, do while or for) statements
uses String comparison methods. 
follows standard acceptable programming practices. 
handles Integer Overflow errors  

@author Timothy McWatters
@version 1.0

COP2253    Project 3
File Name: Password.java
*/

public class Password {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      
      String password = "";
      String encryptedPassword = "";
      String alreadyEncryptedPassword = "";
      String decryptedPassword = "";
      int encryptionKey = 0;
      int decryptionKey = 0;
   
      // Encrypt a password
      System.out.println("Enter a password at least 8 characters long: ");
      password = keyboard.next();
   
      if (password.length() < 8) {
         System.out.printf("The password must be at least 8 characters long, your password is only %d characters long.", password.length());
         System.exit(1);
      } 
      else {
         System.out.println("Type an integer number between 1 & 10 (inclusive) for your encryption key: ");
         encryptionKey = keyboard.nextInt();
         if (!((encryptionKey > 0) && (encryptionKey < 11))) {
            System.out.printf("The key must be between 1 and 10, you entered %d.", encryptionKey);
            System.exit(1);
         } 
      }
      for (int i = 0; i < password.length(); i++) {
         int shiftedASCIICharactersNumber = (password.charAt(i) + encryptionKey);
         if (shiftedASCIICharactersNumber < 123) {
            encryptedPassword += (char)(shiftedASCIICharactersNumber);
         } 
         else {
            encryptedPassword += (char)((shiftedASCIICharactersNumber % 122) + 32);
         }
      }
      System.out.printf("Your password is %s the encrypted version of your password is %s with a key of %d.", password, encryptedPassword, encryptionKey);
   
   
      // Decrypt a password
      System.out.println();
      System.out.println();
      System.out.println("Enter your encrypted password thats at least 8 characters long: ");
      alreadyEncryptedPassword = keyboard.next();
   
      if (alreadyEncryptedPassword.length() < 8) {
         System.out.printf("The password must be at least 8 characters long, your encrypted password is only %d characters long.", alreadyEncryptedPassword.length());
         System.exit(1);
      } 
      else {
         System.out.println("Type the integer number between 1 & 10 (inclusive) that was used as your encryption key: ");
         decryptionKey = keyboard.nextInt();
         if (!((decryptionKey > 0) && (decryptionKey < 11))) {
            System.out.printf("The key must be between 1 and 10, you entered %d.", decryptionKey);
            System.exit(1);
         } 
      }
      for (int i = 0; i < alreadyEncryptedPassword.length(); i++) {
         int shiftedASCIICharactersNumber = (alreadyEncryptedPassword.charAt(i) - decryptionKey);
         if (shiftedASCIICharactersNumber > 32) {
            decryptedPassword += (char)(shiftedASCIICharactersNumber);
         } 
         else {
            decryptedPassword += (char)(122 - (32 - shiftedASCIICharactersNumber));
         }
      }
      System.out.printf("Your encrypted password is %s the password is %s with a key of %d.", alreadyEncryptedPassword, decryptedPassword, decryptionKey);
   }
}