package java16.midels;

import java16.enums.Gender;

public class Doctor {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int experienceYear;
    private static Long genId = 1L;

    public Doctor() {
        this.id = genId++;
    }

    public Doctor(String firstName, String lastName, Gender gender, int experienceYear) {
        this.id = genId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.experienceYear = experienceYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getExperienceYear() {
        return experienceYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;

    }

    @Override
    public String toString() {
        return "Doctor{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", gender=" + gender +
               ", experienceYear=" + experienceYear +
               '}';
    }
}
