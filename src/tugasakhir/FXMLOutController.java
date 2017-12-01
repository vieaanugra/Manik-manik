/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Vieanugraa
 */
public class FXMLOutController implements Initializable {

    @FXML
    private Label atsnama;
    @FXML
    private Label dgnkasir;
    @FXML
    private Label almt;
    @FXML
    private Label jmlhuang;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField alamat;
    @FXML
    private JFXTextField kasir;
    @FXML
    private JFXTextField uang;
    @FXML
    private Button ya;
    @FXML
    private TextArea hasil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    String atsnm,tamala,kasr;
    int jmluang, kembalian=0, uanguang,total;
    
    @FXML
    private void ok(ActionEvent event) {
         atsnm = nama.getText();
        tamala = alamat.getText();
        kasr = kasir.getText();
        jmluang = Integer.parseInt(uang.getText());
        kembalian = jmluang - total;
        hasil.setText("Nama Pemesanan: " + atsnm+ 
                "\nAlamat : "  + tamala+ 
                "\nKasir : " + kasr+ 
                "\nJumlah Uang : Rp. " + jmluang+
                "\nTotal Harga : Rp. "+total+
                "\nKembalian : Rp. " +kembalian);
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return total;
    }
}
