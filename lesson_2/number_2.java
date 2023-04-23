import java.io.File;
import java.io.FileReader;

public class number_2 {
    public static void main(String[] args) {
        read_and_parse_txt();
    }

    public static void read_and_parse_txt() {
        String file_name = "C:/Users/79169/OneDrive/Рабочий стол/GeekBrains_Java__Prokushenkov_Seminars/GeekBrains_Java__Prokushenkov_Seminars/lesson_2/2.txt";
        File file = new File(file_name);
        try {
            FileReader f = new FileReader(file);
            char[] a = new char[(int) file.length()];
            f.read(a);
            StringBuilder sb = new StringBuilder();
            for (char c : a) {
                sb.append(c);
            }
            f.close();
            String line = sb.toString();
            line = line.replace("фамилия", "Студент");
            line = line.replace("оценка", "получил(а)");
            line = line.replace("предмет", "по предмету");
            line = line.replace("\"", "");
            line = line.replace(":", " ");
            line = line.replace(",", " ");
            System.out.println(line);
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}