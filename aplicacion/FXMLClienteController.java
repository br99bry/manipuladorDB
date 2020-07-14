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
    private TextField ClienteID;
    
    
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
    
    @FXML 
    private Text f;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws ParseException {
        int id = Integer.parseInt(ClienteID.getText());
         
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarCliente(id);
        

        
        a.setText("ID: "+cliente.getClienteID());
        b.setText("Nombre: "+cliente.getClienteNombre());
        c.setText("Direccion: "+ cliente.getClienteDireccion());
        d.setText("RFC: "+cliente.getClienteRFC());
        e.setText("Fecha de nacimineto: "+cliente.getFechaNacimiento());
        f.setText("Registro Exitoso, reiniciando en 5 seg .....");
        
        
        ClienteID.setText("");
        
         
    }
}
