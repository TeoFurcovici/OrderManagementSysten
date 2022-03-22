package connection;

import java.sql.*;
import java.util.logging.Logger;

/**
 * The type Connection factory.
 */
public class ConnectionFactory {
    private static final Logger LOGGER=Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/pt3_database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER="root";
    private static final String PASS="teomelania,05";
    private  final static ConnectionFactory singleInstance=new ConnectionFactory();

    private ConnectionFactory(){
        try {
            Class.forName(DRIVER);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    private Connection createConnection()
    {
        Connection connection=null;
        try
        {
            connection= DriverManager.getConnection(DBURL,USER,PASS);
        }
        catch(SQLException exception)
        {

            System.out.println("An error occurred while connecting MySQL databse");
            exception.printStackTrace();
        }
        return  connection;
    }

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Close.
     *
     * @param connection the connection
     * @throws SQLException the sql exception
     */
    public static void close(Connection connection) throws SQLException {
        if(connection!=null)
                connection.close();
    }

    /**
     * Close.
     *
     * @param statement the statement
     * @throws SQLException the sql exception
     */
    public  static void close(Statement statement) throws SQLException {
        if(statement!=null)
                statement.close();
    }

    /**
     * Close.
     *
     * @param resultSet the result set
     * @throws SQLException the sql exception
     */
    public static void close(ResultSet resultSet) throws SQLException {
        if(resultSet!=null)
            resultSet.close();
    }
}
