package contacts;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Record {
    private String number;
    private LocalDateTime createdAt;
    private LocalDateTime lastEdited;

    abstract String getSummary();

    private static boolean checkContact(String number){
        String regEx = "^(((?:(\\+\\d+)( |\\-))?|((\\w{2,})( |\\-))?)(\\(?\\w{2,}\\)?)?(( |\\-)?(\\w{2,})?)*)$|^(\\+?\\w*\\(?\\w+\\)?)$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public void setNumber(String number) {
        if(checkContact(number)) {
            this.number = number;
        } else {
            System.out.println("Wrong number format!");
        }
    }

    public void setCreatedAt(){
        createdAt = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public void setLastEdited() {
        lastEdited = LocalDateTime.now().withNano(0).withSecond(0);
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastEdited() {
        return lastEdited;
    }


    public String toString() {
        return "Number: " + (getNumber() != null ? getNumber() : "[no data]") + "\n" +
                "Time created: " + (getCreatedAt() != null ? getCreatedAt() : "[no data]") + "\n" +
                "Time last edit: " + (getLastEdited() != null ? getLastEdited() : "[no data]") ;
    }

    abstract void editRecord();

    abstract boolean search(String searchName);

    public boolean isPerson () {
        return this instanceof Person;
    }
}
