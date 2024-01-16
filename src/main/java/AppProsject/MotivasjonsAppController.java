package AppProsject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MotivasjonsAppController{
    @FXML
    private TextField firstNumber, secondNumber;

    @FXML
    private Label result;

    private Brukere brukere;

    private BrukereFilHåndterer brukereFilHåndterer;


    public MotivasjonsAppController(){
        brukere=new Brukere();
        brukereFilHåndterer=new BrukereFilHåndterer(brukere);
        brukere.setBrukereFilHåndterer(brukereFilHåndterer);


        brukere.BrukereFromFile("Brukere");
        
        
    }

    @FXML
    public void opprettBruker(){
        String brukerNavn=firstNumber.getText();
        String passord=secondNumber.getText();
        if((brukerNavn=="" || passord=="")){
            result.setText("Hverken brukernavn eller passord kan være en tom tekst.");
        }
        else{
        Profil Profilny=new Profil(brukerNavn, passord);
        if(brukere.checkIfBrukerNavnOgPassordAlleredeFinnes(Profilny)){
            brukere.getListemedProfiler().add(Profilny);
        result.setText("Du har opprettet en ny bruker, lykke til med dine mål!");
        brukere.SkrivBrukereTilFil("Brukere");

        }
        else{
            result.setText("Brukernavnet eller passord er allerede tatt");
        }
        


        }
       
        


    }



    


   
    
    @FXML
    private void handleButtonClick() {
        String brukerNavn=firstNumber.getText();
        String passord=secondNumber.getText();
        if( brukere.checkBrukerNavnOgPassord(brukerNavn, passord)==true){
            result.setText("Du har klart å logge deg inn");
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profil.fxml"));
AnchorPane root;
try {
    root = loader.load();
} catch (IOException e) {
    e.printStackTrace();
    return;
}
Profilcontroller profilController = loader.getController();
for(Profil x:brukere.getListemedProfiler()){
    if(x.getBrukerNavn().equals(brukerNavn) && x.getPassord().equals(passord)){
        
           

        
        profilController.setProfil(x);
        x.setFilHåndterer(new FilHåndteringProfil(x));
        profilController.getbrukernavnX().setText(x.getBrukerNavn());
        
       
        
    }
}
profilController.HentMål();


    





// Create a new scene
Scene scene = new Scene(root);
// Get the primary stage
Stage stage = (Stage) firstNumber.getScene().getWindow();
// Set the new scene
stage.setScene(scene);
// Show the new scene
stage.show();
        }
           
            
        else{
            result.setText("Du har ikke klart å logge deg inn");}

    

}












}

