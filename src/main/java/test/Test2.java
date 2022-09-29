package test;
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
import config.HibernateUtil;
import controladores.ControladorProducto;
import controladores.ControladorProveedor;
import entidades.Producto;
import entidades.Proveedor;
import java.util.ArrayList;
import org.hibernate.Session;

public class Test2 {

    public static void main(String[] args) {
        System.out.println("Iniciando conexion MySQL");
        try ( Session session = HibernateUtil.getCurrentSession()) {
            ControladorProducto cp = new ControladorProducto(session);
            ControladorProveedor cprov = new ControladorProveedor(session);

            ArrayList<Producto> productos = new ArrayList<>();

            Producto prod1 = new Producto("HD 1TB", "HD WesternDigital 1TB", 15);

            Producto prod2 = new Producto("Pendrive 64GB", "Kingstone", 50);

            Producto prod3 = new Producto("Mouse inalambrico", "Genius A34", 200);

            productos.add(prod1);
            productos.add(prod2);
            productos.add(prod3);

            Proveedor prov1 = new Proveedor("Garcia", "Matias", "25-369258147-9", "garciait@gmail.com", "2021-4589", productos);

            cprov.save(prov1);

            System.out.println("--------PRODUCTOS--------");
            System.out.println(cp.findAll());
            System.out.println("--------PROVEEDORES--------");
            System.out.println(cprov.findAll());

            session.close();
            System.out.println("Se cerro conexion MySQL");
        }
    }
}
