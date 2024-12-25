package java16.midels;

import java16.enums.Gender;

public class Patient {
    private Long id;
    private String firtName;
    private String lastName;
    private Gender gender;
    private int age;

    private static Long genId = 1L;

    public Patient() {
        this.id = genId++;
    }

    public Patient(String firtName, String lastName, Gender gender, int experirnceYear) {
        this.id = genId++;
        this.firtName = firtName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = experirnceYear;
    }

    public Patient(String firtName, String lastName,  int experirnceYear) {
        this.id = genId++;
        this.firtName = firtName;
        this.lastName = lastName;

        this.age = experirnceYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
               "id=" + id +
               ", firtName='" + firtName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", gender=" + gender +
               ", age=" + age +
               '}';
    }
}
