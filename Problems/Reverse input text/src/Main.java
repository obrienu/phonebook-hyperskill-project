import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Character> characterList = new ArrayList<>();
        int val = reader.read();
        while (val > -1) {
            characterList.add((char) val);
            val = reader.read();
        }
        for (int i = characterList.size() - 1; i >= 0; i--) {
            System.out.print(characterList.get(i));
        }
        reader.close();
    }
}