package pl.coderslab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.ArrayList;

public class Main01 {
    public static void main (String[] args) {
        inputOption ("tasks.csv");
        inputTasksFromFile ("tasks.csv");

    }

    public static void showOptionList () {
        String optionList[] = {"Please select an option", "add", "remove", "list", "exit"};
        System.out.println ("\033[0;34m" + optionList[0]);
        for (int i = 1; i < optionList.length; i++) {
            System.out.println ("\u001B[37m" + optionList[i]);
        }
    }

    public static String[] inputTasksFromFile (String fileName) {
        File tasksFile = new File (fileName);
        ArrayList<String> tasks = new ArrayList<String> ();
        try {
            Scanner scan = new Scanner (tasksFile);
            while (scan.hasNextLine ()) {
                tasks.add (scan.nextLine ());
            }
        } catch (FileNotFoundException e) {
            System.out.println ("Brak pliku.");
        }
        String[] outputTasksArray = new String[tasks.size ()];
        for (int i = 0; i < tasks.size (); i++) {
            outputTasksArray[i] = tasks.get (i);
        }
        return outputTasksArray;
    }

    public static void addTask (String fileName) {
        Scanner scan1 = new Scanner (System.in);
        System.out.println ("\u001B[37m" + "please put task description");
        String taskDescription = scan1.next ();
        System.out.println ("\033[0;33m" + taskDescription);
        Scanner scan2 = new Scanner (System.in);
        System.out.println ("\u001B[37m" + "please put task due date");
        String taskDueDate = scan2.next ();
        System.out.println ("\033[0;33m" + taskDueDate);
        Scanner scan3 = new Scanner (System.in);
        System.out.println ("\u001B[37m" + "is your task important? (y/n)");
        String taskimportance = scan3.next ();
        System.out.println ("\033[0;33m" + taskimportance);

        switch (taskimportance) {
            case "y":
                taskimportance = "true";
                break;
            case "n":
                taskimportance = "false";
                break;
        }
        String newTaskLine = taskDescription + ", " + taskDueDate + ", " + taskimportance;
        System.out.println ("\033[0;33m" + "whole line after concatening: " + newTaskLine + "\u001B[37m");
        try {
            Writer output;
            output = new BufferedWriter (new FileWriter (fileName, true));  //clears file every time
            output.append (newTaskLine);
            output.close ();
        } catch (IOException ex) {
            System.out.println ("Błąd zapisu do pliku.");
        }
        listTask (fileName);
    }

    public static void removeTask (String fileName) {

    }

    public static void listTask (String fileName) {
        for (int i = 0; i < inputTasksFromFile (fileName).length; i++) {
            int n = i + 1;
            System.out.println ("task nr " + n + ": " + inputTasksFromFile (fileName)[i]);
        }
        inputOption (fileName);

    }

    public static void exitTask (String fileName) {
        System.out.println ("\033[0;31m" + "bye bye");
        System.exit (0);
    }

    public static void inputOption (String fileName) {
        showOptionList ();
        Scanner scan = new Scanner (System.in);
        String input = scan.next ();
        switch (input) {
            case "add":
                addTask (fileName);
                break;
            case "remove":
                removeTask (fileName);
                break;
            case "list":
                listTask (fileName);
                break;
            case "exit":
                exitTask (fileName);
                break;
// other options
            default:
                System.out.println ("Please select a correct option.");

        }
    }

}