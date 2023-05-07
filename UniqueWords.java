package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueWords {

    public static void main(String[] args) throws IOException {

        Map<String, Integer> wordCount = new HashMap<>();

        FileReader fr = new FileReader("christmas_carol.txt");
        BufferedReader br = new BufferedReader(fr);

        Scanner scanner = new Scanner(br);

        String line;

        //print out words without punctuation

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            line = line.trim().toLowerCase().replaceAll("\\p{Punct}", "");

            for(String w : line.split("\\s+")) {
                String tmp = w.trim();

        //print out without stopwords        
                
                if (tmp.length() <= 0 || (StopWords.STOPWORDS_SET.contains(tmp))) {
                    continue;
                }    
               
                if (!wordCount.containsKey(tmp)) {
                    wordCount.put(tmp,0);
                
                } else {
                    wordCount.put(tmp, wordCount.get(tmp) +1);
                }    

            }

        }
            br.close();
            

            for (String k: wordCount.keySet()) {
                System.out.printf("word: %s, count: %d\n", k, wordCount.get(k));
            }
            System.out.println("The number of unique words are: " + wordCount.size());
    
    }
    


}


// print out word and word count