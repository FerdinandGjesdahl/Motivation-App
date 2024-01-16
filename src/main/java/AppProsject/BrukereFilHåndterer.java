package AppProsject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class BrukereFilHåndterer {


    public BrukereFilHåndterer(Brukere brukere){
        this.brukereFilHåndterer=brukere;

    }

    private Brukere brukereFilHåndterer;








    public void BrukereFromFileFilHåndterer(String filename) {
        List<String> Strengliste = new ArrayList<>();
    
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Strengliste.add(line);
            }
            scanner.close();
    
            int antallProfiler = Strengliste.size() / 2; // antall profiler = antall linjer / 2
            for (int i = 0; i < antallProfiler; i++) {
                String brukernavn = Strengliste.get(i * 2);
                String passord = "";
                if (Strengliste.size() > i * 2 + 1) {
                    passord = Strengliste.get(i * 2 + 1);
                }
                Profil p=new Profil(brukernavn, passord);
                p.setFilHåndterer(new FilHåndteringProfil(p));
                brukereFilHåndterer.getListemedProfiler().add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void SkrivBrukereTilFilFilHåndterer(String filename){
        try {
            PrintWriter writer=new PrintWriter(filename);
            for(Profil profil: brukereFilHåndterer.getListemedProfiler()){
                writer.println(profil.getBrukerNavn());
                writer.println(profil.getPassord());
            }
            

            
            writer.flush();
            writer.close();
           
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void LeggTilBrukere(Profil profil){
        FilHåndteringProfil fhp=new FilHåndteringProfil(profil);
        profil.setFilHåndterer(fhp);
        brukereFilHåndterer.getListemedProfiler().add(profil);

    }
    
}
