package AppProsject;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.FileWriter;

public class Logg1Controller {

    private Profil profil;

    public List<List> a=new ArrayList<>();
   
    
   
    



    public void setProfil(Profil profil) {
        this.profil=profil;
    }

    @FXML
    private Label  målNavnEndelig;

    @FXML
    private TextField innsats;

  

    @FXML
    private TextArea gjordebra,forbedre;

    @FXML
    private Label tilbakemelding;

    
    

    
    
   
    
   










    public Label getmålNavnEndelig(){
        return målNavnEndelig;
    }



    public TextField getInnsats(){
        return innsats;
    }

    public TextArea getGjordeBra(){
        return gjordebra;
    }

    public TextArea Forbedre(){
        return forbedre;
    }

    public Profil getProfil(){
        return profil;
    }

    public void sendLoggA(){
        try {
            Integer x = Integer.valueOf(innsats.getText());
            if (x > 0 && x <= 10) {
                profil.getMål(0).SkrivLogg(gjordebra.getText(), Integer.valueOf(innsats.getText()), forbedre.getText());
                profil.getMål(0).skrivLoggTilFil(profil.getLoggFil());
                forbedre.setText("");
                gjordebra.setText("");
                innsats.setText("");
                tilbakemelding.setText("Gratulerer med å ha gjennomført logg, dette har blitt lagret.");
            } else {
                tilbakemelding.setText("Du må gi deg selv innsatspoeng mellom 1 og 10");
            }
        } catch (NumberFormatException e) {
            tilbakemelding.setText("Feil format på innsatspoeng. Vennligst skriv inn et heltall 1-10");
        }
    }
        

        



       
        







    

   


    public void tilbakeTilMål1(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Mål1.fxml"));
        AnchorPane root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Mål1Controller mål1Controller = loader.getController();

        mål1Controller.getmålNavn().setText(målNavnEndelig.getText());
        mål1Controller.setProfil(profil);
        

       
    
       
       
    
       
       
    
        // Create a new scene
        Scene scene = new Scene(root);
        // Get the primary stage
        Stage stage = (Stage) målNavnEndelig.getScene().getWindow();
        // Set the new scene
        stage.setScene(scene);
        // Show the new scene
        stage.show();




    }

    
    
}
