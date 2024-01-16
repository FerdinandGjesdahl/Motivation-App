package AppProsject;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class Mål {

    private String Mål;


 
    
   private List<String> tidligereloggStreng=new ArrayList<>();

   private List<String> tidligereloggStreng2=new ArrayList<>();

   private double innsatspoeng;
    

    private List <List> Logg =new ArrayList<>();

    private List<List> Logg2=new ArrayList<>();

    private double antallLogg;

    private double antallLogg2;

    public void setantallLogg(){
        antallLogg=Logg.size();
    }

    public void seantallLogg2(){
        antallLogg2=Logg2.size();
    }

    public double getantallLogg(){
        return antallLogg;
    }


    public List<String> gettidligereLoggStreng(){
        return tidligereloggStreng;

    }


    
    public Mål(String Mål){
        this.Mål=Mål;




        }
        public double getInnsatsopoeng(){
            return innsatspoeng;
        }

        public void setInnsatspoeng(){
            innsatspoeng=0;
            for(List logg: Logg){
                String x=logg.get(1).toString().replaceAll("[^\\d]", "");
                try {
                    innsatspoeng = innsatspoeng + Integer.parseInt(x);
                } catch (NumberFormatException e) {
                    // håndter ugyldige tall her
                    System.out.println("Ugyldig tall i listen: " + logg.get(1));
                }
            }

        }


    public void SkrivLogg(String GjordeBra, Integer innsatstall, String Forbedring){
        List <Logg> Måldagbok =new ArrayList<>();
        GjordeBra gjordeBra2=new GjordeBra(GjordeBra);
        Måldagbok.add(gjordeBra2);
        Innsats innsats1=new Innsats(innsatstall);
        Måldagbok.add(innsats1);
        Forbedring forbedring2=new Forbedring(Forbedring);
        Måldagbok.add(forbedring2);
        Logg.add(Måldagbok);
        }

        public List getLogg(){
            
            return Logg;

        }

        public String getMålNavn(){
            return Mål;
        }







    @Override
    public String toString() {
        return "Mål: "+ Mål;
    }

    public void skrivLoggTilFil(String filename){
        try {
            PrintWriter writer = new PrintWriter(filename);
            List<List> loggList = getLogg();
    
            for(List<String> logg: loggList){
                writer.println(logg);
            }
                
            writer.flush();
            writer.close();  
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void konverterFraStrengtilListe() {
        
        for (String x : tidligereloggStreng) {
            List<String> d = Arrays.asList(x.replaceAll("\\[|\\]", "").split(", "));
            Logg.add(d);
        }
    }

   

    public void getLoggFromFile(String filename){
        antallLogg=0;
        Logg.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                tidligereloggStreng.add(line);
               

                
                
               
                
                
                
           


            }
            scanner.close();
            for (String x : tidligereloggStreng) {
                List<String> d = Arrays.asList(x.replaceAll("\\[|\\]", "").split(", "));
                Logg.add(d);
            }
            tidligereloggStreng.clear();
            setantallLogg();
            setInnsatspoeng();
            
            
            
            
            
            
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }

    }

    public void getLoggFromFileMain(String filename){
         antallLogg=getantallLogg();
        antallLogg=0;
        getLogg().clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                tidligereloggStreng.add(line);
               

                
                
               
                
                
                
           


            }
            scanner.close();
            for (String x : tidligereloggStreng) {
                List<String> d = Arrays.asList(x.replaceAll("\\[|\\]", "").split(", "));
                getLogg().add(d);
            }
          tidligereloggStreng.clear();
            setantallLogg();
            setInnsatspoeng();
            
            
            
            
            
            
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        

    }







    

    



    

    
            
        
        
       
        
       
       
    }
    








      





    























    

