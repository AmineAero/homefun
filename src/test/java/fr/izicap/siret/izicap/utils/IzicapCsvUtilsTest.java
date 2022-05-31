package fr.izicap.siret.izicap.utils;

import com.opencsv.CSVReader;
import fr.izicap.siret.izicap.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IzicapCsvUtilsTest {

    private static final String HEADER = "id,nic,full_adresse,creation_date,full_name,tva_number";
    private static final String COMPANY1 = "449554493,00033,6 Rue Forville 06400 Cannes,Thu May 14 02:00:00 CEST 1998,QUALITE FOOD GROUPE,FR54413394420";
    private static final String COMPANY2 = "449566023,00013,7 Rue Raoul Bosio 06300 Nice,Tue Feb 17 01:00:00 CET 1998,OPERA VINS,FR56417763042";
    private static final String CSV_FILE_NAME = "test.csv";

    private static List<String[]> companies;

    @BeforeAll
    static void setUp() {
        companies = Arrays.asList(HEADER.split(","), COMPANY1.split(","));
    }

    @AfterEach
    void tearDown() {
        TestUtils.deleteTestFile(CSV_FILE_NAME);
    }

    @Test
    void writeAll() throws IOException {
        // Given
        // an empty CSV file
        // When
        IzicapCsvUtils.writeAll(companies, CSV_FILE_NAME);

        // Then
        List<String[]> csvBody = TestUtils.readAllLinesFromCsvFile(CSV_FILE_NAME);
        assertEquals(2, csvBody.size());

    }

    @Test
    void addOneLine() throws IOException {
        // Given
        IzicapCsvUtils.writeAll(companies, CSV_FILE_NAME);
        List<String[]> csvBody = TestUtils.readAllLinesFromCsvFile(CSV_FILE_NAME);
        assertEquals(2, csvBody.size());

        // When
        IzicapCsvUtils.addOneLine(COMPANY2.split(","), CSV_FILE_NAME);

        // Then
        csvBody = TestUtils.readAllLinesFromCsvFile(CSV_FILE_NAME);
        assertEquals(3, csvBody.size());
    }

    @Test
    void readAllLines() throws IOException {
        // Given a CSV with 2 lines
        IzicapCsvUtils.writeAll(companies, CSV_FILE_NAME);

        // When
        List<String[]> csvBody = IzicapCsvUtils.readAllLines(CSV_FILE_NAME);

        // Then
        assertEquals(2, csvBody.size());
    }
}