package com.example.mavenProject;

import java.util.Scanner;

public class DemoApplication {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        var user = new User();
        user.setName(in.next());
        System.out.println("Hello, " + user.getName() + "!");
    }
}