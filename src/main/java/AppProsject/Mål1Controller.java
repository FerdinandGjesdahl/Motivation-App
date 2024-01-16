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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Mål1Controller {

    private Profil profil;

    List<List> b=new ArrayList<>();
    private double antallpoengInnsats;

    public void setInnsatspoeng(double antallpoengInnsats){
        this.antallpoengInnsats=antallpoengInnsats;
    }
    

   



    public void setProfil(Profil profil) {
        this.profil=profil;
    }
    
   
    @FXML
    private Label målNavn;


    public void gjennomFørLogg(){
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Logg1.fxml"));
        AnchorPane root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Logg1Controller  Logg1Controller = loader.getController();
        Logg1Controller.getmålNavnEndelig().setText(målNavn.getText());
        Logg1Controller.setProfil(profil);
        
        
        

        

       

        
    
       
       
    
       
       
    
        // Create a new scene
        Scene scene = new Scene(root);
        // Get the primary stage
        Stage stage = (Stage) målNavn.getScene().getWindow();
        // Set the new scene
        stage.setScene(scene);
        // Show the new scene
        stage.show();

    }
   

    public void seLogg1(){
        int antallDag=0;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeLogg1.fxml"));
        AnchorPane root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        SeLogg1Controller SeLogg1Controller  = loader.getController();
        SeLogg1Controller.setProfil(profil);
        SeLogg1Controller.setInnsatspoeng(antallpoengInnsats);
        SeLogg1Controller.getmålNavnEndelig().setText(målNavn.getText());
        Mål mål1= SeLogg1Controller.getProfilseLogg1().getMål(0);
        mål1.getLoggFromFileMain(profil.getLoggFil());
        
        
        List<String> a=new ArrayList<>();
        for(int f=0; f<mål1.getLogg().size(); f=f+1){
         a.add(mål1.getLogg().get(f).toString());
        }
        
        int antalllogger=0;
        for( int i =0; i<a.size(); i=i+1){
            antalllogger=antalllogger+1;
            SeLogg1Controller.getLoggNummer1().appendText("Dag "+antalllogger+":"+ a.get(i)+"\n");
            antallDag=antallDag+1;
            


        }
        
      
      
        
        

        

        

       

        
    
       
       
    
       
       
    
        // Create a new scene
        Scene scene = new Scene(root);
        // Get the primary stage
        Stage stage = (Stage) målNavn.getScene().getWindow();
        // Set the new scene
        stage.setScene(scene);
        // Show the new scene
        stage.show();

    }

    @FXML
    public void backToProfil(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Profil.fxml"));
        AnchorPane root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Profilcontroller profilcontroller = loader.getController();
        profilcontroller.getbrukernavnX().setText(profil.getBrukerNavn());
        profilcontroller.setProfil(profil);
        profilcontroller.HentMål();
        
        
        
       
       
    
       
       
    
       
       
    
        // Create a new scene
        Scene scene = new Scene(root);
        // Get the primary stage
        Stage stage = (Stage) målNavn.getScene().getWindow();
        // Set the new scene
        stage.setScene(scene);
        // Show the new scene
        stage.show();
        
        
    }

    
    
    
        
          

    











   
    






    public Label getmålNavn(){
        return målNavn;
    }
}
