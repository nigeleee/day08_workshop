package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class storeRating {

    public static void main(String[] args) throws IOException {

        String fileName = "googleplaystore.csv";
        String delimitter = ",";

        Map<String, Double> lowestRating = new HashMap<>();
        Map<String, Double> highestRating = new HashMap<>();
        Map<String, Double> averageRating = new HashMap<>();

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;

        line = br.readLine();

        while ((line = br.readLine()) != null) {
            String[] formattedWords = line.split(delimitter);
            String category = formattedWords[1];

            if (formattedWords[2].equals("NaN")) {
                continue;

            }

            if (category.equals("1.9")) {
                continue;

            }

            Double rating = Double.parseDouble(formattedWords[2]);

            if (!highestRating.containsKey(category) || rating > highestRating.get(category)) {
                highestRating.put(category, rating);

            }

            if (!lowestRating.containsKey(category) || rating < lowestRating.get(category)) {
                lowestRating.put(category, rating);

            }

        }

        System.out.println(highestRating);
        System.out.println("------------");
        System.out.println(lowestRating);

        br.close();
        fr.close();

    }

}
