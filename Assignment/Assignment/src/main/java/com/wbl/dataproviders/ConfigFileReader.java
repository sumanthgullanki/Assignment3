package com.wbl.dataproviders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "/Users//Assignment/src/main/java/com/wbl/config/config.properties";

	public ConfigFileReader() {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Properties getProperties() {
		return properties;
	}
}
