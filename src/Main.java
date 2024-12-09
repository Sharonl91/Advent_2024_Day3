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
        ArrayList<Integer> answer = new ArrayList<>();
        Pattern p = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Matcher m = p.matcher(fileData);
        while (m.find()){
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            answer.add(x*y);
        }
        int total = 0;
        for (int i : answer){
            total+=i;
        }
        System.out.println(total);
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