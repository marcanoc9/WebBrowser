//This is a program that allows you to input a URL, record that you accessed that and any other URLs
// and delete that history, among other things (explained by the HELP command)

//Christopher Marcano
//***************************************************************************************************************

import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
//**************************************************************************************************************
public class WebBrowser { public static void main(String args[]){
    // create the strings and arrays that will record the activity related to the URLs visited
    Queue<String> downloads=new LinkedList<>();
    Stack<String> forwards=new Stack<String>();
    ArrayList<String> history=new ArrayList<String>();
    Stack<String> backwards=new Stack<String>();
    String URL ="",address,command;
    //create the scanner
    Scanner sc=new Scanner(System.in);
//***************************************************************************************************************
    // the initial prompt for input and HELP command explanation
    do{
        System.out.println("Enter a command to execute (type HELP for a list of options)");
        //allows the input (string) to be stored in the command variable and use the correct method
        command=sc.nextLine();
        //***********************************************************************************************************
        //prints list of commands with explanations
         if (command.equals("HELP")){
            System.out.println("COMMAND LIST: ");
            System.out.println("GOTO: This command allows you to input a URL and access a website.");
            System.out.println("DOWNLOAD: This command allows you to download the current webpage.");
            System.out.println("BACK: This command allows you to go to the previous URL.");
            System.out.println("FORWARD: This command undoes the latest BACK command.");
            System.out.println("SHOW_DOWNLOADS: This command shows all downloads.");
            System.out.println("CLEAR_DOWNLOADS: This command deletes all previous downloads.");
            System.out.println("SHOW_HISTORY: This command shows a list of all previous URL visits,");
            System.out.println("CLEAR_HISTORY: This command deletes the record of URLs visited.");
            System.out.println("END: This command ends the program.");}
         //***********************************************************************************************************
        //the GOTO command brings up the entered URL
        else if(command.equals("GOTO")){
        //ask for URL
        System.out.println("Enter a web address for above command");
            //enters user input as the address
            address=sc.nextLine();
            //adds input into the backwards command list
            backwards.push(URL);
            //adds input to history
            history.add(address);
            URL =address;
            //prints the URL
            System.out.println(URL);
            //ensures the FORWARD list is cleared when using GOTO
            if(!forwards.empty())
                forwards.clear();}
        //*******************************************************************************************************
        // adds URL to download list
        else if(command.equals("DOWNLOAD")){
            downloads.add(URL);
        System.out.println(URL + " downloaded.");}
//******************************************************************************************************************
        //prints the download list or lets user know it is empty
        else if(command.equals("SHOW_DOWNLOADS")){
            if(downloads.isEmpty())
                System.out.println("Download list empty");
                for (String download : downloads)
                System.out.println(download);}
        //*********************************************************************************************************
        //removes all entries in the download list
        else if(command.equals("CLEAR_DOWNLOADS")){
            System.out.println("Downloads cleared.");
            if(!downloads.isEmpty())
            downloads.clear();
        System.out.println("Download list empty.");}
        //***********************************************************************************************************
        //this command prints the history
        else if(command.equals("SHOW_HISTORY")){
            if(history.isEmpty())
            System.out.println("History is empty.");
            for(int i=0;i<history.size();i++){
                System.out.println(history.get(i));}}
       //*********************************************************************************************************
        //Removes all entries in the history list
        else if(command.equals("CLEAR_HISTORY")){
            history.clear();
            if(history.isEmpty())
                System.out.println("History is empty.");
            for(int i=0;i<history.size();i++){
                System.out.println(history.get(i));}}
//***************************************************************************************************************
         //this command allows you to access the previous URL
         else if(command.equals("BACK")){
             //adds URL to the FORWARD list so it can be returned to until a new GOTO input
             forwards.push(URL);
             //makes sure their is a URL to access and warns user if not
             if(backwards.empty())
                 System.out.println("Not possible");
             else
                 URL =backwards.pop();
             System.out.println(URL);}
        //*********************************************************************************************************
         //reverses the BACK command and returns to initial GOTO address
         else if(command.equals("FORWARD")){
             backwards.push(URL);
             //makes sure their is a URL to access and warns user if not
             if(forwards.empty())
                 System.out.println("Not Possible");
             else
                 URL =forwards.pop();
             System.out.println(URL);}
         //*************************************************************************************************************
         //ends program
        else if (command.equals("END")){
            System.out.println("Program ending...");}
        //************************************************************************************************************
        // sends error if invalid command entered
        else
            System.out.println("Invalid command\n");}
    //*********************************************************************************************************************
    //loops program until END command used
    while(!command.equals("END")); }}
