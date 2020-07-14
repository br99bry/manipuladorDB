/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author coppel
 */
public class Inicio extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        /*-----------------------------------------------------------------------------------------------------*/
        /*Genere una tabla que permita visualizar los datos de la tabla Producto y que en la parte
        inferior de la tabla (por debajo) contenga campos de texto para recibir los datos de un
        nuevo registro, y un botón de guardar.
        Cuando se presione el botón se debe de insertar el registro en la BD y se debe de
        actualizar la tabla*/
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLProducto.fxml"));
        
        
        /*-----------------------------------------------------------------------------------------------------------------------*/
        /*Genere una formulario que permita buscar un lun cliente a partir de su ID. Cuando se
        presione el botón de enviar, se deben recuperar los datos del cliente y se deben de
        mostrar estos debajo del formulario a través de objetos tipo Label.*/
 
        
        //DESCOMENTAR PARA ACTIVAR ---------------------------------------------------
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLCliente.fxml"));
        /*------------------------------------------------------------------------------------------------------*/
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
