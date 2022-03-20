package Run;

import Threads.BirthdayTask;
import Utils.BirthdayStatistics;
import Utils.DateUtil;
import beans.Person;

import java.util.*;

public class BirthdaySystemReminder {
    private Set<Person> people = null;
//    private BirthdayTask task;
    private static Scanner scanner = new Scanner(System.in);
    private static BirthdaySystemReminder instance = null;

    private BirthdaySystemReminder(){
        people = new HashSet<>();
        Thread thread = new Thread(new BirthdayTask(people));
        thread.start();
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public static BirthdaySystemReminder getInstance() {
        if(instance == null){
            instance = new BirthdaySystemReminder();
        }
        return instance;
    }

    public void showMenu(){
        do {
            System.out.println("To add a friend press 1");
            System.out.println("To delete a friend press 2");
            System.out.println("To print the list in a sorted way press 3");
            System.out.println("To print all the people in the system press 4");
            System.out.println("To print the month with the most birthdays press 5");
            System.out.println("To print the month with the least birthdays press 6");
            System.out.println("To print how many birthdays each month has press 7");
            System.out.println("To exit press 8");

            int input = scanner.nextInt();
            switch(input){
                case 1:
                    addPerson();
                    break;
                case 2:
                    System.out.println("Please choose an ID:");
                    int id = scanner.nextInt();
                    deletePerson(id);
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    System.out.println("Amount of people in the system " + BirthdayStatistics.countMembers());
                    break;
                case 5:
                    printHappyMonth();
                    break;
                case 6:
                    printSadMonth();
                    break;
                case 7:
                    printEvents();
                    break;
                case 8:
                    endSystem();
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }while(true);
    }

    public void startSystem(){
        System.out.println("Hello and welcome to the birthday system");
        showMenu();
    }

    public void endSystem(){
        System.out.println("Thank you and goodbye");
    }

    public void addPerson(){
        // TODO use fact method maybe??? also, the param is PROBABLY redundant
        people.add(DateUtil.initPerson());
        System.out.println("Person added successfully");
    }

    public void deletePerson(int id){
        for (Person person : people) {
            if(person.getId() == id){
                people.remove(person);
                return;
            }
        }
        System.out.println("Person not found");
    }

    public void printAll(){
        List<Person> peopleList = new ArrayList<>(people);
        Collections.sort(peopleList);
//        Collections.sort(peopleList, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                if(o1.getBirthday().isEqual(o2.getBirthday())){
//                    return 1;
//                }
//                return o1.compareTo(o2);
////                return o1.getBirthday().compareTo(o2.getBirthday());
//            }
//        });
        for (Person person : peopleList) {
            System.out.println(person);
        }
    }

    public void printCount(){
        System.out.println(people.size() + " people exist in the system");
    }

    public void printHappyMonth(){
        System.out.println("The month with the most birthdays is " + BirthdayStatistics.getHappyMonth());
    }

    public void printSadMonth(){
        System.out.println("The month with the least birthdays is " + BirthdayStatistics.getSadlyMonth());
    }

    public void printEvents(){
        System.out.println("Months and how many birthdays each have");
        for (Integer key : BirthdayStatistics.getEvents().keySet()) {
            System.out.println(key + 1 + " = " + BirthdayStatistics.getEvents().get(key));
        }
    }

    public void printStatistics(){
        printCount();
        printEvents();
        printHappyMonth();
        printSadMonth();
    }
}