import java.util.*;
import java.util.Scanner;


public class IHM{


public static void main(String[] args){

Directory employeeDirectory = new Directory(1L,"employee directory");
menu(employeeDirectory);

}

private static void menu(Directory employeeDirectory){

System.out.println("Welcome in the employee manager application, select a command: 1.Add a contact2.List contacts 3.Quit the app");

Scanner scanner = new Scanner(System.in);

int chosenCommand = scanner.nextInt();

switch(chosenCommand){
    case 1 -> addAContact(employeeDirectory);
    case 2 -> seeAllContact(employeeDirectory);
    case 3 -> quitProgram();
}


}


private static void addAContact(Directory employeeDirectory){

Scanner scanner = new Scanner(System.in);

System.out.println("let s add a new employee What is the first name ?");

String firstName = scanner.nextLine();

System.out.println("What is the last name ?");

String lastName = scanner.nextLine();

System.out.println("What is the phone number ?");

String phoneNumber = scanner.nextLine();

Person newPerson = new Person(1L, firstName,lastName,phoneNumber);
Set<Person> personSet = employeeDirectory.getPersonSet();
personSet.add(newPerson);

System.out.println("done");

menu(employeeDirectory);

}

private static void seeAllContact(Directory employeeDirectory){

System.out.println("All employees List:");

 employeeDirectory.getPersonSet().forEach((Person person) -> {
        System.out.println(person.getFirstname());
    });

menu(employeeDirectory);

}

private static void quitProgram(){
        System.out.println("bye");
        System.exit(0);
}



}