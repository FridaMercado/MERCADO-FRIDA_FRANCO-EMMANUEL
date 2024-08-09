package dao.impl;

import dao.BD;
import dao.IDAO;
import modelo.Odontologo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionDaoH2 implements IDAO<Odontologo> {
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try {

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO ODONTOLOGOS (" +
                            "MATRICULA, NOMBRE, APELLIDO) VALUES " +
                            "(?,?,?)", Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.execute();

            //guardé el odonto y se generó el id

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                odontologo.setId(rs.getInt(1));
                System.out.println("Se guardó el odontólogo: " + odontologo.getNombre());
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodo() {
        Connection connection = null;

        List<Odontologo> odontologoList = new ArrayList<>();
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ODONTOLOGOS"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                odontologo = new Odontologo(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getString(4));

                odontologoList.add(odontologo);

                System.out.println(odontologo.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologoList;
    }

}
