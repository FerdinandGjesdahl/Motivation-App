package AppProsject;



public class Forbedring implements Logg {

    private String loggForbedring;


    public Forbedring(String forbedring){

        this.loggForbedring=forbedring;


    }

    @Override
    public String toString() {
        return "Forbedring: "+ loggForbedring; 
    }

    @Override
    public Logg getLog() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLog'");
    }










    
}
