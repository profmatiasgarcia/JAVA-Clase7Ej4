package controladores;
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
import entidades.Producto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ControladorProducto implements InterControl<Producto> {

    private final Session session;

    public ControladorProducto(Session session) {
        this.session = session;
    }

    @Override
    public void save(Producto t) {
        Transaction trx = session.beginTransaction();

        session.persist(t);
        System.out.println("El producto se agrego correctamente con el id: " + t.getId());

        trx.commit();
    }

    @Override
    public List<Producto> findAll() {
        Transaction trx = session.beginTransaction();

        List<Producto> productos = session.createQuery("FROM productos", Producto.class).getResultList();

        trx.commit();
        return productos;
    }

    @Override
    public Producto findOneById(int id) {
        //Transaction trx = session.beginTransaction();

        Producto productoEncontrado = session.createNativeQuery("SELECT * FROM productos WHERE idProducto =:id", Producto.class).setParameter("id", id).getSingleResult();

        //trx.commit();
        return productoEncontrado;
    }

    @Override
    public void update(Producto t) {
        Transaction trx = session.beginTransaction();

        session.merge(t);
        System.out.println("El producto se ha modificado correctamente con el id: " + t.getId());

        trx.commit();
    }

    @Override
    public void delete(Producto t) {
        Transaction trx = session.beginTransaction();

        session.remove(t);
        System.out.println("El producto se ha eliminado correctamente");

        trx.commit();
    }

}
