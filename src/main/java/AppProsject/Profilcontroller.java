package AppProsject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Profilcontroller {

    private Profil profil;

    

   

  

    

   

    @FXML
    private Label brukernavnX, mål1,Tiilbakemelding, Tilbakemelding2,Tilbakemelding3,T4;

    @FXML
    private TextField Mål;

    

    public void HentMål(){
        profil.GetMålFromFileTestFH(profil.getMål1Fil());
        int i=profil.getMålListe().size();
        
            if(i==1){
                mål1.setText(profil.getMålListe().get(0).getMålNavn());
                profil.settLoggFil();
                
            }
            else{
                mål1.setText("");
            }
       
    }
    


    @FXML
    private void OpprettMål(){

        if(profil.getMålListe().size()==0){
        String sattMål=Mål.getText();
        mål1.setText(sattMål);
        profil.opprettMål(sattMål);
        profil.skrivMålTilFil(profil.getMål1Fil());
        Tiilbakemelding.setText("Mål: 1/1");
        T4.setText("");

        }
        else{
            Tiilbakemelding.setText("Du har allerede satt deg et Mål.");
            Tilbakemelding2.setText("Prøv nå dete målet før du setter deg et nytt et.");
            Tilbakemelding3.setText("Forskning viser at man blir best ved å fokusere på en ting om gangen ");

        }
        



        
         

        }
         

    

    public void fjernMål(){
        if(profil.getMålListe().size()==0){
            mål1.setText("");
            Tiilbakemelding.setText("Mål: 0/1, Du har allerede fjernet målet ditt");
        }
        if(profil.getMålListe().size()==1){
            mål1.setText("");
            Tiilbakemelding.setText("Mål: 0/1");
            profil.getMålListe().remove(0);
            Tilbakemelding2.setText("Sett deg et nytt Mål");
            Tilbakemelding3.setText("Vi har troen på deg! ");

        }


       
       
    }

    public void gåTilMål1(){
        if(profil.getMålListe().size()==0){
            T4.setText("Du må sette deg et mål, før du kan gjennomføre logg");


        }
        else{

       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Mål1.fxml"));
        AnchorPane root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Mål1Controller mål1Controller = loader.getController();

        mål1Controller.getmålNavn().setText(mål1.getText());
        mål1Controller.setProfil(profil);
       
    
       
       
    
       
       
    
        // Create a new scene
        Scene scene = new Scene(root);
        // Get the primary stage
        Stage stage = (Stage) brukernavnX.getScene().getWindow();
        // Set the new scene
        stage.setScene(scene);
        // Show the new scene
        stage.show();
            }
        }

            


    


    





    public Label getmål1(){
        return mål1;
    }
   

    


   

    




    public Profil getProfil(){
        return profil;
        

    }

    public void setProfil(Profil x){
        this.profil=x;
        

    }

    public Label getbrukernavnX(){
        return brukernavnX;

    }

    


}
