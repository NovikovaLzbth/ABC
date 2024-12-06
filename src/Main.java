import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        String text = new String(Files.readAllBytes(Paths.get("fl.txt")));
        System.out.println("Максимальное количество последовательных пар: " + maxPairs(text));
    }

    private static int maxPairs(String text) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < text.length() - 1; i++) {
            String pair = text.substring(i, i + 2);
            if (pair.equals("AB") || pair.equals("CB")) {
                count++;
                maxCount = Math.max(maxCount, count);
                i++; // пропуск следующего символа, чтобы не считать его в текущей паре
            } else {
                count = 0; // сброс счетчика
            }
        }

        return maxCount;
    }
}


