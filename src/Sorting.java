import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sorting {
    private static String[] stringFromFile;


    public static List<String> readFileToString (File file){
        try {
            //stringFromFile = FileUtils.readFileToString(file).split("[ \n?]");
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null){
                stringFromFile = line.split("[ \n?]");
            }
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
        //stringList.sort(Comparator.naturalOrder());
        //Collections.reverse(stringList);
        sort(stringList);

        String toPrint = stringList.toString().replaceAll(",", "");
        toPrint = toPrint.replaceAll("\n", "");

        System.out.println(toPrint);
    }

    public static void sort(List<String> stringList){
        String temp;

        for (int i = 0; i < stringList.size()-1; i++) {
            for (int j = 0; j < (stringList.size() - i - 1); j++) {
                if(stringList.get(j+1).compareTo(stringList.get(j)) > 0){
				    temp = stringList.get(j);
					stringList.set(j, stringList.get(j+1));
					stringList.set(j+1, temp);
                }
            }
        }
    }

    public static void bonus(List<String> stringList){
        sort(stringList);
        int[] count = new int[stringList.size()];

        for (int i = 0; i < stringList.size(); i++) {
            for (int j = 0; j < stringList.size(); j++) {
                if(stringList.get(i).equals(stringList.get(j))){
                    count[i]++;
                }
            }
            if(i < stringList.size()-1){
                if (!stringList.get(i).equals(stringList.get(i+1))){
                    System.out.println(stringList.get(i) + ": " + count[i]);
                }
            }
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
