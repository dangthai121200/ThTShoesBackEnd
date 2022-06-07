package com.herokuapp.readjson;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {

	public static void main(String[] args) {
		try {
			// create object mapper instance
			ObjectMapper mapper = new ObjectMapper();

			// convert JSON array to list of books
			List<JsonGiay> books = Arrays.asList(mapper.readValue(
					Paths.get("D:\\School\\LuanVanTotNghiep\\page\\Shoe-store-data-json-master\\data001.json").toFile(),
					JsonGiay[].class));

			// print books
			books.forEach(System.out::println);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
