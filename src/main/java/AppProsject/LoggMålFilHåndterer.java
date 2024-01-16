package AppProsject;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LoggMålFilHåndterer {

    private Mål mål;


    public LoggMålFilHåndterer(Mål x){
        this.mål=x;

    }



    public void skrivLoggTilFilLoggMålFilHåndterer(String filename){
        mål.getLoggFromFile("TestSkrivLogg");
        konverterFraStrengtilListe();


        try {
            PrintWriter writer = new PrintWriter(filename);
           List<List> Logg=mål.getLogg();
            
            for(List<List> listemedLogg:Logg){
                writer.println(listemedLogg);
            

            }
            
         
                
            

            
           
            

            

           
            
            

            writer.flush();
            writer.close();
           
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }








    public void getLoggFromFileLoggMålFilHåndterer(String filename){
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                mål.gettidligereLoggStreng().add(line);
               

                
                
               
                
                
                
           


            }
            scanner.close();
            
            mål.gettidligereLoggStreng().clear();
            
            
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void konverterFraStrengtilListe() {
        
        for (String x : mål.gettidligereLoggStreng()) {
            List<String> d = Arrays.asList(x.replaceAll("\\[|\\]", "").split(", "));
            mål.getLogg().add(d);
        }
    }

    public void getLoggFromFileMainLoggMålFilHåndterer(String filename){
        double antallLogg=mål.getantallLogg();
        antallLogg=0;
        mål.getLogg().clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                mål.gettidligereLoggStreng().add(line);
               

                
                
               
                
                
                
           


            }
            scanner.close();
            for (String x : mål.gettidligereLoggStreng()) {
                List<String> d = Arrays.asList(x.replaceAll("\\[|\\]", "").split(", "));
                mål.getLogg().add(d);
            }
            mål.gettidligereLoggStreng().clear();
            mål.setantallLogg();
            mål.setInnsatspoeng();
            
            
            
            
            
            
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }

    }













    
}
