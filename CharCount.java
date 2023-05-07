package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CharCount {

    public static void main(String[] args) throws IOException {

        Map<Character, Integer> charCount = new HashMap<>();

        FileReader fr = new FileReader("christmas_carol.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim().toLowerCase().replaceAll("\\p{Punct}", "");
            char[] strArray = line.toCharArray(); 
            
        for (char c: strArray) {
            if(c != ' ' && charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c,1);
            }

        }   
    }
    br.close();
        
        for (Map.Entry entry : charCount.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }    
        }         
        

    }


    




