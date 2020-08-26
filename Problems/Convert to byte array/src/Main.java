import java.io.IOException;


class Converter {
    public static char[] convert(String[] words) throws IOException {
        String sentence = String.join("", words);
        char[] result = sentence.toCharArray();
        return result;
    }
}