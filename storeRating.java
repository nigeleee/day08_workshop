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

        while (null != (line = br.readLine())) {
           String[] formattedWords = line.split(delimitter); 
           String category = formattedWords[1]; 
           String rating = formattedWords[2];

           if(rating.equals("NaN")) {
            continue; 
        
           }           

           if(category.equals("1.9")) {
            continue;

           }

           Double value = Double.parseDouble(rating);
           
           if(!highestRating.containsKey(category) || value < highestRating.size()) {
                highestRating.put(category, value);

           }

           if(!lowestRating.containsKey(category) || value > lowestRating.size()){
                lowestRating.put(category, value);

           }

           
          } 

       
            

            System.out.println(highestRating);
            System.out.println("------------");
            System.out.println(lowestRating);
           
            br.close(); 
            fr.close();

          }

          
    

  

          }

 
       

