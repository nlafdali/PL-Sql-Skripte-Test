package com.example.plsql_test.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.*;

import static java.lang.Integer.parseInt;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class FunktionAufrufenmitGui extends JFrame {

    JButton btn_connect;
    private CallableStatement statement;
    FunktionAufrufenmitGui(){
        this.setTitle("SeminarTage");
        this.setSize(900,600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        //this.setLayout(new BorderLayout());

        JLabel lbl_id = new JLabel("p_frw_id");
        lbl_id.setBounds(15,60, 250,25);
        lbl_id.setBorder(BorderFactory.createEmptyBorder());
        lbl_id.setFont(new Font("arial", Font.BOLD, 20));
        this.add(lbl_id);

        JLabel lbl_geburtsdatum = new JLabel("p_geburtsdatum");
        lbl_geburtsdatum.setBounds(15,110, 250,25);
        lbl_geburtsdatum .setBorder(BorderFactory.createEmptyBorder());
        lbl_geburtsdatum .setFont(new Font("arial", Font.BOLD, 18));
        this.add(lbl_geburtsdatum);

        JLabel lbl_ver_dat_vertrag = new JLabel("p_ver_dat_vertrag");
        lbl_ver_dat_vertrag.setBounds(15,160, 250,25);
        lbl_ver_dat_vertrag.setBorder(BorderFactory.createEmptyBorder());
        lbl_ver_dat_vertrag.setFont(new Font("arial", Font.BOLD, 18));
        this.add(lbl_ver_dat_vertrag);

        JLabel lbl_ver_status_grund = new JLabel("p_ver_status_grund");
        lbl_ver_status_grund.setBounds(15,210, 250,25);
        lbl_ver_status_grund.setBorder(BorderFactory.createEmptyBorder());
        lbl_ver_status_grund.setFont(new Font("arial", Font.BOLD, 18));
        this.add(lbl_ver_status_grund);

        JLabel lbl_p_beginn = new JLabel("p_beginn");
        lbl_p_beginn.setBounds(15,260, 250,25);
        lbl_p_beginn.setBorder(BorderFactory.createEmptyBorder());
        lbl_p_beginn.setFont(new Font("arial", Font.BOLD, 18));
        this.add(lbl_p_beginn);

        JLabel lbl_p_ende = new JLabel("p_ende");
        lbl_p_ende.setBounds(15,310, 250,25);
        lbl_p_ende.setBorder(BorderFactory.createEmptyBorder());
        lbl_p_ende.setFont(new Font("arial", Font.BOLD, 18));
        this.add(lbl_p_ende);

        JLabel lbl_p_ende_urspr = new JLabel("p_ende_urspr");
        lbl_p_ende_urspr.setBounds(15,360, 250,25);
        lbl_p_ende_urspr.setBorder(BorderFactory.createEmptyBorder());
        lbl_p_ende_urspr.setFont(new Font("arial", Font.BOLD, 18));
        this.add(lbl_p_ende_urspr);

        JLabel lbl_p_ver_sch_status = new JLabel("p_ver_sch_status");
        lbl_p_ver_sch_status.setBounds(15,410, 250,25);
        lbl_p_ver_sch_status.setBorder(BorderFactory.createEmptyBorder());
        lbl_p_ver_sch_status.setFont(new Font("arial", Font.BOLD, 18));
        this.add(lbl_p_ver_sch_status);

        JTextField txt_id = new JTextField();
        // txt_id.setText(" Bitte frw_id eingeben");
        txt_id.setForeground(Color.gray);
        txt_id.setCaretColor(Color.orange);
        txt_id.setBounds(350, 60, 400, 30);
        txt_id.setBorder(BorderFactory.createEmptyBorder());
        txt_id.setFont(new Font("arial", Font.BOLD, 13));
        txt_id.getText();
        txt_id.setEditable(true);
        this.add(txt_id);

        JTextField txt_geburtsdatum = new JTextField();
        txt_geburtsdatum.setBounds(350, 110, 400, 30);
        // txt_geburtsdatum.setText(" Bitte frw_geburtsdatum eingeben");
        txt_geburtsdatum.setForeground(Color.gray);
        txt_geburtsdatum.setCaretColor(Color.orange);
        txt_geburtsdatum.setBorder(BorderFactory.createEmptyBorder());
        txt_geburtsdatum.setFont(new Font("arial", Font.BOLD, 13));
        txt_geburtsdatum.getText();
        this.add(txt_geburtsdatum);

        JTextField txt_ver_dat_vertrag = new JTextField();
        txt_ver_dat_vertrag.setBounds(350, 160, 400, 30);
        // txt_ver_dat_vertrag.setText(" Bitte p_ver_dat_vertrag eingeben");
        txt_ver_dat_vertrag.setForeground(Color.gray);
        txt_ver_dat_vertrag.setCaretColor(Color.orange);
        txt_ver_dat_vertrag.setBorder(BorderFactory.createEmptyBorder());
        txt_ver_dat_vertrag.setFont(new Font("arial", Font.BOLD, 13));
        txt_ver_dat_vertrag.getText();
        this.add(txt_ver_dat_vertrag);

        JTextField txt_ver_status_grund = new JTextField();
        txt_ver_status_grund.setBounds(350, 210, 400, 30);
        // txt_ver_status_grund.setText(" Bitte ver_status_grund eingeben");
        txt_ver_status_grund.setForeground(Color.gray);
        txt_ver_status_grund.setCaretColor(Color.orange);
        txt_ver_status_grund.setBorder(BorderFactory.createEmptyBorder());
        txt_ver_status_grund.setFont(new Font("arial", Font.BOLD, 13));
        txt_ver_status_grund.getText();
        this.add(txt_ver_status_grund);

        JTextField txt_p_beginn = new JTextField();
        txt_p_beginn.setBounds(350, 260, 400, 30);
        //txt_p_beginn.setText(" Bitte das Beginndatum eingeben");
        txt_p_beginn.setForeground(Color.gray);
        txt_p_beginn.setCaretColor(Color.orange);
        txt_p_beginn.setBorder(BorderFactory.createEmptyBorder());
        txt_p_beginn.setFont(new Font("arial", Font.BOLD, 13));
        txt_p_beginn.getText();
        this.add(txt_p_beginn);

        JTextField txt_p_ende = new JTextField();
        txt_p_ende.setBounds(350, 310, 400, 30);
        //txt_p_ende.setText(" Bitte das Endedatum eingeben");
        txt_p_ende.setForeground(Color.gray);
        txt_p_ende.setCaretColor(Color.orange);
        txt_p_ende.setBorder(BorderFactory.createEmptyBorder());
        txt_p_ende.setFont(new Font("arial", Font.BOLD, 13));
        txt_p_ende.setForeground(Color.gray);
        txt_p_ende.getText();

        this.add( txt_p_ende);

        JTextField txt_p_ende_urspr = new JTextField();
        txt_p_ende_urspr.setBounds(350, 360, 400, 30);
        //txt_p_ende_urspr.setText(" Bitte das ursprüngliche Endedatum eingeben");
        txt_p_ende_urspr.setForeground(Color.gray);
        txt_p_ende_urspr.setCaretColor(Color.orange);
        txt_p_ende_urspr.setBorder(BorderFactory.createEmptyBorder());
        txt_p_ende_urspr.setFont(new Font("arial", Font.BOLD, 13));
        txt_p_ende_urspr.setForeground(Color.gray);
        txt_p_ende_urspr.getText();
        this.add(txt_p_ende_urspr);

        JTextField txt_p_ver_sch_status = new JTextField();
        txt_p_ver_sch_status.setBounds(350, 410, 400, 30);
        //txt_p_ver_sch_status.setText(" Bitte p_ver_sch_status eingeben");
        txt_p_ver_sch_status.setForeground(Color.gray);
        txt_p_ver_sch_status.setCaretColor(Color.orange);
        txt_p_ver_sch_status.setBorder(BorderFactory.createEmptyBorder());
        txt_p_ver_sch_status.setFont(new Font("arial", Font.BOLD, 13));
        txt_p_ver_sch_status.setForeground(Color.gray);
        txt_p_ver_sch_status.getText();
        this.add(txt_p_ver_sch_status);

        JTextField txt_result = new JTextField();
        txt_result.setBounds(20, 460, 400, 30);
        txt_result.setBorder(BorderFactory.createEmptyBorder());
        txt_result.setFont(new Font("arial", Font.BOLD, 20));
        txt_result.setForeground(Color.blue);
        txt_result.getText();
        this.add(txt_result);

        JButton btn_connect = new JButton("Connection");
        btn_connect.setBounds(350, 10, 400,35);
        btn_connect.setBorder(BorderFactory.createEtchedBorder());
        btn_connect.setFont(new Font("Consolas", Font.BOLD, 20));
        btn_connect.setForeground(Color.DARK_GRAY);
        this.add(btn_connect);
        btn_connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //btn_connectActionPerformed(e);
                if (e.getSource() == btn_connect) {
                    try{
                        Class.forName("oracle.jdbc.OracleDriver");
                        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//oracle-ebfd-newest:1521/ebfd","BFD_DEV_OS", "BFD_DEV_OS");
                        //JOptionPane.showMessageDialog(null, "du bist mit Oracle Datenbank verbunden");
                        if (connection !=null)
                            JOptionPane.showMessageDialog(null, "du bist mit Oracle Datenbank verbunden");
                        else
                            JOptionPane.showMessageDialog(null, "keine Connecction mit Datenbank", "Conenction", 0);

                        JOptionPane.showMessageDialog(null, "Bitte die Felder ausfüllen", "rechnen", 1);

                    }catch (SQLException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        JButton btn_res = new JButton("Result");
        btn_res.setBounds(530, 460, 200,40);
        btn_res.setBorder(BorderFactory.createEtchedBorder());
        btn_res.setFont(new Font("Consolas", Font.BOLD, 24));
        btn_res.setForeground(Color.BLUE);
        // btn_res.setBackground(Color.DARK_GRAY);
        this.add(btn_res);
        btn_res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()== btn_res)
                    try{

                        Class.forName("oracle.jdbc.OracleDriver");

                        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//oracle-ebfd-newest:1521/ebfd","BFD_DEV_OS", "BFD_DEV_OS");

                        if (txt_id.getText().isEmpty() || txt_p_ver_sch_status.getText().isEmpty() ||
                                txt_p_beginn.getText().isEmpty() || txt_geburtsdatum.getText().isEmpty()
                                || txt_p_ende.getText().isEmpty()|| txt_p_ende_urspr.getText().isEmpty()
                                || txt_ver_dat_vertrag.getText().isEmpty() || txt_ver_status_grund.getText().isEmpty()
                        ){
                            JOptionPane.showMessageDialog(null, "Bitte geben sie fehlende Werte ");
                            return;

                        }

                        int result = gibanzahlSeminarTage(
                                connection,
                                parseInt(txt_id.getText()), txt_geburtsdatum.getText(), txt_ver_dat_vertrag.getText(), txt_ver_status_grund.getText(), txt_p_beginn.getText(), txt_p_ende.getText(),
                                txt_p_ende_urspr.getText(),
                                Integer.parseInt(txt_p_ver_sch_status.getText())
                        );

                        txt_result.setText("die Anzahl der Seminartage ist:  " + Integer.toString(result));

                        int option = JOptionPane.showConfirmDialog(null, "Möchten sie die Funktion erneut mit anderen Parametern rechnen? ", "erneut rechnen", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.YES_OPTION){

                            txt_id.setText("");
                            txt_geburtsdatum.setText("");
                            txt_ver_dat_vertrag.setText("");
                            txt_ver_status_grund.setText("");
                            txt_p_beginn.setText("");
                            txt_p_ende.setText("");
                            txt_p_ende_urspr.setText("");
                            txt_p_ver_sch_status.setText("");
                            txt_result.setText("");

                        }else
                            dispose();

                    }catch(SQLException exp){
                        System.out.println(exp.getMessage());
                    }catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
            }
        });

        this.setVisible(true);

    }

    public static void main(String[] args) {
        FunktionAufrufenmitGui frame = new FunktionAufrufenmitGui();

    }

    public int gibanzahlSeminarTage(Connection connection, int p_frw_id , String p_geburtsdatum , String p_ver_dat_vertrag, String p_ver_status_grund, String p_beginn, String p_ende , String p_ende_urspr , int p_ver_sch_status) throws SQLException{
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
