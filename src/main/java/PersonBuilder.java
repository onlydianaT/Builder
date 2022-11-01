import java.util.Objects;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected String address;
    protected int age;
    String t = (String) null;

    public PersonBuilder setName(String name) {
        if (Objects.hashCode(this.name) == Objects.hashCode(t)) {
            this.name = name;
            return this;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (Objects.hashCode(this.surname) == Objects.hashCode(t)) {
            this.surname = surname;
            return this;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Некорректный возраст");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = new Person(this.name, this.surname, this.age, this.address);
        int hashCodeNull = Objects.hashCode(t);
        int hashCodeSurname = Objects.hashCode(person.getSurname());
        int hashCodeName = Objects.hashCode(person.getName());
        if (hashCodeNull != hashCodeSurname && hashCodeNull != hashCodeName) {
            if (person.hasAge()) {
                if (age > 0 && age < 100) {
                    return new Person(name, surname, age, address);
                } else if (age == 0) {
                    return new Person(name, surname);
                }
            }
        } else {
            System.out.println(new IllegalStateException("Не задано одно из обязательных полей: Имя и/или фамилия"));
            return new Person(name, surname);
        }
        return new Person(name, surname);
    }
}
