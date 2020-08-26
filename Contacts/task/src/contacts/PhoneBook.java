package contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    List<Record> phonebook;
    Record record;
    Scanner scanner = new Scanner(System.in);
    String input;
    RecordFactory recordFactory;
    String filename ;

    PhoneBook(String filename){
        this.filename = filename;
        deserialize();
    }

    private void serialize(){
        try {
            SerializationUtils.serialize(phonebook, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deserialize(){
        try {
            this.phonebook = (List<Record>) SerializationUtils.deserialize(filename);
        } catch (IOException | ClassNotFoundException e) {
            this.phonebook = new ArrayList<>();
        }
    }


    public void menu(){
        while (true) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            switch (scanner.nextLine().trim().toLowerCase()) {
                case "add":
                    addContact();
                    break;
                case "search":
                    searchContact();
                    break;
                case "list":
                    displayInfo(this.phonebook);
                    break;
                case "count":
                    countContact();
                    break;
                case "exit":
                    serialize();
                    return;
                default:
                    System.out.println("Invalid Input");
            }
            System.out.println();

        }
    }

    private void printContact(List<Record> phoneBook) {

        int counter = 1;
        for(Record contact: phoneBook) {
            System.out.println(counter + ". " + contact.getSummary());
            counter++;
        }
    }



    private void countContact() {
        int size = phonebook.size();

        if (size == 0) {
            System.out.println("The Phone Book has 0 records");
        } else {
            System.out.println(size);
        }
    }

    private void addContact(){
        System.out.print("Enter the type (person, organization): ");
        input = scanner.nextLine();
        switch (input.trim().toLowerCase()) {
            case "person":
                recordFactory = new PersonRecordFactory();
                break;
            case "organization":
                recordFactory = new OrganizationRecordFactory();
                break;
            default:
                System.out.println("Invalid Input");
                return;
        }
        record = recordFactory.createRecord();
        phonebook.add(record);
        System.out.println("The record added.");
    }

    private void removeContact(Record record) {
       phonebook.remove(record);
    }

    private void searchContact(){
        String responce;
        System.out.print("Enter search query: ");
        String searchParam = scanner.nextLine();
        List<Record> searchList = new ArrayList<>();
        for(Record record : this.phonebook){
            if(record.search(searchParam)){
                searchList.add(record);
            }
        }
        System.out.println("Found " + searchList.size() + " results: ");
        if(searchList.size() == 0){
            searchContact();
        }else {
            printContact(searchList);
            System.out.println();
            System.out.print("[search] Enter action ([number], back, again):");
            responce = scanner.nextLine();
            switch (responce.trim().toLowerCase()) {
                case "again":
                    searchContact();
                    break;
                case "back":
                    break;
                default:
                    try {
                        manageRecord(searchList.get(Integer.parseInt(responce) - 1));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input");
                    }

            }
        }
    }

    private void manageRecord(Record record){
        System.out.println(record);
        System.out.println();
        System.out.print("[record] Enter action (edit, delete, menu)");

        switch (scanner.nextLine().toLowerCase().trim()){
            case "edit":
                record.editRecord();
                manageRecord(record);
                break;
            case "delete":
                removeContact(record);
                break;
            case "menu":
                break;
        }
        return;
    }

    private void displayInfo(List<Record> records) {
        String response;
        if(records.size() == 0){
            System.out.println("No records found");
        }else {
            printContact(records);
            System.out.println();
            System.out.print("Enter action ([number], back):");

            response = scanner.nextLine();
            switch (response.trim().toLowerCase()) {
                case "back":
                    break;
                default:
                    try {
                        manageRecord(records.get(Integer.parseInt(response) - 1));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input");

                    }
                    break;
            }
        }
    }

}
