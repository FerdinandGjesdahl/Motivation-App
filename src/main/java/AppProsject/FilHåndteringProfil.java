package AppProsject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FilHåndteringProfil {

    private Profil profil;

   

    public FilHåndteringProfil(Profil p){
        this.profil=p;
    }

   


    public void skrivMålTilFilFP(String filename){
        try {
            PrintWriter writer=new PrintWriter(filename);
            List<Mål> MålListe=profil.getMålListe();
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

    public void getMålFromFileFP(String filename){
        profil.getMålListe().clear();
        

    
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                Mål x=new Mål(line);
                profil.getMålListe().add(x);
                
                
                
           


            }
        scanner.close();}

            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            
        
    }

    }

    @Override
    public String toString() {
        return "FilHåndterer til "+profil.getBrukerNavn();
    }


    


















    public static void main(String[] args) {
        System.out.println("f");
        Brukere testFilHåndterer=new Brukere();
        Profil Kasia=new Profil("Kasia", "123");
        testFilHåndterer.getListemedProfiler().add(Kasia);
        testFilHåndterer.SkrivBrukereTilFil("BrukereTest1");
        Brukere testFilHåndterer2=new Brukere();
        testFilHåndterer2.BrukereFromFile("BrukereTest1");
        System.out.println(testFilHåndterer2.getListemedProfiler());
        System.out.println(testFilHåndterer2.getListemedProfiler().get(0).getProfilFilHåndter());
        testFilHåndterer2.getListemedProfiler().get(0).opprettMål("Trene mer Poledance");
        testFilHåndterer2.getListemedProfiler().get(0).SkrivMålTilFilTestFH("FilHTest1");
        Profil Frida=new Profil("Frida", "123");
        Frida.setFilHåndterer(new FilHåndteringProfil(Frida));
        System.out.println(Frida.getProfilFilHåndter());
        Frida.GetMålFromFileTestFH("FilHTest1");
        System.out.println(Frida.getMål(0));
        

        
       
       
        
        
    }
}