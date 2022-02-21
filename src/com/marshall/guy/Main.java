package com.marshall.guy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static String generatePassword(String[] characters, int number) {
        int counter = 0;
        StringBuilder password = new StringBuilder();

        Random random = new Random();

        while (counter < number) {
            password.append(characters[Math.round(random.nextInt(characters.length))]);
            counter++;
        }

        return password.toString();
    }

    public static void main(String[] args) {
        System.out.print("Enter number of characters: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfCharacters = scanner.nextInt();

        String[] characters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "\"", "£", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+", "[", "{", "]", "}", ";", ":", "'", "@", "#", "~", ",", "<", ".", ">", "/", "?"};

        String password = generatePassword(characters, numberOfCharacters);
        System.out.printf("Password: %s%n", password);

        try {
            FileWriter myWriter = new FileWriter("password.txt");
            myWriter.write(password);
            myWriter.close();
            System.out.println("Password has been saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}