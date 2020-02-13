package com.hw.airport.sGUI;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon Grange, Safa Al Ameri
 */

public class PassengerSuperClass {
    
    int pno;
    String name;
    String email;
    String DOB;
    String country;
    String category;
    String level;      
    
    public PassengerSuperClass getFullDetails(String pno){
        try{

            PassengerSubClass obj = new PassengerSubClass();          
            
                FileReader fr = new FileReader("Passengers.txt");
                BufferedReader br = new BufferedReader(fr);

                String f = null;
                String parts[]=null;
                while((f = br.readLine())!=null){
                    parts = f.split(",");
                    if(parts[0].equals(pno))
                    break;
                }
                fr.close();
                br.close();
                if(f==null){
                    JOptionPane.showMessageDialog(null, "No Passenger Found! Please try again.");
                    return null;
                }else{
                    
                    obj.pno = Integer.parseInt(pno);
                    obj.name=parts[1];
                    obj.email=parts[2];
                    obj.DOB=parts[3];
                    obj.country=parts[4];
                    obj.level=parts[6];
                    obj.category=parts[5];
                    
                    return obj;

                }
                // Exception handling when there is no competitor in the list in "Competitors.txt" that can be parsed;
            }catch(IOException ex1){

                JOptionPane.showMessageDialog(null, "No Passenger Found! Please try again.");
                
            }
        return null;
    }
    
    
     
    
    double getOverallScore(int[] array){
       
        int overall=0;
        for(int i=0;i<array.length;i++){
            overall=overall+array[i];
        }
        float oscore = (float)overall/5; 
        return oscore;
        
    }
    
}




