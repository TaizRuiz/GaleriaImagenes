/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.galeria;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modeloClases.Album;
import modeloClases.Foto;
import modeloClases.Galeria;
import modeloClases.Persona;
/**
 * FXML Controller class
 *
 * @author USUARIO
 */


public class VentaPrincipalGaleriaController implements Initializable {
   
    @FXML
    private TextField buscador;
    @FXML
    private Button btnBuscar;
    @FXML
    private HBox contenedorBuscador;
    @FXML
    private BorderPane contenedorPrincipal;
    @FXML
    private AnchorPane contenedorAlbumes;
    @FXML
    private ComboBox<String> coomboOpcionesBusqueda;
    @FXML
    private Button btnNuevoAlbum;
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.contenedorAlbumes.getChildren().add(this.CargarInformacion());
        this.coomboOpcionesBusqueda.getItems().addAll("fecha","lugar","persona","titulo");
        
        
    }
     public void eventAction(ActionEvent evento) throws Exception{
        Object o=evento.getSource();
        if (o.equals(btnBuscar)){
            buscarFoto(evento);
        } else if (o.equals(btnNuevoAlbum)){
            
        }
        
        }
    
    @FXML
    private void buscarFoto(ActionEvent event) {
        FlowPane contenedorBusqueda=new FlowPane(20, 20);
        contenedorBusqueda.setPadding(new Insets(50, 50, 50, 50));
        String tipoBusqueda=this.obtnerTipoBusqueda(event);
        String busqueda=this.buscador.getText();
       if(!(busqueda.isEmpty() || busqueda.isBlank())){
           if (!(tipoBusqueda==null)){
               this.contenedorAlbumes.getChildren().clear();
               if (tipoBusqueda.equals("fecha")){
                   for (Album a: App.galeriaSeleccionada.getAlbumnesGaleria()){
                       for (Foto f: a.getFotoContenidas()){
                           if (f.getFecha().equals(busqueda)){
                               ImageView iv=new ImageView(new Image(f.getRuta(),150,150,false,false));
                               
                               contenedorBusqueda.getChildren().add(iv);
                           }
                       }
                   }
           }
               if (tipoBusqueda.equals("lugar")){
                   for (Album a: App.galeriaSeleccionada.getAlbumnesGaleria()){
                       for (Foto f: a.getFotoContenidas()){
                           if (f.getLugar().equals(busqueda)){
                               ImageView iv=new ImageView(new Image(f.getRuta(),150,150,false,false));
                               
                               contenedorBusqueda.getChildren().add(iv);
                           }
                       }
                   }
           }
               if (tipoBusqueda.equals("titulo")){
                   for (Album a: App.galeriaSeleccionada.getAlbumnesGaleria()){
                       for (Foto f: a.getFotoContenidas()){
                           if (f.getTitulo().equals(busqueda)){
                               ImageView iv=new ImageView(new Image(f.getRuta(),150,150,false,false));
                               
                               contenedorBusqueda.getChildren().add(iv);
                           }
                       }
                   }
           }
               if (tipoBusqueda.equals("persona")){
                   Persona p=new Persona(busqueda);
                   for (Album a: App.galeriaSeleccionada.getAlbumnesGaleria()){
                       for (Foto f: a.getFotoContenidas()){
                           if (f.getPersonasReconocidas().contains(p)){
                               ImageView iv=new ImageView(new Image(f.getRuta(),150,150,false,false));
                               
                               contenedorBusqueda.getChildren().add(iv);
                           }
                       }
                   }
           }
               this.contenedorPrincipal.setCenter(contenedorBusqueda);
           }else{
            Alert alerta=new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("debe seleccionar un tipo de busqueda");
            alerta.showAndWait();
           }
            
        }else {
            Alert alerta=new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("debe ingresar el valor de busqueda");
            alerta.showAndWait();
        }
    }
    
       
    public HBox CargarInformacion(){
        //aqui debe crearse los aImlbumes 
        ArrayList<Album> albumes=App.galeriaSeleccionada.getAlbumnesGaleria();
        HBox h=new HBox();
        h.setSpacing(50);
        h.setPadding(new Insets(40,40,40,40));
        for (Album a: albumes){
            /*datos del album*/
               String dirF=a.getFotoContenidas().get(0).getRuta();
               String nombre =a.getNombre();
               String descripcion=a.getDescripcion();
               /*label con la informacion principal del album*/
               Label informacion=new Label(nombre);
               
               /*contenedores de la portada y los botones*/
               VBox contenedorPortada=new VBox(5);
               HBox contenedorBotones=new HBox(5);
               /*botones */
               Button play=new Button("Play");
               Button contenido=new Button("Mostrar Contenido");
               contenedorBotones.getChildren().addAll(play, contenido);
               /*carga de la portada*/
               ImageView imageview=new ImageView();
               Image imagen=new Image(dirF, 150, 150, false, false);
               imageview.setImage(imagen);
               /*acciones de los botones*/
               /*boton de mostrar*/
               contenido.setOnAction(new EventHandler<ActionEvent>() {
                   @Override
                   public void handle(ActionEvent e){
                       try{
                       FXMLLoader loader=new FXMLLoader(getClass().getResource("VistaContenidoAlbum.fxml"));
                       Parent root=loader.load(); 
                       VistaContenidoAlbumController controlador=loader.getController();
                       controlador.llenarContenedor(a);
                       App.albumSelec=a;
                       
                       Scene s=new Scene(root);
                       Stage stage=new Stage();
                       stage.initModality(Modality.APPLICATION_MODAL);
                       stage.setScene(s);
                       stage.showAndWait();
             
                       
                       }catch(Exception ex){
                           System.out.println(ex);
                       }
                       
                       
                   }
               });
               /*se carga la portada y los botones al contenedor */
               contenedorPortada.setAlignment(Pos.CENTER);
               contenedorPortada.getChildren().addAll(imageview,informacion,contenedorBotones);
               /*se agregar ese nodo al contenedor principal que es el hbox*/
               h.getChildren().add(contenedorPortada);
               
            }
        return h;
           }

    @FXML
    private String obtnerTipoBusqueda(ActionEvent event) {
        String tipo= this.coomboOpcionesBusqueda.getSelectionModel().getSelectedItem();
        return tipo;
    }
             

        
        
   
    
    
}
