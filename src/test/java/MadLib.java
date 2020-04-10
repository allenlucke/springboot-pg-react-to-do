package com.java_todo.springbootpgreacttodo.model;

import java.io.Console;

public class MadLib {

    public static void main(String[] args) {
        Console console = System.console();

        String name = console.readLine("Enter your name:  ");
        String adjective = console.readLine("Enter an adjective:  ");
        String verb = console.readLine("Enter a verb:  ");

        console.printf("%s is very %s while %s\n", name, adjective, verb);
    }
}
