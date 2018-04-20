import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    private static String[] stringFromFile;


    public static List<String> readFileToString (File file){
        try {
            stringFromFile = FileUtils.readFileToString(file).split("[ \n?]");

        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i = 0; i < stringFromFile.length; i++) {
            stringArrayList.add(stringFromFile[i]);
        }

        return stringArrayList;
    }

    public static void printOriginal (List<String> stringList){
        String toPrint = stringList.toString().replaceAll(",", "");
        toPrint = toPrint.replaceAll("\n", "");

        System.out.println(toPrint);
    }

    public static void printSorted(List<String> stringList){
        stringList.sort(Comparator.naturalOrder());
        Collections.reverse(stringList);

        String toPrint = stringList.toString().replaceAll(",", "");
        toPrint = toPrint.replaceAll("\n", "");

        System.out.println(toPrint);
    }

    public static void bonus(List<String> stringList){
        int[] count = new int[stringList.size()];

        for (int i = 0; i < stringList.size(); i++) {
            for (int j = 0; j < stringList.size(); j++) {
                if(stringList.get(i).equals(stringList.get(j))){
                    count[i]++;
                }
            }
            System.out.println(stringList.get(i) + ": " + count[i]);
        }
    }


    public static void main(String[] args) {
        File fileFromTxt = FileUtils.getFile("lab13_testcase.txt");
        System.out.println("Original :");
        printOriginal(readFileToString(fileFromTxt));

        System.out.println("Sorted :");
        printSorted(readFileToString(fileFromTxt));

        System.out.println("\nFrequency :");
        bonus(readFileToString(fileFromTxt));

    }

}
