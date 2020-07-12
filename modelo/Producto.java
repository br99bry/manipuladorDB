
package modelo;

//  Esta clase servira para almacenar los registros de la tabla  Producto de la base de datos 
// la cual tiene los mismo atributos que esta clase


public class Producto {
    private int productoID;
    private String productoMarca;
    private String productoModelo;
    private String productoColor;
    private int productoTipoDispositivo;
    private Double productoPrecio;
    private int productoCompania;
    private String productoMaterial;
    private int productoTipoCarga;
    private int productoDescripcion;
    
    public Producto(){
        
    }

    
    public Producto(int productoID, String productoMarca, String productoModelo, String productoColor, 
            int productoTipoDispositivo, Double productoPrecio, int productoCompania, String productoMaterial, 
            int productoTipoCarga, int productoDescripcion) {
        this.productoID = productoID;
        this.productoMarca = productoMarca;
        this.productoModelo = productoModelo;
        this.productoColor = productoColor;
        this.productoTipoDispositivo = productoTipoDispositivo;
        this.productoPrecio = productoPrecio;
        this.productoCompania = productoCompania;
        this.productoMaterial = productoMaterial;
        this.productoTipoCarga = productoTipoCarga;
        this.productoDescripcion = productoDescripcion;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public String getProductoMarca() {
        return productoMarca;
    }

    public void setProductoMarca(String productoMarca) {
        this.productoMarca = productoMarca;
    }

    public String getProductoModelo() {
        return productoModelo;
    }

    public void setProductoModelo(String productoModelo) {
        this.productoModelo = productoModelo;
    }

    public String getProductoColor() {
        return productoColor;
    }

    public void setProductoColor(String productoColor) {
        this.productoColor = productoColor;
    }

    public int getProductoTipoDispositivo() {
        return productoTipoDispositivo;
    }

    public void setProductoTipoDispositivo(int productoTipoDispositivo) {
        this.productoTipoDispositivo = productoTipoDispositivo;
    }

    public Double getProductoPrecio() {
        return productoPrecio;
    }

    public void setProductoPrecio(Double productoPrecio) {
        this.productoPrecio = productoPrecio;
    }

    public int getProductoCompania() {
        return productoCompania;
    }

    public void setProductoCompania(int productoCompania) {
        this.productoCompania = productoCompania;
    }

    public String getProductoMaterial() {
        return productoMaterial;
    }

    public void setProductoMaterial(String productoMaterial) {
        this.productoMaterial = productoMaterial;
    }

    public int getProductoTipoCarga() {
        return productoTipoCarga;
    }

    public void setProductoTipoCarga(int productoTipoCarga) {
        this.productoTipoCarga = productoTipoCarga;
    }

    public int getProductoDescripcion() {
        return productoDescripcion;
    }

    public void setProductoDescripcion(int productoDescripcion) {
        this.productoDescripcion = productoDescripcion;
    }

    @Override
    public String toString() {
        return "Producto{" + "productoID=" + productoID + ", productoMarca=" + productoMarca + ", productoModelo=" + productoModelo + ", productoColor=" + productoColor + ", productoTipoDispositivo=" + productoTipoDispositivo + ", productoPrecio=" + productoPrecio + ", productoCompania=" + productoCompania + ", productoMaterial=" + productoMaterial + ", productoTipoCarga=" + productoTipoCarga + ", productoDescripcion=" + productoDescripcion + '}';
    }
    
    
}
