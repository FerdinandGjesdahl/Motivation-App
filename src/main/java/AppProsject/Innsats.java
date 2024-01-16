package AppProsject;

import java.security.GuardedObject;

public class Innsats implements Logg{

    private Integer Innsatstall;
    private String innsatslogg;


    public Innsats(Integer Innsatstall){

        this.Innsatstall=Innsatstall;


    }

    public Integer getInnsatstall(){
        return Innsatstall;
    }

    @Override
    public String toString() {
        return "Innnsats: "+Innsatstall.toString();
    }

    @Override
    public Logg getLog() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLog'");
    }

   





}
