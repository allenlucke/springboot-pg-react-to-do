package com.java_todo.springbootpgreacttodo;

import java.io.Console;

public class Conditional {
    Console console = System.console();

    int numberOfPeople = 3;

    if(numberOfPeople < 4) {
        console.printf("Your table is ready\n");
        System.exit(0);
    }
}
