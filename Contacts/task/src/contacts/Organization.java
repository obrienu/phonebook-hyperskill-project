package contacts;

import java.io.Serializable;
import java.util.Scanner;

public class Organization extends Record implements Serializable {
    private String name;
    private String address;
    private static long serialVersionUID = 124343L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void editRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a field (name, address, number): ");
        String field = scanner.nextLine();
        field = field.trim().toLowerCase();
        System.out.print("Enter " + field + ": ");
        String value = scanner.nextLine();
        editfield(field, value);
        System.out.println("Saved");
    }

    private void editfield(String field, String value) {

        switch (field) {
            case "name":
                this.setName(value);
                break;
            case "address":
                this.setAddress(value);
                break;
            case "number":
                this.setNumber(value);
                break;
        }
        this.setLastEdited();
    }

    @Override
    public String getSummary(){
        return getName();
    }

    @Override
    public boolean search(String searchParam){
        return this.name.toLowerCase().contains(searchParam) || this.getNumber().contains(searchParam);
    }

    @Override
    public String toString() {
        return "Organization name: " + (getName() != null ? getName() : "[no data]") + "\n" +
                "Address: " + (getAddress() != null ? getAddress() : "[no data]") + "\n" +
                super.toString();
    }
}
