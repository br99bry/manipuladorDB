/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
   
   
   
   
       
       ArrayList<Producto> productos = new ArrayList<Producto>();
       ProductoDAO productoDAO = new ProductoDAO();
       
        productos = productoDAO.buscarProductos();
        
        for (int i = 0; i < productos.size(); i++) {
            
            listaProducto.add(productos.get(i));
        }
        
       
        
   
   
   
   
   
   
   tablaProducto.setItems(listaProducto); 
   tablaProducto.setMaxHeight(500);
   }
   
   
   
   @FXML
    private TextField productoMarca;
    @FXML
    private TextField productoModelo;
    @FXML
    private TextField productoColor;
    @FXML
    private TextField productoTipoDispositivo;
    @FXML
    private TextField productoPrecio;
    @FXML
    private TextField productoCompania;
    @FXML
    private TextField productoMaterial;
    @FXML
    private TextField productoTipoCarga;
    @FXML
    private TextField productoDescripcion;
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //EL ID SE GENERA AUTOMATICAMENTE
        String productoMarca_DB = productoMarca.getText();
        String productoModelo_DB = productoModelo.getText();
        String productoColor_DB = productoColor.getText();
        String productoTipoDispositivo_DB = productoTipoDispositivo.getText();
        String productoPrecio_DB = productoPrecio.getText();
        String productoCompania_DB = productoCompania.getText();
        String productoMaterial_DB = productoMaterial.getText();
        String productoTipoCarga_DB = productoTipoCarga.getText();
        String productoDescripcion_DB = productoDescripcion.getText();
        
        ProductoDAO productoDAO = new ProductoDAO();
        Producto producto = new Producto(productoDAO.buscarSiguienteId(),productoMarca_DB,productoModelo_DB,productoColor_DB,
                Integer.parseInt(productoTipoDispositivo_DB),Double.parseDouble(productoPrecio_DB),Integer.parseInt(productoCompania_DB),
                productoMaterial_DB,Integer.parseInt(productoTipoCarga_DB),Integer.parseInt(productoDescripcion_DB));
        System.out.println(producto.toString());
        productoDAO.insertarProducto(producto);
        
        System.out.println("Insercion exitosa");
        muestraTabla();
        productoMarca.setText("");
        productoModelo.setText("");
        productoColor.setText("");
        productoTipoDispositivo.setText("");
        productoPrecio.setText("");
        productoCompania.setText("");
        productoMaterial.setText("");
        productoTipoCarga.setText("");
        productoDescripcion.setText("");
    }
    
   
}
