import DatabaseUtility.DatabaseConnection;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection c = DatabaseConnection.provideConnection();
        System.out.println(c);
    }
}
