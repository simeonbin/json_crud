import java.sql.*;


public class JsonCrud {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:Json_Crud:public";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    static Connection connection = null;


    static PreparedStatement createPreparedStatement = null;
    static PreparedStatement insertPreparedStatement = null;
    static PreparedStatement selectPreparedStatement = null;

    private static Connection getDBConnection() {
      //  Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
          //  dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    // H2 SQL CREATE Prepared Statement Example
    private static void createProductRoot() throws SQLException {

    //    Connection connection = getDBConnection();

        String CreateQuery = "CREATE TABLE IF NOT EXISTS PRODUCTROOTOBJECTS" +
                "( product_id varchar(64) not NULL, " +
                "name varchar(64), " +
                "category varchar(64), " +
                "quanto BOOLEAN, " +
                "creationDate varchar(32), " +
                "expirationDate varchar(32) )";

        createPreparedStatement = connection.prepareStatement(CreateQuery);
        createPreparedStatement.executeUpdate();
        createPreparedStatement.close();
    }


    // H2 SQL INSERT (Store) Prepared Statement Example
    private static void storeProductRoot() throws SQLException {

        String InsertQuery = "INSERT INTO PRODUCTROOTOBJECTS" + "(product_id, name, category, quanto, creationDate, expirationDate) values" + "(?, ?, ?, ?, ?, ?)";
    ///    Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);

            insertPreparedStatement = connection.prepareStatement(InsertQuery);

            insertPreparedStatement.setString(1, "FX_Res_Knock_Into_FW_Imp_eu");
            insertPreparedStatement.setString(2, "FX_Res_Knock_Into_FW_Imp_eu");
            insertPreparedStatement.setString(3, "TX-based OTC");
            insertPreparedStatement.setString(4, "true");
            insertPreparedStatement.setString(5, "2018-05-25");
            insertPreparedStatement.setString(6, "2020-05-25");

            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();
        } catch(SQLException e){
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch(Exception e){
            e.printStackTrace();
        } finally{
        //    connection.close();
        }
    }

        // H2 SQL INSERT (Store) Prepared Statement Example
        private static void fetchProductRoot () throws SQLException {
            String SelectQuery = "select * from PRODUCTROOTOBJECTS";
            selectPreparedStatement = connection.prepareStatement(SelectQuery);
            ResultSet rs = selectPreparedStatement.executeQuery();
            System.out.println("H2 Database inserted through PreparedStatement");

            while (rs.next()) {
                System.out.println("product_id " + rs.getString("product_id") +
                        " name " + rs.getString("name") +
                        " category " + rs.getString("category") +
                        " quanto " + rs.getString("quanto") +
                        " creationDate" + rs.getString("creationDate") +
                        " expirationDate" + rs.getString("expirationDate")
                );
            }
            selectPreparedStatement.close();

            connection.commit();
        }


    public static void main(String[] a)  throws Exception {

       // Connection conn = DriverManager.getConnection(DB_CONNECTION,  DB_USER, DB_PASSWORD);
        // Application code goes here
        Connection connection = getDBConnection();

     //   insertWithPreparedStatement();
        createProductRoot();
        storeProductRoot();
        fetchProductRoot();

        connection.close();
    }
}
