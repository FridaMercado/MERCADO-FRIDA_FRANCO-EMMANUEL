package dao.impl;
import dao.IDAO;
import modelo.Odontologo;

import java.util.List;

public class ImplementacionDaoArray implements IDAO<Odontologo> {
    private List<Odontologo> odontologos;
    public ImplementacionDaoArray(List<Odontologo> odontologos) {
        this.odontologos = odontologos;
    }

    public ImplementacionDaoArray() {

    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodo() {
        return odontologos;
    }
}
