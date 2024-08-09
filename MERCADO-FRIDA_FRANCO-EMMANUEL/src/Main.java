import dao.BD;
import modelo.Odontologo;
import servicio.OdontologoServicio;
import org.apache.log4j.Logger;


public class Main {
    public static void main(String[] args) {
        BD.createTable();
        OdontologoServicio servicio = new OdontologoServicio();

        Odontologo odontologo = new Odontologo("123","Cristian","Franco");
        servicio.guardar(odontologo);

        System.out.println("Nuevo odontologo guardado:");
        System.out.println(odontologo.toString());

        Odontologo odontologo2 = new Odontologo("124","Frida","Mercado");
        servicio.guardar(odontologo2);

        System.out.println("Nuevo odontologo guardado:");
        System.out.println(odontologo2.toString());
        Odontologo odontologo3 = new Odontologo("125","Daniel","Vargas");
        servicio.guardar(odontologo3);

        System.out.println("Nuevo odontologo guardado:");
        System.out.println(odontologo3.toString());


        System.out.println("Lista de Odontólogos:");
        servicio.listarTodo();

    }
}
