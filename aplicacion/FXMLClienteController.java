/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import modelo.Cliente;
import modelo.ClienteDAO;

/**
 * FXML Controller class
 *
 * @author coppel
 */
public class FXMLClienteController implements Initializable {
    
    
    @FXML 
    private TextField ClienteNombre;
    
    @FXML 
    private TextField ClienteDireccion;
    
    @FXML 
    private TextField ClienteRFC;
    
    @FXML 
    private TextField ClienteFechaNac;
    
    @FXML 
    private Text a;
    
    @FXML 
    private Text b;
    
    @FXML 
    private Text c;
   
    @FXML 
    private Text d;
    
    @FXML 
    private Text e;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws ParseException {
        //EL ID SE GENERA AUTOMATICAMENTE
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
         Date fechaDate = null;
         String fecha =ClienteFechaNac.getText();
         java.util.Date pased = formato.parse(fecha);
         fechaDate = new Date(pased.getTime());
         {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente(clienteDAO.buscarSiguienteId(),ClienteNombre.getText(),ClienteDireccion.getText(),
        ClienteRFC.getText(),fechaDate);
        clienteDAO.insertarCliente(cliente);
         }
        Cliente clienteRegistrado;
        ClienteDAO clienteDAO2 = new ClienteDAO();
        int id = clienteDAO2.buscarSiguienteId()-1;
        clienteRegistrado = clienteDAO2.buscarCliente(id);
        a.setText("ID: "+clienteRegistrado.getClienteID());
        b.setText("Nombre: "+clienteRegistrado.getClienteNombre());
        c.setText("Direccion: "+ clienteRegistrado.getClienteDireccion());
        d.setText("RFC: "+clienteRegistrado.getClienteRFC());
        e.setText("Fecha de nacimineto: "+clienteRegistrado.getFechaNacimiento());
    }
}
