package ASRSController;

import java.sql.*;

class DbConnect {
    private Connection con;

    DbConnect() {
        try {
            // TODO: maybe make this more customizable
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/kbs2a?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            this.con = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("check if database if connected");
            e.printStackTrace();
        }
    }

    Package getPackage(int productNr) {
        try {
            PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM `packages` WHERE productNr = ?");
            stmt.setInt(1, productNr);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return new Package(
                        productNr,
                        resultSet.getString("productName"),
                        resultSet.getInt("x"),
                        resultSet.getInt("y"),
                        resultSet.getInt("height"),
                        false,
                        false
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
