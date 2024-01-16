package AppProsject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;




public class Profil{
    private String mål1Fil;
    private String logg1Fil="loggFil";

    private List<String> logg1Filer;
   

    private FilHåndteringProfil filHåndteringProfil;
    


 


   
    

    

    private String brukernavn;

    private String passord;

    private List<Mål> MålListe= new ArrayList<>();


    public Profil(String brukernavn, String passord){
        this.brukernavn=brukernavn;
        this.passord=passord;
        this.mål1Fil=brukernavn+"Målsatt";
        

        

  
       

        





    }

    public void settLoggFil(){
        this.logg1Fil=getMål(0).getMålNavn()+"loggFil";
    }
    
   

    

    public FilHåndteringProfil getProfilFilHåndter(){
       return filHåndteringProfil;

    }



    public String getMål1Fil(){
        return mål1Fil;
    }

    public String getLoggFil(){
      
        return logg1Fil;
    }

    public Mål getMål(int i){
        return MålListe.get(i);

    }

    


    public void opprettMål(String SettMål){
        Mål mittNyeMål=new Mål(SettMål);
        logg1Fil="";
        logg1Fil=mittNyeMål.getMålNavn()+"loggFil";
        
        if(checkMål(MålListe)==true){
            throw new IllegalArgumentException("Du kan kun opprette tre mål om gangen");
        }
        else{
            MålListe.add(mittNyeMål);
        }
        


    }

    private boolean checkMål(List MålListe){
        
        if(MålListe.size()>=3){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public String toString() {
        return brukernavn;
    }

    public String getBrukerNavn(){
        return this.brukernavn;
    }


    public String getPassord(){
        return this.passord;
    }

    public List<Mål> getMålListe(){
        return MålListe;
    }

    
    public void skrivMålTilFil(String filename){
        try {
            PrintWriter writer=new PrintWriter(filename);
            List<Mål> MålListe=getMålListe();
            for(Mål Mål: MålListe){
                writer.println(Mål.getMålNavn());

            }
            writer.flush();
            writer.close();
           
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
public void getMålFromFile(String filename){
        MålListe.clear();
        

    
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                Mål x=new Mål(line);
                getMålListe().add(x);
                
                
                
           


            }
        scanner.close();}

            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            
        
    }

    }
    public void SkrivMålTilFilTestFH(String filename){
        filHåndteringProfil.skrivMålTilFilFP(filename);

    }
    

    public void GetMålFromFileTestFH(String filename) {
        filHåndteringProfil.getMålFromFileFP(filename);
    }

    public void setFilHåndterer(FilHåndteringProfil filHåndteringProfil){
        this.filHåndteringProfil=filHåndteringProfil;

    }





   


    
        


  

   


    
        
       
      
       
        

        
        
    
}



    

   







