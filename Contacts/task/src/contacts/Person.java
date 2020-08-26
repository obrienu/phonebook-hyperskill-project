package contacts;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Person extends Record implements Serializable {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;
    private static long serialVersionUID = 123343L;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate == null || birthDate.trim().isEmpty()) {
            System.out.println("Bad birth date!");
            return;
        }
        this.birthDate = LocalDate.parse(birthDate);
    }

    public void setGender(String gender) {
        if ("M".toUpperCase().equals(gender)) {
            this.gender = "Male";
            return;
        }

        if ("F".toUpperCase().equals(gender)) {
            this.gender = "Female";
            return;
        }

        System.out.println("Bad gender!");

    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String getSummary(){
        return getName() + " " + getSurname();
    }


    @Override
    public void editRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String field = scanner.nextLine();
        field = field.trim().toLowerCase();
        System.out.print("Enter " + field + ": ");
        editfield(field);
        System.out.println("Saved");
    }

    private void editfield(String field) {
        Scanner scanner = new Scanner(System.in);
        switch (field) {
            case "name":
                this.setName(scanner.nextLine());
                break;
            case "surname":
                this.setSurname(scanner.nextLine());
                break;
            case "birth":
                this.setBirthDate(scanner.nextLine());
                break;
            case "gender":
                this.setGender(scanner.nextLine());
                break;
            case "number":
                this.setNumber(scanner.nextLine());
                break;
        }
        this.setLastEdited();
    }

    @Override
    public boolean search(String searchParam){
        return this.surname.toLowerCase().contains(searchParam.toLowerCase())
                || this.name.toLowerCase().contains(searchParam.toLowerCase())
                || this.getNumber().contains(searchParam)    ;
    }

    @Override
    public String toString() {

        return "Name: " + getName() + "\n" +
                "Surname: " + getSurname() + "\n" +
                "Birth date: " + (getBirthDate() != null ? getBirthDate() : "[no data]") + "\n" +
                "Gender: " + (getGender() != null ? getGender() : "[no data]") + "\n" +
                super.toString();
    }
}
