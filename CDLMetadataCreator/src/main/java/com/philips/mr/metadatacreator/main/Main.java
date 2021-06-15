package com.philips.mr.metadatacreator.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.philips.mr.metadatacreator.configuration.Configuration;
import com.philips.mr.metadatacreator.constants.Constants;
import com.philips.mr.metadatacreator.jsonwriter.JsonWriter;
import com.philips.mr.metadatacreator.metadatatemplate.CreateMetadataTemplate;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		Configuration config = null;
		Main main = new Main();
		Properties prop = main.getProperties();
		config = setConfiguration(prop);
		JSONObject jsonMetadata = CreateMetadataTemplate.createMetadataJsonTemplate(config);
		if(jsonMetadata.size() > 0)
			JsonWriter.writeToJsonFile(config, jsonMetadata);
	}
	
	public Properties getProperties() {
		Properties prop = null;
		try {
			InputStream is = getClass().getResourceAsStream("/config.properties");
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			logger.info("The config file couldn't be read due to "+e.getMessage());
		}
		return prop;
	}
	
	public static Configuration setConfiguration(Properties prop) {
		Configuration config = new Configuration();
		config.setLocalDirectoryPath(prop.getProperty(Constants.LOCALDIRECTORY));
		config.setModalityValue(prop.getProperty(Constants.MODALITYVALUE));
		config.setResourceTypeValue(prop.getProperty(Constants.KEYRESOURCETYPE));
		config.setMetadataFileName(prop.getProperty(Constants.METADATAFILENAME));
		config.setSubject(prop.getProperty(Constants.SUBJECT));
		config.setUploadType(prop.getProperty(Constants.UPLOADTYPE));
		config.setCdlSubjectType(prop.getProperty(Constants.CDLSUBJECTTYPE));
		config.setCdlSubjectValue(prop.getProperty(Constants.CDLSUBJECTVALUE));
		return config;
	}
}
