package contacts;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PhoneBook phonebook;
        if(args.length == 0){
            phonebook = new PhoneBook("");
        }else{
            phonebook = new PhoneBook(args[0]);
        }
        phonebook.menu();
    }
}
