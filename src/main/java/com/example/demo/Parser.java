package com.example.demo;

import com.example.demo.entity.Genre;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static void parseGenre() throws IOException, CsvException {

        ObjectMapper objectMapper = new ObjectMapper();

        CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Администратор\\Downloads\\final_tmdb_5000_movies.csv"));
        String[] nextRecord;
        ArrayList<String> genreRecord = new ArrayList<>();
        boolean first = true;
        while ((nextRecord = csvReader.readNext()) != null) {
            String genreString = nextRecord[1]; // 1 - жанры
            try {// Преобразование строки JSON в JSONArray
                JSONArray jsonArray = new JSONArray(genreString);

                // Обработка каждого элемента массива
                for (int i = 0; i < jsonArray.length(); i++) { // массиив жанров одного фильма
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    // Извлечение значений из объекта
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.getString("name");
                    // Вывод результатов
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(genreRecord.toString());
    }

    public static void parseString() throws IOException, CsvException {
        String jsonString = "[{\"id\": 18, \"name\": \"Drama\"}, {\"id\": 35, \"name\": \"Comedy\"}, {\"id\": 10749, \"name\": \"Romance\"}]";

        try {// Преобразование строки JSON в JSONArray
            JSONArray jsonArray = new JSONArray(jsonString);

            // Обработка каждого элемента массива
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Извлечение значений из объекта
                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");

                // Вывод результатов
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseCheck() throws IOException, CsvException {
        ObjectMapper objectMapper = new ObjectMapper();

        CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Администратор\\Downloads\\final_tmdb_5000_movies.csv"));
        String[] nextRecord;
        boolean first = true;
        while ((nextRecord = csvReader.readNext()) != null) {
            System.out.println(nextRecord[1]);
        }
    }


}
