package animals_app.services;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestConnectionDB {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/animals_db;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public List findAll() throws ClassNotFoundException, SQLException {
        //*
        // STEP 1: Register JDBC driver
        Class.forName(JDBC_DRIVER);
        //STEP 2: Open a connection
        System.out.println("Connecting to database...");
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        //STEP 3: Execute a query
        System.out.println("Creating table in given database...");
        Statement stmt = conn.createStatement();
        String sql =  "SELECT * FROM ANIMALS_DB.PUBLIC.CITIES";
        ResultSet set = stmt.executeQuery(sql);

        List<String> cities = new ArrayList<>();
        while (set.next()) {
            cities.add(set.getString(2));
        }
        System.out.println("Get data from database..." + set);
        // STEP 4: Clean-up environment
        stmt.close();
        conn.close();
        System.out.println(ANSI_RED + "===============================================");
        System.out.println("all cities: " + cities + ANSI_RESET);
        System.out.println("Goodbye!");

        return cities;
        //*/
		/*
		Query query = em.createQuery("SELECT e FROM City e");

		System.out.println(ANSI_RED + "===============================================");
		System.out.println("all cities: " + query.getResultList() + ANSI_RESET);
		return query.getResultList();*/
    }

}
