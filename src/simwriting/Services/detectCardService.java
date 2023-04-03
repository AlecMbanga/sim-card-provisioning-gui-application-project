/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simwriting.Services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 *
 * @author alec
 */
public class detectCardService extends Service 
{
          
    @Override
    protected Task<ArrayList<String>> createTask() {
         return new Task<ArrayList<String>>() 
         {
            @Override
            protected ArrayList<String> call() throws Exception 
            {
                String s;
                Process p;
                ArrayList<String> cards = new ArrayList<>();
                try 
                {
                    String temp = "";
                    p = Runtime.getRuntime().exec("pcsc_scan");
                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    while ((s = br.readLine()) != null && s.length()!=3)
                    {
                        if(s.contains("Reader"))
                        {
                            if(s.contains("Reader 0:"))
                            {
                                temp="Reader 0";
                            }
                            else if(s.contains("Reader 1:"))
                            {
                                temp="Reader 1";
                            }
                            else if(s.contains("Reader 2:"))
                            {
                                temp="Reader 2";
                            }
                        }
                        else if(s.contains("Card state: Card inserted"))
                        {
                            cards.add(temp);
                            temp = "";
                        }
                    }
                    p.destroy();
                }
                catch (Exception e) 
                {
                    System.out.println ("Card Detect Error: "+e);
                }
                return cards;                  
            }
        };
    }   
}
