package dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class BD {
    private final static Logger LOGGER = Logger.getLogger(BD.class);

    public static void createTable() {
        Connection connection = null;

        try {
            LOGGER.info("Se estableció la conexión a la BD");
            connection = getConnection();
            Path path = Paths.get("src/dao/script.sql");
            String sql = new String(Files.readAllBytes(path));

            Statement statement = connection.createStatement();

            statement.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("No se pudo establecer la conexión a la BD");
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./202407", "sa", "sa");
    }
}
