/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.galeria;
import modeloClases.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class InicioSesionVistaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    Button btnLogIn;
    @FXML
    PasswordField txtPassword;
    @FXML
    TextField txtUsername;
    @FXML
    private Label labelInicio;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void eventAction(ActionEvent evento) throws Exception{
        Object o=evento.getSource();
        if (o.equals(btnLogIn)){
            IniciarSesion(evento);
        }
        
        }
 
    @FXML
    private void IniciarSesion(ActionEvent event) throws Exception {
        
        String user =txtUsername.getText();
        String pass=txtPassword.getText();
        Galeria galSelec=App.IniciarSesion(user, pass);
        
        Galeria gal=null;
      
        if (txtUsername.getText().equals("") || txtPassword.getText().equals("") ){
            Alert alerta=new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Debe llenar las casillas");
            alerta.showAndWait();
        }
        else if (!(App.getGaleriasApp()).contains(galSelec)){
            Alert alerta=new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Hubo un error con sus credenciales");
            alerta.showAndWait();
            
            
        }else{
            if (App.galeriasApp.contains(galSelec)){
                int indice=App.galeriasApp.indexOf(galSelec);
                gal=App.galeriasApp.get(indice);
            }
            App.galeriaSeleccionada=gal;
            Node source = (Node) event.getSource();     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
        stage.close();
        Stage s = new Stage();
        
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("VentaPrincipalGaleria.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root,950, 600);
        s.setScene(scene);
        s.setOnCloseRequest(a->App.guardarSerializado());
        s.setTitle("Galeria");
        s.show();
            /*App.setRoot("VentaPrincipalGaleria");*/
            
        }
    
        }
   

    }
    
