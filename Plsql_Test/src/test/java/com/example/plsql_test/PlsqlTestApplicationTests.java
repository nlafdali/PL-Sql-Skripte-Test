package com.example.plsql_test;

import com.example.plsql_test.controller.FunctionAufrufen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlsqlTestApplicationTests {

    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        // Hier kannst du die Verbindungsdetails deiner Test-Datenbank angeben
        Class.forName("oracle.jdbc.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "testuser", "testpassword");
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    void testGibanzahlSeminarTage() throws SQLException {

        // Aufruf der Funktion mit Testdaten
        int result = FunctionAufrufen.gibanzahlSeminarTage(connection, 123, "1990-01-01", "2022-02-01",
                "status", "2022-03-01", "2022-09-30", "2022-09-30", 1004);

        // Überprüfung, um sicherzustellen, dass das Ergebnis korrekt ist
        assertEquals(5, result, "Die Anzahl der Seminartage sollte 5 sein.");
    }
/*
    @Test
    public void testCalculateSeminarDays() {
        try {
            int ressult = SeminarDaysCalculator.calculateSeminarDays(
                    123, "1990-01-01", "2022-01-01", "Status", "2022-01-01", "2022-02-01", "2022-03-01", 1004);

            // Erwartete Anzahl der Seminartage hier einfügen
            int expectedSeminarTage = 42;

            assertEquals(expectedSeminarTage, seminarDays);
        } catch (Exception e) {
            // Fehler während des Tests
            e.printStackTrace();
        }
    }*/



    @Test
    void contextLoads() {
    }

}
