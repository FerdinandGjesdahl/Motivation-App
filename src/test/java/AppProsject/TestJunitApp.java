package AppProsject;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import AppProsject.Brukere;
import AppProsject.BrukereFilHåndterer;
import AppProsject.FilHåndteringProfil;
import AppProsject.Mål;
import AppProsject.Profil;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestJunitApp {
    @Test
    public void sjekkAtBrukereFungerer(){
        Brukere brukerTest=new Brukere();
        Profil Kasia=new Profil("Kasia", "123");
        brukerTest.getListemedProfiler().add(Kasia);
        assertEquals(brukerTest.getListemedProfiler().get(0), Kasia);


    }

    @Test
    public void SjekkBrukereFilFungerer(){
        Brukere brukerTest=new Brukere();
        Profil Kasia=new Profil("Kasia", "123");
        BrukereFilHåndterer brukereFilHåndtererTest=new BrukereFilHåndterer(brukerTest);
        brukerTest.setBrukereFilHåndterer(brukereFilHåndtererTest);
        brukerTest.getListemedProfiler().add(Kasia);
        brukerTest.SkrivBrukereTilFil("TestBrukere10");

        Brukere brukerTest2=new Brukere();
        BrukereFilHåndterer brukereFilHåndtererTest2=new BrukereFilHåndterer(brukerTest2);
        brukerTest2.setBrukereFilHåndterer(brukereFilHåndtererTest2);
        brukerTest2.BrukereFromFile("TestBrukere10");
        assertEquals(brukerTest2.getListemedProfiler().get(0).getBrukerNavn(), Kasia.getBrukerNavn());


    }
    @Test
    public void sjekkAtProfilOpprettMålFungerer(){
        Profil kasia=new Profil("Kasia", "123");
        kasia.opprettMål("Trene mer");
        assertEquals(kasia.getMål(0).toString(),new Mål("Trene mer").toString());

        


    }

    @Test
    public void sjekkProfilFilHåndterer(){
        Profil kasia=new Profil("Kasia", "123");
        kasia.opprettMål("Trene Mer");
        FilHåndteringProfil filHåndteringProfilTest=new FilHåndteringProfil(kasia);
        kasia.setFilHåndterer(filHåndteringProfilTest);
        kasia.skrivMålTilFil(kasia.getMål1Fil());
        Profil Reyuga=new Profil("Reyuga", "789");
        FilHåndteringProfil filHåndteringProfilTest2=new FilHåndteringProfil(Reyuga);
        Reyuga.setFilHåndterer(filHåndteringProfilTest2);
        Reyuga.GetMålFromFileTestFH(kasia.getMål1Fil());
        assertEquals(Reyuga.getMål(0).toString(),kasia.getMål(0).toString());




    }

    @Test
    public void sjekkOmSkrivLoggFungerer(){
        Profil kasia=new Profil("Kasia", "123");
        kasia.opprettMål("Trene mer");
        kasia.getMål(0).SkrivLogg("Kom meg på styrketrening, presset hardt", 10, "Få i noe næring etter trening");
        kasia.getMål(0).getLogg();
        assertEquals(kasia.getMål(0).getLogg().toString(),"[[GjordeBra: Kom meg på styrketrening, presset hardt, Innnsats: 10, Forbedring: Få i noe næring etter trening]]");

    }

    @Test
    public void sjekkOmHLoggFilFungerer(){
        Profil kasia=new Profil("Kasia", "123");
        kasia.opprettMål("Trene mer");
     
     
        kasia.getMål(0).SkrivLogg("Kom meg på styrketrening, presset hardt", 10, "Få i noe næring etter trening");
        kasia.getMål(0).skrivLoggTilFil("LoggFilTest");
        Profil Frida=new Profil("Frida", "456");
        Frida.opprettMål("Trene mer");

     

        Frida.getMål(0).getLoggFromFileMain("LoggFilTest");
        assertEquals(Frida.getMål(0).getLogg().toString(),kasia.getMål(0).getLogg().toString());

    }




  
    






    
}
