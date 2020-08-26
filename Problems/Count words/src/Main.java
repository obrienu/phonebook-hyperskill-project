import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        int letter = reader.read();


        while (letter > -1) {
            string += (char) letter;
            letter = reader.read();
        }
        reader.close();
        if (string.trim().isEmpty()){
            System.out.println(0);
            return;
        }
        System.out.println(string.trim().split("\\s+").length);
    }
}