package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void createToDoList(String fileName, List lines) throws IOException {
        Path currentRelativePath = Paths.get("");
        String directoryString = currentRelativePath.toAbsolutePath().toString();
        Path file = Paths.get(directoryString + "/to-do-list/" + fileName + ".txt");
        Files.write(file, lines, Charset.forName("UTF-8"));
    }


    public static void deleteToDoList(String fileName) throws IOException {
        Path currentRelativePath = Paths.get("");
        String directoryString = currentRelativePath.toAbsolutePath().toString();
        Path file = Paths.get(directoryString + "/to-do-list/" + fileName + ".txt");
        Files.delete(file);
    }

    public static void createFolder(Boolean folderReal){
        Path currentRelativePath = Paths.get("");
        String directoryString = currentRelativePath.toAbsolutePath().toString();
        if (folderReal == false){
            new File(directoryString + "/to-do-list").mkdirs();
        }
        else{ }
    }

    public static void readList(String fileName) throws IOException {
        Path currentRelativePath = Paths.get("");
        String directoryString = currentRelativePath.toAbsolutePath().toString();
        BufferedReader abc = new BufferedReader(new FileReader(directoryString + "/to-do-list/" + fileName + ".txt"));
        List<String> data = new ArrayList<String>();
        String s;
        while((s=abc.readLine())!=null) {
            data.add(s);
            System.out.println(s);
        }
        abc.close();

    }

    public static void deleteItemOnList(String fileName) throws IOException {
        Scanner reader = new Scanner(System.in);
        Path currentRelativePath = Paths.get("");
        String directoryString = currentRelativePath.toAbsolutePath().toString();
        BufferedReader abc = new BufferedReader(new FileReader(directoryString + "/to-do-list/" + fileName + ".txt"));
        List<String> data = new ArrayList<String>();
        String s;
        while((s=abc.readLine())!=null) {
            data.add(s);
        }
        String doneYet;
        doneYet = "nah fam";
        int doneYetInteger;
        readList(fileName);
        System.out.print("Which one would you like to delete from the list?(Type it's number)  ");
        while (doneYet.toUpperCase().compareTo("DONE") != 0){
            doneYet = reader.nextLine();
            if (doneYet.toUpperCase().compareTo("DONE") != 0) {
                doneYetInteger = Integer.parseInt(doneYet);
                data.remove(doneYetInteger);
            }
            else{}
            System.out.print("Anymore? ");
        }
        createToDoList(fileName,data);
        abc.close();

    }

    public static void addToList(String fileName) throws IOException {
        Scanner reader = new Scanner(System.in);
        Path currentRelativePath = Paths.get("");
        String directoryString = currentRelativePath.toAbsolutePath().toString();
        BufferedReader abc = new BufferedReader(new FileReader(directoryString + "/to-do-list/" + fileName + ".txt"));
        List<String> data = new ArrayList<String>();
        String s;
        while ((s = abc.readLine()) != null) {
            data.add(s);
        }
        String doneYet;
        doneYet = "nah fam";
        while (doneYet.toUpperCase().compareTo("DONE") != 0) {
            System.out.print("What would you like to add to the to do list? ");
            doneYet = reader.nextLine();
            if (doneYet.toUpperCase().compareTo("DONE") != 0) {
                data.add(data.size() + ":" + doneYet);
            } else {
            }
        }
        createToDoList(fileName, data);
        abc.close();
    }


    public static void main(String[] args) throws IOException {
        Path currentRelativePath = Paths.get("");
        String directoryString = currentRelativePath.toAbsolutePath().toString();
        Path toDoPath = Paths.get(directoryString + "/to-do-list");
        createFolder(Files.exists(toDoPath));
        String choiceMenu;
        choiceMenu = "Not turned into anything else yet";

        //The Main Menu
        while (choiceMenu.compareTo("1") != 0 || choiceMenu.compareTo("2") != 0 || choiceMenu.compareTo("3") != 0 || choiceMenu.compareTo("4") != 0 || choiceMenu.compareTo("5") != 0 || choiceMenu.compareTo("6") != 0){
            System.out.print("\u001b[2J");
            System.out.flush();
            System.out.println("1. Create a new To Do List");
            System.out.println("2. Read a current To Do List");
            System.out.println("3. Add to a To Do List");
            System.out.println("4. Delete a To Do List");
            System.out.println("5. List all To Do Lists");
            System.out.println("6. Delete an Item on To Do List");
            Scanner reader = new Scanner(System.in);
            System.out.print("What would you like to do? ");
            choiceMenu = reader.nextLine();


            //The choice
            if (choiceMenu.compareTo("1") == 0){ //Create List
                System.out.println("What would you like the list to be named? ");
                String toDoListName = reader.nextLine();
                String AddTo;
                AddTo = "Ripple by the Grateful Dead is a good song";
                List whatIsOn = new ArrayList();
                whatIsOn.add(toDoListName + ":");
                System.out.println("What would you like to be on the list type done when done");
                while (AddTo.toUpperCase().compareTo("DONE") != 0){
                    AddTo = reader.nextLine();
                    if (AddTo.toUpperCase().compareTo("DONE") != 0){
                        whatIsOn.add(whatIsOn.size() + ":" + AddTo);
                    }
                    else{}
                }
                createToDoList(toDoListName,whatIsOn);
            }







            else if (choiceMenu.compareTo("2") == 0){ //Read a list
                System.out.print("What list would you like to read? ");
                String whichListIsWhich = reader.nextLine();
                readList(whichListIsWhich);
                System.out.println("Press enter when done");
                String wait = reader.nextLine();
            }






            else if (choiceMenu.compareTo("3") == 0){//Add to a list
                System.out.print("Which list would you like to add to? ");
                String whichListisList = reader.nextLine();
                addToList(whichListisList);
            }




            else if (choiceMenu.compareTo("4") == 0){//Delete a list
                System.out.print("What list would you like to be deleted? ");
                String toDoListName = reader.nextLine();
                System.out.print("Are you sure? ");
                String doubleCheck = reader.nextLine();
                if (doubleCheck.compareTo("Yes") == 0){
                    deleteToDoList(toDoListName);
                }
                else{}

            }




            else if (choiceMenu.compareTo("5") == 0){ //list all to do lists
                File folder = new File(toDoPath.toString());
                String[] listsInFolder = folder.list();
                for (String file : listsInFolder){
                    if (file.endsWith(".txt")) {
                        System.out.println(file);
                    }
                    else{}
                }
                System.out.println("Press enter when done");
                String wait = reader.nextLine();
            }



            else if (choiceMenu.compareTo("6") == 0){
                System.out.print("Which List do you want to delete? ");
                String whichDelete = reader.nextLine();
                deleteItemOnList(whichDelete);
            }
            else {
                System.out.println("That is NOT an option IDIOT");
            }
        }


    }
}
