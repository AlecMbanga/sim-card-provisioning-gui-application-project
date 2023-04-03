/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simwriting.Services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 *
 * @author alec
 */
public class programCardService extends Service
{
    
    private ArrayList<String> programParameters;
    
    public programCardService(ArrayList<String> programParameters)
    {
        this.programParameters = programParameters;
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
                String s2;
                ProcessBuilder pro = new ProcessBuilder(programParameters);
                ArrayList<String> results = new ArrayList<>();
                try 
                {
                    for(int i=0;i<programParameters.size();++i){
                        System.out.print(programParameters.get(i)+" ");
                    }
                    System.out.println();
                    Process p = pro.start();
                    int i = 0;
                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    boolean first = true;
                    while ((s = br.readLine()) != null)
                    {
                        results.add(s);
                        if(s.contains("---8<--") && first)
                        {
                            while((s2=br2.readLine())!= null)
                            {
                                results.add(s2);
                            }
                            first = false;
                        }
                        ++i;
                    }

                    p.destroy();
                } 
                catch (Exception e) 
                {
                    System.out.println ("Error : "+e);
                }
                return results;
            }
        };
    }  
}
