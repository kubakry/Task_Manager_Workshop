package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main01 {
    public static void main (String[] args) {
        showOptionList ();
        inputTasksFromFile ("tasks.csv");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        switch (input) {
            case "add": addTask();break;
            case "remove": removeTask();break;
            case "list": listTask("tasks.csv");break;
            case "exit": exitTask();break;
// other options
            default:
                System.out.println("Please select a correct option.");

        }
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
    public static void addTask(){


    }
    public static void removeTask(){

    }
    public static void listTask(String fileName){
        for (int i = 0; i < inputTasksFromFile (fileName).length; i++) {
            System.out.println (inputTasksFromFile (fileName)[i]);
        }
    }
    public static void exitTask(){

    }
}