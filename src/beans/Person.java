package beans;

import Utils.DateFactory;
import Utils.DateUtil;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private static int count = 1;
    private int id = count;
    private String name = "Person" + count++;
//    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    private LocalDate birthday = DateFactory.getLocalDate();

    public Person() {
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Person other) {
        return this.getBirthday().getMonthValue() - other.getBirthday().getMonthValue();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + DateUtil.BeautifyDate(birthday) +
                '}';
    }
}
