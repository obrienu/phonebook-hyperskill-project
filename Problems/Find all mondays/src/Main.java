
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate date, newDate;
        date = LocalDate.of(year, month, 01);
        for (int i = 1; i <= date.lengthOfMonth()  ; i++) {
            newDate = LocalDate.of(year, month, i);
            if(newDate.getDayOfWeek().getValue()== 1) {
                System.out.println(newDate);
            }
        }
    }
}