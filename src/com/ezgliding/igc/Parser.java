package com.ezgliding.igc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {

	/** A date formatter to parse B record times. */
	private static DateFormat dateFormat = new SimpleDateFormat("HHmmss");

	public Parser() {

	}

	public Flight parse(Path location) throws IOException, ParseException {
		BufferedReader reader;
		try {
			reader = Files.newBufferedReader(location, Charset.defaultCharset());
		} catch (IOException e) { 
			throw new IOException("Failed to open location: " + location + "\n" + e);

		}

		String content = "", line;
		try {
			while ((line = reader.readLine()) != null)
				content += line + "\n";
		} catch (IOException e) { 
			throw new IOException("Error reading file: " + location + "\n" + e);
		}

		return parse(content);
	}

	public Flight parse(String content) throws ParseException {
		if (content == null) return null;

		Flight flight = new Flight();

		String[] lines = content.split("\n");
		for (String line: lines)
			parseLine(line, flight);

		return flight;
	}	

	private void parseLine(String line, Flight flight) throws ParseException {
		if (line == null || flight == null) return;

		char type = line.charAt(0);
		switch(type) {
			case 'B': 
				parseB(line, flight);
				break;
			default: break;
		}
	}

	private void parseB(String line, Flight flight) throws ParseException {
		if (line == null || flight == null) return;

		Fix fix = new Fix(
			dateFormat.parse(line.substring(1,7)),
			Util.minDec2decimal(line.substring(7,15)),
			Util.minDec2decimal(line.substring(15,24)),
			Integer.parseInt(line.substring(25,30)),
			Integer.parseInt(line.substring(30,35)),
			line.charAt(24)
		);
		flight.addFix(fix);
	}
}
