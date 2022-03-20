package Threads;

import Utils.DateUtil;
import beans.Person;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class BirthdayTask implements Runnable{
    private Set<Person> people;

    public BirthdayTask(Set<Person> people) {
        this.people = people;
    }

    @Override
    public void run() {
        while(true) {
            for (Person person : people) {
                if (person.getBirthday().isEqual(LocalDate.now())) {
                    System.out.println("Today is " + person.getName() + " 's birthday, he was born at " + DateUtil.BeautifyDate(LocalDate.now()) + "!");
                }
            }

            try {
                Thread.sleep(1000 * 60 * 60 * 24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
