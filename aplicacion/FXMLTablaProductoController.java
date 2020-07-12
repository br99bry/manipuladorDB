/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import modelo.Cliente;
import modelo.Producto;
import modelo.ProductoDAO;

/**
 * FXML Controller class
 *
 * @author coppel
 */
public class FXMLTablaProductoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TableView<Producto> tablaProducto;
    @FXML private ObservableList<Producto> listaProducto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        muestraTabla();
    }    
    
    @FXML
   public void muestraTabla(){
   listaProducto= FXCollections.observableArrayList();
   
   ProductoDAO productoDAO = new ProductoDAO();
   
   for(int i=0;i<3;i++){
       Producto producto = new Producto();
        producto = productoDAO.buscarProducto(i);
        listaProducto.add(producto);
   }
   
   tablaProducto.setItems(listaProducto); 
   }
}
