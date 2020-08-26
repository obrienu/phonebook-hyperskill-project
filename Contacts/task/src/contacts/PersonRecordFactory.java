package contacts;

import java.util.Scanner;

public class PersonRecordFactory implements RecordFactory{
    Scanner scanner = new Scanner(System.in);

    @Override
    public Record createRecord() {
        Person person = new Person();
        System.out.print("Enter the name: ");
        person.setName(scanner.nextLine());

        System.out.print("Enter the surname: ");
        person.setSurname(scanner.nextLine());

        System.out.print("Enter the birth date: ");
        person.setBirthDate(scanner.nextLine());

        System.out.print("Enter the gender (M, F): ");
        person.setGender(scanner.nextLine());

        System.out.print("Enter the number: ");
        person.setNumber(scanner.nextLine());

        person.setCreatedAt();
        person.setLastEdited();
        return person;
    }


}
