package com.example.plsql_test.controller;


import java.sql.*;


public class FunctionAufrufen {
    private static CallableStatement statement;
    private Connection connection;

    public static void main(String[] args) {
        try {


            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:....................");
            int result = gibanzahlSeminarTage(connection, 123, "1990-01-01", "2022-02-01",
                    "status", "2022-03-01", "2022-09-31","2022-09-31", 1004);
            System.out.println("die Anzahl der Seminartage ist: : " + result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int gibanzahlSeminarTage(Connection connection, int p_frw_id , String p_geburtsdatum , String p_ver_dat_vertrag, String p_ver_status_grund, String p_beginn, String p_ende , String p_ende_urspr , int p_ver_sch_status) throws SQLException{
        String query = "{ ? = call gibAnzahlSeminarTage (?,?,?,?,?,?,?,?)}";
        int result =0;
        try{

            statement = connection.prepareCall(query);

            statement.registerOutParameter(1, Types.INTEGER);
            statement.setInt(2, p_frw_id);
            statement.setDate(3, java.sql.Date.valueOf(p_geburtsdatum));
            statement.setDate(4, java.sql.Date.valueOf(p_ver_dat_vertrag ));
            statement.setString(5, p_ver_status_grund);
            statement.setDate(6, java.sql.Date.valueOf(p_beginn));
            statement.setDate(7, java.sql.Date.valueOf(p_ende));
            statement.setDate(8, java.sql.Date.valueOf(p_ende_urspr));
            statement.setInt(9, p_ver_sch_status);
            statement.execute();

            result = statement.getInt(1);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if (statement!=null)
                    statement.close();
                if ( connection!=null)
                    connection.close();

            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }

        }
        return result;

    }

}
