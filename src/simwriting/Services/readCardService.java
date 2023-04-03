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
public class readCardService extends Service
{
    
    private ArrayList<String> parameters;
    
    public readCardService(ArrayList<String> parameters)
    {
        this.parameters = parameters;
    }

    @Override
    protected Task<ArrayList<String>> createTask() 
    {
        return new Task<ArrayList<String>>() 
        {
            @Override
            protected ArrayList<String> call() throws Exception 
            {
                String s;
                ProcessBuilder pro = new ProcessBuilder(parameters);
                ArrayList<String> results = new ArrayList<>();
                try 
                {
                    Process p = pro.start();
                    BufferedReader br = new BufferedReader(
                        new InputStreamReader(p.getInputStream()));
                    while ((s = br.readLine()) != null)
                    {
                            results.add(s);               
                    }
                    p.destroy();
                } catch (Exception e) 
                {
                    System.out.println ("Error: "+e);
                }
                return results;
            }
        };
    }
    
}
