package com.hw.airport.sGUI;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simon Grange, Safa Al Ameri, 
 */
public class PassengerSubClass extends PassengerSuperClass{
    
    int[] score = {0,0,0,0};
    double overallScore=0;
    
    public int[] getScoreArray(int pno){
        int[] score=null;
        
        try{

                FileReader fr = new FileReader("CheckIn.txt");
                BufferedReader br = new BufferedReader(fr);

                String f = null;
                String parts[]=null;
                while((f = br.readLine())!=null){
                    parts = f.split(",");
                    if(Integer.parseInt(parts[0])==pno)
                    break;
                }
                fr.close();
                br.close();
                if(f==null){
                    return null;
                }else{
                    
                    score[0] = Integer.parseInt(parts[2]);
                    score[1] = Integer.parseInt(parts[3]);
                    score[2] = Integer.parseInt(parts[4]);
                    score[3] = Integer.parseInt(parts[5]);
                  //  score[4] = Integer.parseInt(parts[6]);
                }

            }catch(IOException ex1){

                return null;
            }

        return score;
    }
    
    public PassengerSubClass getShortDetails(String pno){
        PassengerSubClass obj = new PassengerSubClass();
        
        
        try{
            FileReader fr = new FileReader("CheckIn.txt");
                BufferedReader br = new BufferedReader(fr);

                String f = null;
                String parts[]=null;
                while((f = br.readLine())!=null){
                    parts = f.split(",");
                    if(parts[0].equals(pno)){
                    break;
                    }
                }
                fr.close();
                br.close();
                if(f==null){
                    JOptionPane.showMessageDialog(null, "No Competitor Found!");
                }else{

                    obj.pno = Integer.parseInt(pno);
                    obj.name = parts[1];
                    obj.score[0]=Integer.parseInt(parts[2]);
                    obj.score[1]=Integer.parseInt(parts[3]);
                    obj.score[2]=Integer.parseInt(parts[4]);
                    obj.score[3]=Integer.parseInt(parts[5]);
                 //   obj.score[4]=Integer.parseInt(parts[6]);
                    
                    return obj;

                }

            }catch(IOException ex1){

                JOptionPane.showMessageDialog(null, "No Passenger Found!!");
                return null;
            }
        return null;
    }  
    
    
}
