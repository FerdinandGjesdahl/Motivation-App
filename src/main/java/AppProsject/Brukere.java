package AppProsject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Brukere implements Serializable {
    
    private List<Profil> ListemedProfiler=new ArrayList<>();
    private BrukereFilHåndterer brukereFilHåndterer;

   
    


    public List<Profil> getListemedProfiler(){
        return ListemedProfiler;
    }

    public void setBrukereFilHåndterer(BrukereFilHåndterer x){
        this.brukereFilHåndterer=x;

    }

   

   

   

    public boolean checkBrukerNavnOgPassord(String brukernavn, String passord){
        for(Profil x:ListemedProfiler){
            if(x.getBrukerNavn().equals(brukernavn) && x.getPassord().equals(passord)){
                return true;
            }
        }
        return false;
    
    }

    public boolean checkIfBrukerNavnOgPassordAlleredeFinnes(Profil x){
        String brukernavn=x.getBrukerNavn();
        String passord=x.getPassord();
        for(Profil d:ListemedProfiler){
            if(d.getBrukerNavn().equals(brukernavn) ||  d.getPassord().equals(passord)){
                return false;
            }
        }
        return true;


    }

    public void BrukereFromFile(String filename) {
        brukereFilHåndterer.BrukereFromFileFilHåndterer(filename);
    }

    public void SkrivBrukereTilFil(String filename){
        brukereFilHåndterer.SkrivBrukereTilFilFilHåndterer(filename);
    }

    public void LeggTilBrukere(Profil profil){
        FilHåndteringProfil fhp=new FilHåndteringProfil(profil);
        profil.setFilHåndterer(fhp);
        ListemedProfiler.add(profil);

    }

    








   

    
   

   



    public static void main(String[] args) {
       

    }

    
    
}
