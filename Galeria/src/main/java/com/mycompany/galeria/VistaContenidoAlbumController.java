/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.galeria;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modeloClases.Album;
import modeloClases.Foto;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */

public class VistaContenidoAlbumController implements Initializable {
@FXML 
Button BtnNuevaFoto;
@FXML
Button btnEliminar;
@FXML 
FlowPane contenedorFotos;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }  
    public void eventAction(ActionEvent evento){
        Object o=evento.getSource();
        if (o.equals(BtnNuevaFoto)){
            agregarImagen(evento);
        }
        
    
    }
    @FXML
    public void agregarImagen(ActionEvent evento){
            try{
                 FXMLLoader loader=new FXMLLoader(getClass().getResource("VistaIngresoFoto.fxml"));
                  Parent root=loader.load(); 
                     VistaIngresoFotoController controlador=loader.getController();
                       this.contenedorFotos.getChildren().clear();
                       Scene s=new Scene(root);
                       Stage stage=new Stage();
                       stage.initModality(Modality.APPLICATION_MODAL);
                       stage.setScene(s);
                       stage.showAndWait();
                       this.llenarContenedor(App.albumSelec);
                
            }catch(Exception e){
                
            }
            }
         
                                  
        /*metodo que reciba una foto y la agregue al panel*/  
    public void cargarNuevaImagen(Foto f){
       Album album=App.albumSelec;
       album.getFotoContenidas().add(f);
       
       
    
        
    }
    public void vaciar(){
        this.contenedorFotos.getChildren().clear();
    }

    public FlowPane getContenedorFotos() {
        return contenedorFotos;
    }

    public void setContenedorFotos(FlowPane contenedorFotos) {
        this.contenedorFotos = contenedorFotos;
    }
    public void llenarContenedor(Album a){
         ArrayList<Foto> fotos=a.getFotoContenidas();
         this.contenedorFotos.setHgap(20);
         this.contenedorFotos.setVgap(10);
         this.contenedorFotos.setPadding(new Insets(10, 10, 10, 10));
            for (Foto f: fotos){
                String rutaFoto=f.getRuta();
                System.out.println(rutaFoto);
                ImageView image=new ImageView();
                Image img=new Image(rutaFoto, 200, 200, false, false);
            
                image.setImage(img);
                this.contenedorFotos.getChildren().add(image);
                          
        }
    }
    
}
