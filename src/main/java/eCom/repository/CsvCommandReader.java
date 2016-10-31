package eCom.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opencsv.CSVReader;

import eCom.Main;
import eCom.factory.DomainCsvFactory;

public class CsvCommandReader<T> {

	private Set<T> list;
	private DomainCsvFactory<T> domainCsvFactory;
	private String file;
	
	CsvCommandReader(String file, DomainCsvFactory<T> domainCsvFactory){
		this.file = file;
		this.list = new HashSet<T>(16);
		this.domainCsvFactory = domainCsvFactory;
	}
	
	public CsvCommandReader<T> loadAll() throws Exception {
		try (InputStream stream = Main.class.getClassLoader().getResourceAsStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				CSVReader csvReader = new CSVReader(reader)) {

			ReadHeader(csvReader);
			String[] nextLine;
			
			while ((nextLine = csvReader.readNext()) != null) {
				list.add(domainCsvFactory.createFromCsvLine(nextLine));
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return this;
	}
	
	public Set<T> getDomainList(){
		return list;
	}
	
	private void ReadHeader(CSVReader csvReader) throws IOException {
		csvReader.readNext();
	}
	
	
}
