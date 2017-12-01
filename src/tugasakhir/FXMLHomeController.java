/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXCheckBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vieanugraa
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private JFXCheckBox paket1;
    @FXML
    private JFXCheckBox paket2;
    @FXML
    private JFXCheckBox paket3;
    @FXML
    private TextField jumlah1;
    @FXML
    private TextField jumlah2;
    @FXML
    private TextField jumlah3;
    @FXML
    private Button belbel;
    @FXML
    private Button cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    FXMLOutController out = new FXMLOutController();
    int harga, jumlahpaket, hargatotal1, hargatotal2, hargatotal3, totalbayar;
    String menu="";
    String tmpiltotalbyr;

    @FXML
    private void beli(ActionEvent event) {
         try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLOut.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("TugasAkhir");
            stage.show();
            
            if(paket1.isSelected()){     
            harga = 50000;
            menu += paket1.getText()+", ";
            jumlahpaket=Integer.parseInt(jumlah1.getText());
            hargatotal1=harga*jumlahpaket;
            System.out.println(hargatotal1);
        }
        if(paket2.isSelected()){     
            harga = 75000;
            menu += paket2.getText()+", ";
            jumlahpaket=Integer.parseInt(jumlah2.getText());
            hargatotal2=harga*jumlahpaket;
            System.out.println(hargatotal2);
        }
        if(paket3.isSelected()){     
            harga = 100000;
            menu += paket3.getText()+", ";
            jumlahpaket=Integer.parseInt(jumlah3.getText());
            hargatotal3=harga*jumlahpaket;
            System.out.println(hargatotal3);
        }
        totalbayar = hargatotal1+hargatotal2+hargatotal3;
        System.out.println(totalbayar);
        out = fxmlLoader.getController();
        out.setTotal(totalbayar);
        
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
    }
    
}
