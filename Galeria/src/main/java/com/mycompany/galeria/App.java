package com.mycompany.galeria;

import modeloClases.Galeria;
import modeloClases.Usuario;
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
import modeloClases.Album;
import modeloClases.Foto;

/**
 * JavaFX App
 */
// Kevin Magallanes 101
public class App extends Application {
    
    public static Album albumSelec=null;
    public static ArrayList<Galeria> galeriasApp=new ArrayList<>();
    public static Galeria galeriaSeleccionada=null;

    public static ArrayList<Galeria> getGaleriasApp() {
        return galeriasApp;
    }

    
   private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<Album> a=new ArrayList<>();
        Album a1=new Album("a1","d1");
        a1.getFotoContenidas().add(new Foto("t1", "f1","l1", "a1", "file:C:\\Users\\USUARIO\\OneDrive\\Documentos\\GitHub\\GaleriaImagenes\\Galeria\\src\\main\\java\\imagenes\\5.jpg"));
        a1.getFotoContenidas().add(new Foto("t4", "f1","l1", "a1", "file:C:\\Users\\USUARIO\\OneDrive\\Documentos\\GitHub\\GaleriaImagenes\\Galeria\\src\\main\\java\\imagenes\\4.jpg"));
        a1.getFotoContenidas().add(new Foto("t4", "f1","l1", "a1", "file:C:\\Users\\USUARIO\\OneDrive\\Documentos\\GitHub\\GaleriaImagenes\\Galeria\\src\\main\\java\\imagenes\\1.jpg"));
        a.add(a1);
        Galeria g1=new Galeria(new Usuario("user1","user1"),a);
         Album a2=new Album("a2","d2");
         a2.getFotoContenidas().add(new Foto("t2", "f3","l1", "a2", "file:C:\\Users\\USUARIO\\OneDrive\\Documentos\\GitHub\\GaleriaImagenes\\Galeria\\src\\main\\java\\imagenes\\3.jpg"));
        a.add(a2);
        galeriasApp.add(g1);
        
        scene = new Scene(loadFXML("inicioSesionVista"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( fxml + ".fxml"));
        return fxmlLoader.load();
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