import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        ArrayList<String> answer = new ArrayList<>();
        int total = 0;
        Pattern p = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Pattern able = Pattern.compile("do\\(\\)");
        Pattern disable = Pattern.compile("don't\\(\\)");
        for(String sentence : fileData) {
            Matcher wrong = disable.matcher(sentence);
            Matcher correct = able.matcher(sentence);
            Matcher m = p.matcher(sentence);
            for (int start = 0; start < sentence.length();start++){
                sentence = sentence.substring(start);
                if (wrong.find()){
                    answer.add(wrong.group());
                }
                if (correct.find()){
                    answer.add(correct.group());
                }
                if (m.find()) {
                    answer.add(m.group());
                }
            }
        }
        for (String i : answer){
            System.out.println(i);
//            i=i.substring(4);
//            int len = i.length();
//            i=i.substring(0,len-1);
//            String[] xy = i.split(",");
//            int x = Integer.parseInt(xy[0]);
//            int y = Integer.parseInt(xy[1]);
//            total+=x*y;
        }
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}