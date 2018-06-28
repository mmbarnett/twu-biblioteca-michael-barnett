package com.twu.biblioteca;

import java.util.*;
import java.io.InputStream;

public class BibliotecaApp {

    public static void main(String[] args) {
        Console console = new Console();
        welcome(console);
        InputStream stdin = System.in;

        listen(stdin, console);
    }

    // this accepts a general InputStream for testing purposes
    public static void listen(InputStream in, Console console) {
        Scanner sc = new Scanner(in);
        String command = sc.nextLine();
        String response = console.readMessage(command);
        System.out.println(response);
    }

    public static void welcome(Console console) {
        System.out.println(console.getWelcomeMessage());
        System.out.println(console.getMainMenu());
    }
}
