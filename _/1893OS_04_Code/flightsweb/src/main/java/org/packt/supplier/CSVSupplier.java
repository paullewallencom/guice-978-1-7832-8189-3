package org.packt.supplier;

import static org.packt.utils.FlightUtils.parseDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Set;
import java.util.TreeSet;

import au.com.bytecode.opencsv.CSVReader;

public class CSVSupplier implements FlightSupplier{
	Set<SearchRS> searchResponses = new TreeSet<SearchRS>();

	private File csvFolder;
	
	public File getCsvFolder() {
		return csvFolder;
	}

	public void setCsvFolder(File csvFolder) {
		this.csvFolder = csvFolder;
	}

	public CSVSupplier() {
	
	}

	public Set<SearchRS> getResults() {
		if(searchResponses.isEmpty()){
			loadCSVFiles();
		}
		return searchResponses;
	}

	private void loadCSVFiles() {

		File[] listOfFiles = csvFolder.listFiles();
		int counter = 0;
		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				File file = listOfFiles[i];
				if (file.getName().endsWith(".csv") || file.getName().endsWith(".CSV")) {
					CSVReader reader;
					
					try {
						reader = new CSVReader(new FileReader(file));
						String[] nextLine;

						while ((nextLine = reader.readNext()) != null) {

							SearchRS flightSearchRS = new SearchRS();

							flightSearchRS.setFlightNumber(nextLine[0]);
							flightSearchRS.setDepartureLocation(nextLine[1]);
							flightSearchRS.setArrivalLocation(nextLine[2]);
							flightSearchRS.setValidDate(parseDate(nextLine[3]));
							flightSearchRS.setDepartTime(nextLine[4]);
							flightSearchRS.setFlightDuration(Double
									.parseDouble(nextLine[5]));
							flightSearchRS.setFare(Float
									.parseFloat(nextLine[6]));
							searchResponses.add(flightSearchRS);

							counter++;
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ParseException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

}
