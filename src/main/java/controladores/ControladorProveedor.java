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
import entidades.Proveedor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ControladorProveedor implements InterControl<Proveedor> {

    private final Session session;

    public ControladorProveedor(Session session) {
        this.session = session;
    }

    @Override
    public void save(Proveedor t) {
        Transaction trx = session.beginTransaction();

        session.persist(t);
        System.out.println("El proveedor se agrego correctamente con el id: " + t.getIdPersona());

        trx.commit();
    }

    @Override
    public List<Proveedor> findAll() {
        Transaction trx = session.beginTransaction();

        List<Proveedor> proveedores = session.createQuery("FROM proveedores", Proveedor.class).getResultList();

        trx.commit();
        return proveedores;
    }

    @Override
    public Proveedor findOneById(int id) {
        Transaction trx = session.beginTransaction();

        Proveedor proveedorEncontrado = session.createQuery("FROM proveedores where idPersona =:id", Proveedor.class).setParameter("id", id).getSingleResult();

        trx.commit();
        return proveedorEncontrado;
    }

    @Override
    public void update(Proveedor t) {
        Transaction trx = session.beginTransaction();

        session.merge(t);
        System.out.println("El proveedor se ha modificado correctamente con el id: " + t.getIdPersona());

        trx.commit();
    }

    @Override
    public void delete(Proveedor t) {
        Transaction trx = session.beginTransaction();

        session.remove(t);
        System.out.println("El proveedor se ha eliminado correctamente");

        trx.commit();
    }

}
