package com.hw.airport.sGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simon Grange, Safa Al Ameri
 */
public class CheckIn {
    
    /***ArrayList of Competitor Objects**/
    
    public ArrayList getReport(){
        
        ArrayList<PassengerSubClass> a= new ArrayList();
        
        PassengerSubClass[] obj = new PassengerSubClass[100]; 

        
        try{
            
            FileReader fr = new FileReader("CheckIn.txt");
            BufferedReader br = new BufferedReader(fr);

                String f = null;
                String parts[]=null;
                int i=0;
                while((f = br.readLine())!=null){
                    
                    obj[i] = new PassengerSubClass();
                    
                    parts = f.split(",");
                    
                    obj[i].pno = Integer.parseInt(parts[0]);
                    obj[i].name = parts[1];
                    obj[i].score[0]=Integer.parseInt(parts[2]);
                    obj[i].score[1]=Integer.parseInt(parts[3]);
                    obj[i].score[2]=Integer.parseInt(parts[4]);
                    obj[i].score[3]=Integer.parseInt(parts[5]);
                   // obj[i].score[4]=Integer.parseInt(parts[6]);
                    obj[i].overallScore = obj[i].getOverallScore(obj[i].score);
                    i++;
                }
                fr.close();
                br.close();
                
                for(int j=0;j<i;j++){
                    a.add(obj[j]);
                }
                
        }catch(Exception ex){
                System.out.println(ex);
                return null;
        }
    
                
        
        return a;
        
    }
    
    
    
}
