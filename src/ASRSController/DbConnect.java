package ASRSController;

import java.sql.*;

public class DbConnect {
    private Connection con;
    // todo: add cache

    public DbConnect() {
        try {
            // TODO: maybe make this more customizable
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/kbs2a?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            this.con = DriverManager.getConnection(url, "root", "");
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Package getPackage(int productNr) {
        try {
            PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM `packages` WHERE productNr = ?");
            stmt.setInt(1, productNr);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                return new Package(
                    productNr,
                    resultSet.getString("productName"),
                    resultSet.getInt("x"),
                    resultSet.getInt("y"),
                    resultSet.getInt("height")
                );
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
//
//    public int[] getData(int productNr) {
//        int[] data = new int[]{productNr,0,0,0};
//
//        try {    
//            PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM `packages` WHERE productNr = ?");
//            stmt.setInt(1, productNr);
//            this.rs = stmt.executeQuery();
//            
//            while(rs.next()) {
//                data[1] = rs.getInt("x");
//                data[2] = rs.getInt("y");
//                data[3] = rs.getInt("height");
//            }
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
//
//    public String getName(int productNr) {
//        String name = "";
//
//        try {    
//            PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM `packages` WHERE productNr = ?");
//            stmt.setInt(1, productNr);
//            this.rs = stmt.executeQuery();
//
//            while(this.rs.next()) {
//                name = this.rs.getString("productName");
//            }
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//        return name;
//    }
}
