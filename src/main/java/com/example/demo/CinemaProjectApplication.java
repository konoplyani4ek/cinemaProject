package com.example.demo;

import com.opencsv.exceptions.CsvException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class CinemaProjectApplication {

	public static void main(String[] args) throws IOException, CsvException {
		SpringApplication.run(CinemaProjectApplication.class, args);

		Parser.parseGenre();
		//Parser.parseString();
		//Parser.parseCheck();
	}

}
