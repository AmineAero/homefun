package fr.izicap.siret.izicap;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TestUtils {

    public static List<String[]> readAllLinesFromCsvFile(String csvFileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(csvFileName));
        List<String[]> allLines = reader.readAll();
        reader.close();
        return allLines;
    }

    public static void deleteTestFile(String fileToDelete){
        File file = new File(fileToDelete);
        file.delete();
    }
}
