package contacts;

import java.util.Scanner;

public class OrganizationRecordFactory implements RecordFactory{
    Scanner scanner = new Scanner(System.in);

    @Override
    public Record createRecord() {
        Organization organisation = new Organization();
        System.out.print("Enter the organization name: ");
        organisation.setName(scanner.nextLine());

        System.out.print("Enter the address: ");
        organisation.setAddress(scanner.nextLine());

        System.out.print("Enter the number: ");
        organisation.setNumber(scanner.nextLine());

        organisation.setCreatedAt();
        organisation.setLastEdited();
        return organisation;
    }


}
