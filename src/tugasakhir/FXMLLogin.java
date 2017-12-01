/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Vieanugraa
 */
public class FXMLLogin implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label user;
    @FXML
    private Label pass;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws SQLException {
         try {
             sql = "SELECT * FROM admin WHERE username='"+username.getText()+"' AND password='"+password.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.getText().equals(rs.getString("username")) && password.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "berhasil login");
                    // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLHome.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("TugasAkhir");
            stage.show();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
            
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }
    
}
