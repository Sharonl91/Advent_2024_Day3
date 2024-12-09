import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String fileData = getFileData("src/Day1Input.txt");
        getAnswer(fileData);

    }

    public static ArrayList<Integer> getAnswer(String fileData) {
        ArrayList<Integer> answer = new ArrayList<>();
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(fileData);
        while (m.find()) {
            int n = Integer.parseInt(m.group());
            answer.add(n);
        }
        return answer;
    }
    public static String getFileData(String fileName) {
        String fileData = "";
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.isEmpty())
                    fileData.concat(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}