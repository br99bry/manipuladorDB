
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
Esta clase servira para hacer las converiones necesarias y operaciones 
para insertar,eliminar,consultar datos entre un programa en java y un base de datos
que tengan en comun la estructura de objeto Cliente
*/

public class ClienteDAO {
    
    /**
     * Con este metodo podremos buscar un registro de la tabla Cliente de la base de datos segun sea un ID que queramos
     * @param id numero de identificacion de registro de un cliente
     * @return un objeto de Cliente con sus atributos llenados
     */
    public Cliente buscarCliente(int id){
        Cliente cliente1 = new Cliente();
        
        //la respuesta de la base de datos vendra en un objeto ResultSet
        ResultSet rs = null;
        //creamos la cadena de texto que almacena el query solicitado a la base de datos
        String sqlQuery = "select * from Cliente where ClienteID=? limit 1";
        //guardamos una conexion con nuestra base de datos en la variable conexion
        Connection  conexion = Conexion.init();
        //con este objeto podemos configurar el query
        PreparedStatement stm = null; 
        
        
        try{
            //agregamos el query al objeto que se encargara de operarlo y lo configuramos
            stm = conexion.prepareStatement(sqlQuery);
            stm.setInt(1, id);
            //ejecutamos y guardamos la respuesta en rs 
            rs = stm.executeQuery();
            
            //obtenemos los datos del registro de la BD y lo guardamos en un objeto Cliente
            while(rs.next()){
                
                cliente1.setClienteID(rs.getInt("ClienteID"));
                cliente1.setClienteNombre(rs.getString("ClienteNombre"));
                cliente1.setClienteDireccion(rs.getString("ClienteDireccion"));
                cliente1.setClienteRFC(rs.getString("ClienteRFC"));
                cliente1.setFechaNacimiento(rs.getDate("ClienteFechaNac"));
                
            }
            
            rs.close();
            stm.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        
        
        return cliente1;
    }
    
    /**
     * Con este metodo ejecutamos un query para enviar un nuevo registro a la base de datos con los datos de una instancia de Cliente
     * @param c objeto con los datos que deseamos registrar en la base de datos 
     * @return devuelve si se ejecuto la actualizacion de datos con un entero
     */
    public int insertarCliente(Cliente c){
        
        int result=0;
        String sqlQuery = "insert into Cliente (ClienteID,ClienteNombre,ClienteDireccion,ClienteRFC,ClienteFechaNac) "
                + "values (?,?,?,?,?)";
        Connection  conexion = Conexion.init();
        PreparedStatement stm = null;
        
        try{
            
            stm = conexion.prepareStatement(sqlQuery);
            stm.setInt(1, c.getClienteID());
            stm.setString(2, c.getClienteNombre());
            stm.setString(3, c.getClienteDireccion());
            stm.setString(4, c.getClienteRFC());
            stm.setDate(5, c.getFechaNacimiento());
            result = stm.executeUpdate();
            
          
            stm.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        
        
        return result;
    }
    
    
    public int buscarSiguienteId(){
        int clienteUltimo = 0;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection conexion = Conexion.init();
        String sqlQuery = "select ClienteID from Cliente order by ClienteID desc limit 1";
        
        try{
            stm = conexion.prepareStatement(sqlQuery);
            rs = stm.executeQuery();
            rs.next();
            clienteUltimo = rs.getInt("ClienteID");
            
            rs.close();
            stm.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return clienteUltimo+1;
    }
}
