
package modelo;

import java.sql.Date;

//  Esta clase servira para almacenar los registros de la tabla  Cliente de la base de datos 
// la cual tiene los mismo atributos que esta clase 
public class Cliente {
    private int clienteID;
    private String clienteNombre;
    private String clienteDireccion;
    private String clienteRFC;
    private Date fechaNacimiento;
    
    public Cliente(){
        
    }
    
    public Cliente(int clienteID, String clienteNombre, String clienteDireccion, String clienteRFC, Date fechaNacimiento) {
        this.clienteID = clienteID;
        this.clienteNombre = clienteNombre;
        this.clienteDireccion = clienteDireccion;
        this.clienteRFC = clienteRFC;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteDireccion() {
        return clienteDireccion;
    }

    public void setClienteDireccion(String clienteDireccion) {
        this.clienteDireccion = clienteDireccion;
    }

    public String getClienteRFC() {
        return clienteRFC;
    }

    public void setClienteRFC(String clienteRFC) {
        this.clienteRFC = clienteRFC;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clienteID=" + clienteID + ", clienteNombre=" + clienteNombre + ", clienteDireccion=" + clienteDireccion + ", clienteRFC=" + clienteRFC + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    
}
