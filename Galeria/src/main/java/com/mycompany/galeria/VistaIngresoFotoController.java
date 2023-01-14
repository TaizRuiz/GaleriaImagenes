/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.galeria;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modeloClases.Album;
import modeloClases.Foto;
import modeloClases.Persona;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class VistaIngresoFotoController implements Initializable {

   
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txtLugar;
    @FXML
    private TextField txtPersonas;
    @FXML
    private TextField txtRuta;
    @FXML
    private Button btnArchivo;
    @FXML
    private Button btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void eventAction(ActionEvent evento){
        Object o=evento.getSource();
        if (o.equals(btnGuardar)){
            guardarFoto(evento);
          
            
        }
        else if (o.equals(btnArchivo)){
            cargarArchivo(evento);
        }
        
    }

    @FXML
    private void guardarFoto(ActionEvent event) {
        if (this.txtRuta.getText().isEmpty()){
            Alert alerta=new Alert(AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("la ruta no puede ser vacia");
            alerta.showAndWait();
        } else{
            ArrayList<Persona> personas=new ArrayList<>();
            String titulo=this.txtTitulo.getText();
            String fecha=this.txtFecha.getText();
            String lugar=this.txtLugar.getText();
            String ruta=this.txtRuta.getText();
            String persona=this.txtPersonas.getText();
            if (persona!=null){
                String[] personasL=persona.split(",");
                for(String p:personasL){
                    personas.add(new Persona(p));
                }
            }
            Foto nuevaFoto=new Foto(titulo, fecha, lugar, App.albumSelec.getNombre(), ruta, personas);
            try{
                FXMLLoader loader=new FXMLLoader(getClass().getResource("VistaContenidoAlbum.fxml"));
                  Parent root=loader.load(); 
                     VistaContenidoAlbumController controlador=loader.getController();
                     Album album=App.albumSelec;
                     controlador.cargarNuevaImagen(nuevaFoto);
                     Scene scene=(Scene) btnGuardar.getScene();
                     Stage s=(Stage) scene.getWindow();
                     s.close();
                     
            }catch(Exception e){
                System.out.println(e);
            }
            
            
        }
       
    }

    @FXML
    private void cargarArchivo(ActionEvent event) {
         String rutaArchivo = null;
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);

            if (file != null) {

                try {
                    rutaArchivo = file.getPath();
                    this.txtRuta.setText("file:"+rutaArchivo); 

                } catch (Exception e) {
                    System.out.println(e);
                }

    }
    
}
    }
