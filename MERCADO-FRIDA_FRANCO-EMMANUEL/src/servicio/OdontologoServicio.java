package servicio;

import dao.IDAO;
import dao.impl.ImplementacionDaoArray;
import dao.impl.ImplementacionDaoH2;
import modelo.Odontologo;
import org.apache.log4j.Logger;


import java.util.List;

public class OdontologoServicio {
    private final static Logger LOGGER = Logger.getLogger(OdontologoServicio.class);
    private IDAO<Odontologo> interfazDAO;


    public OdontologoServicio() {
        LOGGER.warn("Funcionalidad de persistencia utilizando H2");
        this.interfazDAO = new ImplementacionDaoH2();

    }

    public Odontologo guardar(Odontologo odontologo) {
        return interfazDAO.guardar(odontologo);
    }

    public List<Odontologo> listarTodo() {
        return interfazDAO.listarTodo();
    }
}
