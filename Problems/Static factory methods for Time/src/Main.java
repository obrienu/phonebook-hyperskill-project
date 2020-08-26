import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        Time newTime = new Time();
        newTime.hour = 12;
        newTime.minute = 0;
        newTime.second = 0;
        return newTime;
    }

    public static Time midnight() {
        Time newTime = new Time();
        newTime.hour = 0;
        newTime.minute = 0;
        newTime.second = 0;
        return newTime;
    }

    public static Time ofSeconds(long seconds) {
        int totalHours = (int) (seconds / 3600);
        int remainingSec = (int) (seconds % 3600);
        Time newTime = new Time();
        newTime.hour = totalHours > 23 ? totalHours % 24 : totalHours ;
        newTime.minute = remainingSec / 60;
        newTime.second = remainingSec % 60;
        return newTime;
    }

    public static Time of(int hour, int minute, int second) {

        if(
                hour >= 0 && hour < 24
                && minute >= 0 && minute < 60
                && second >= 0 && second < 60
        ){
            Time newTime = new Time();
            newTime.hour = hour;
            newTime.minute = minute;
            newTime.second = second;
            return newTime;
        }
        return null;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}