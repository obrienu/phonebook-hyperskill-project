import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> arrlist = new ArrayList<>();
        int counter = 1;
        
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        
        int searchNumber = numbers.get(numbers.size() - 1 );
        numbers.remove(numbers.size() - 1);
        getNum(arrlist, searchNumber , numbers);
                        
        while (arrlist.size() == 0) {
            getNum(arrlist, searchNumber + counter, numbers);
            getNum(arrlist, searchNumber - counter, numbers);
            counter++;
        }
        
        Collections.sort(arrlist);
        
        for (Integer num: arrlist) {
            System.out.print(num + " ");
        }
    }
    public static void getNum(ArrayList<Integer> list, int number, ArrayList<Integer> checkList) {
        for (Integer num: checkList) {
            if (num.equals(number)) {
                list.add(number);
            }
        }
    }
}
