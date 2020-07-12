
package modelo;

import java.sql.*;

/*
Esta clase servira para hacer las converiones necesarias y operaciones 
para insertar,eliminar,consultar datos entre un programa en java y un base de datos
que tengan en comun la estructura de objeto Producto
*/
public class ProductoDAO {
    /**
     *  Con este metodo podremos buscar un registro de la tabla Producto de la base de datos segun sea un ID que queramos
     * @param id numero de identificacion de registro de un producto
     * @return un objeto de Producto con sus atributos llenados
     */
    public Producto buscarProducto(int id){
        Producto producto = new Producto();
        //la respuesta de la base de datos vendra en un objeto ResultSet
        ResultSet rs = null;
        //creamos la cadena de texto que almacena el query solicitado a la base de datos
        String sqlQuery = "select * from Producto where ProductoID=? limit 1";
        //guardamos una conexion con nuestra base de datos en la variable conexion
        Connection conexion = Conexion.init();
        //con este objeto podemos configurar el query
        PreparedStatement stm = null;
        
        try{
            //agregamos el query al objeto que se encargara de operarlo y lo configuramos
            stm = conexion.prepareStatement(sqlQuery);
            stm.setInt(1, id);
            //ejecutamos y guardamos la respuesta en rs 
            rs = stm.executeQuery();
            //obtenemos los datos del registro de la BD y lo guardamos en un objeto Producto
            while(rs.next()){
                
                producto.setProductoID(rs.getInt("ProductoID"));
                producto.setProductoMarca(rs.getString("ProductoMarca"));
                producto.setProductoModelo(rs.getString("ProductoModelo"));
                producto.setProductoColor(rs.getString("ProductoColor"));
                producto.setProductoTipoDispositivo(rs.getInt("ProductoTipoDispositivo"));
                producto.setProductoPrecio(rs.getDouble("ProductoPrecio"));
                producto.setProductoCompania(rs.getInt("ProductoCompania"));
                producto.setProductoMaterial(rs.getString("ProductoMaterial"));
                producto.setProductoTipoCarga(rs.getInt("ProductoTipoCarga"));
                producto.setProductoDescripcion(rs.getInt("ProductoDescripcion"));
                
            }
            
            rs.close();
            stm.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return producto;
    }
    
    /**
     * Con este metodo ejecutamos un query para enviar un nuevo registro a la base de datos con los datos de una instancia de Producto
     * @param producto objeto con los datos que deseamos registrar en la base de datos 
     * @return devuelve si se ejecuto la actualizacion de datos con un entero
     */
    public int insertarProducto(Producto producto){
        
        int result = 0;
        String sqlQuery = "insert into Producto (ProductoID,ProductoMarca,ProductoModelo,ProductoColor,ProductoTipoDispositivo,ProductoPrecio,ProductoCompania,ProductoMaterial,ProductoTipoCarga,ProductoDescripcion) "
                + "values (?,?,?,?,?,?,?,?,?,?)";
        Connection conexion = Conexion.init();
        PreparedStatement stm = null;
        
        try{
            stm = conexion.prepareStatement(sqlQuery);
            stm.setInt(1, producto.getProductoID());
            stm.setString(2, producto.getProductoMarca());
            stm.setString(3, producto.getProductoModelo());
            stm.setString(4, producto.getProductoColor());
            stm.setInt(5, producto.getProductoTipoDispositivo());
            stm.setDouble(6, producto.getProductoPrecio());
            stm.setInt(7, producto.getProductoCompania());
            stm.setString(8, producto.getProductoMaterial());
            stm.setInt(9, producto.getProductoTipoCarga());
            stm.setInt(10, producto.getProductoDescripcion());
            result = stm.executeUpdate();
            
            stm.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return result;
    }
    
    /**
     * Ejecuta un query que obtiene el ultimo registro en referencia al ID
     * @return devuelve el siguiente id que deberia ser registrado
     */
    public int buscarSiguienteId(){
        int productoUltimo = 0;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection conexion = Conexion.init();
        String sqlQuery = "select ProductoID from Producto order by ProductoID desc limit 1";
        
        try{
            stm = conexion.prepareStatement(sqlQuery);
            rs = stm.executeQuery();
            rs.next();
            productoUltimo = rs.getInt("ProductoID");
            
            
            rs.close();
            stm.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return productoUltimo+1;
    }
}
