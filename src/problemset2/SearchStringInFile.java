package problemset2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchStringInFile {

    public static void main(String[] args) throws FileNotFoundException {

        String filePath = System.getProperty("user.dir") + "/coding standard.txt";
        System.out.println(filePath);
        System.out.println("Is Found:" + new SearchStringInFile().isStringFoundInFile(filePath, "zzz"));

    }

    public boolean isStringFoundInFile(String filePath, String searchKey) throws FileNotFoundException {
        boolean isStringFound = false;
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        String lineData = "";
        while (scan.hasNext()) {
            lineData = scan.nextLine();
            if (lineData.contains(searchKey)) {
                isStringFound = true;
                break;
            }

        }

        return isStringFound;
    }
}
