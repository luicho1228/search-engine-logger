package com.plurasight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        saveLog();
    }
    public static void saveLog(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Scanner scanner = new Scanner(System.in);
        try {
            FileWriter fileWriter = new FileWriter("logs.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(now.format(formatter) + " Launch \n");
            String userInput = "";
            do {
                System.out.println("Enter a search term(X to exit): ");
                userInput = scanner.nextLine();
                if (!(userInput.equalsIgnoreCase("x"))) {
                    bufferedWriter.write(LocalDateTime.now().format(formatter) + " search : " + userInput + "\n");
                }
            }while (!(userInput.equalsIgnoreCase("x")));
            bufferedWriter.write(LocalDateTime.now().format(formatter) + " exit \n");
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}