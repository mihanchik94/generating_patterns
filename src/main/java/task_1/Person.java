package task_1;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        if (!hasAddress()) {
            return "Адрес не указан";
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public boolean hasAddress() {
        return address != null;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAge(0).setAddress(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", address='" + address + '\''
                + '}';
    }
}