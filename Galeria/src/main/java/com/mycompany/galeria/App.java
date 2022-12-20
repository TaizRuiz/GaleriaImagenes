package com.mycompany.galeria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modeloClases.*;

/**
 * JavaFX App
 */
// Kevin Magallanes 101
public class App extends Application {

    public static ArrayList<Galeria> galeriasApp=new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        
    }

   

    public static void main(String[] args) {
        launch();
    }
    public static Galeria IniciarSesion(String nomUsuario,String contrasena){
      Usuario usuarioIngreso=new Usuario(nomUsuario, nomUsuario);
      Galeria galeriaIngreso=new Galeria(usuarioIngreso);
      Galeria galeriaEncontrada=null;
      if (galeriasApp.contains(galeriaIngreso)){
          int indice=galeriasApp.indexOf(galeriaIngreso);
          galeriaEncontrada=galeriasApp.get(indice);
          return galeriaEncontrada;
          }
      return galeriaEncontrada;
    }
    public static void guardarSerializado(){
        try {
            System.out.println("Datos Guardados");
      ObjectOutputStream serializado = new ObjectOutputStream(
          new FileOutputStream("Galerias.ser"));
      serializado.writeObject(galeriasApp);
      serializado.close();

    } catch (Exception e) {
      System.out.println(e);
    }

    }
    public static ArrayList<Galeria> cargarSerializado(){
         ArrayList<Galeria> s=null;
         try {
      System.out.println("Cargando informacion del sistema");
      ObjectInputStream deserializado = new ObjectInputStream(
          new FileInputStream("Galerias.ser"));
         s = (ArrayList<Galeria>) deserializado.readObject();


    } catch (Exception e) {
      System.out.println(e);
    }
         return s;
  }
    
    

}