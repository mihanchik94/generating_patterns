package task_1;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name should be specified");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Surname should be specified");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age can't be negative");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Name or surname was not specified");
        }
        if (age < 0) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }
        person.setAddress(address);
        return person;
    }
}