import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        File dir = new File("C://Users//Beth//Desktop");
        countWords(dir);
    }

    private static void countWords(File dir) throws IOException {
        File[] files = dir.listFiles();
        int count = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                countWords(file);
            } else if (file.getName().endsWith(".txt")) {
                int lineCount = 0;
                FileInputStream fis = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    lineCount += words.length;
                }
                System.out.printf("Файл %s содержит %d слов.\n", file.getName(), lineCount);
                count += lineCount;
                br.close();
                fis.close();
                System.out.printf("Общее количество слов во всех файлов: %d\n", count);
            }
        }

    }
}
