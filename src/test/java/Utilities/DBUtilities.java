package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtilities {

    private static Connection connection;
    protected static Statement statement;

    public static void DBConnectionOpen() {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";//hostname,port/db adını
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password); // DB işe connection
            statement = connection.createStatement(); // sorguları çalıştırmak için page açıldı.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
        public void DBConnectionClose() {

            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public static void main(String[] args) {

        List<List<String>> tablo = getListData("select * from States");

        for (List<String> satir : tablo)
            System.out.println("satir  : " + satir);

    }

        public static List<List<String>> getListData (String query){
            //DB den bütün satırları ve sütünları okuyup bu liste atacağım.
            List<List<String>> tablo = new ArrayList<>();

            //DB bağlantıyı aç
             DBConnectionOpen();

            //işlemleri yap
            try {
                ResultSet rs = statement.executeQuery(query);
                int columnSayisi = rs.getMetaData().getColumnCount();

                while (rs.next()){
                    List<String> satir = new ArrayList<>();
                    for (int i = 1; i <= columnSayisi; i++) {
                        satir.add(rs.getString(i));
                    }
                    tablo.add(satir);
                }

            }catch (Exception ex){
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }

            //DB kapat


            return tablo;
        }
    }
