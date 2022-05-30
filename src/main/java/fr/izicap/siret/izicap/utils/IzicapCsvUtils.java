package fr.izicap.siret.izicap.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class IzicapCsvUtils {

    public static void writeAll(List<String[]> linesList, String path) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(path),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.NO_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        writer.writeAll(linesList);
        writer.flush();
        writer.close();
    }

    public static void addOneLine(String[] lineToAdd, String path) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(path, true),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.NO_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        writer.writeNext(lineToAdd);
        writer.flush();
        writer.close();
    }

    public static List<String[]> readAllLines(String path) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(path));
        List<String[]> csvBody = reader.readAll();
        reader.close();
        return csvBody;
    }
}
