package entidades;
/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2021 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 */
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity(name = "proveedores")
public class Proveedor extends Persona {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Producto> productos;

    private String mail;
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(String mail, String telefono, String apellido, String nombre, String cuit) {
        super(apellido, nombre, cuit);
        this.mail = mail;
        this.telefono = telefono;
    }

    public Proveedor(String apellido, String nombre, String cuit, String mail, String telefono, List<Producto> productos) {
        super(apellido, nombre, cuit);
        this.productos = productos;
        this.mail = mail;
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void addProducto(Producto producto) {
        if (this.productos == null) {
            this.productos = new ArrayList<Producto>();
        }
        this.productos.add(producto);

    }

    @Override
    public String toString() {
        return "Proveedor{" + super.toString() + ", mail=" + mail + ", telefono=" + telefono + " productos=" + productos + '}';
    }

}
