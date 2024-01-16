package AppProsject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SeLogg1Controller {
  

    public List<String> a=new ArrayList<>();
   

   

    private double antallpoengInnsats;

    public void setInnsatspoeng(double antallpoengInnsats){
        this.antallpoengInnsats=antallpoengInnsats;
    }


    @FXML
    private Label  målNavnEndelig,snittInnsats;

    @FXML
    private TextArea logg1;


    public Label getmålNavnEndelig(){
        return målNavnEndelig;
    }

    private Profil profil;

    public Profil getProfilseLogg1(){
        return profil;
    }



    public void setProfil(Profil profil) {
        this.profil=profil;
    }

    public TextArea getLoggNummer1(){
        return logg1;
    }

   

   
       

        
           
        

        public List<String> getStringListe(){
            return a;

        }



        public void backtoMål1(){
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

       
        

        public void Seinnsats(){
            
            snittInnsats.setText(String.valueOf(profil.getMål(0).getInnsatsopoeng()/profil.getMål(0).getantallLogg()));
            
            
        }

        public void sorterEtterInnsatsPoeng(){
            
        }
        
    }
    
    


    

