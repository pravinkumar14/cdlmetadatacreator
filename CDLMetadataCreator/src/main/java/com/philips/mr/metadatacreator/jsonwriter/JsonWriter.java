package com.philips.mr.metadatacreator.jsonwriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;


import com.philips.mr.metadatacreator.configuration.Configuration;

public class JsonWriter {
	private static Logger logger = Logger.getLogger(JsonWriter.class);
	
	public static void writeToJsonFile(Configuration config, JSONObject jsonData) {
		String folderPath = config.getLocalDirectoryPath();
		String jsonMetadataFilePath = "";
		Pattern p = Pattern.compile("\\\\");
		Matcher m = p.matcher(folderPath);
		if(m.find()) {
			jsonMetadataFilePath = folderPath+"\\"+config.getMetadataFileName();
		}
		else {
			jsonMetadataFilePath = folderPath+"/"+config.getMetadataFileName();
		}
		File directory = new File(folderPath);
   		if(!directory.exists()) {
   			logger.info("Directory doesn't exist. Exiting...");
   			return;
   		}
   		else {
   			try {
   				@SuppressWarnings("resource")
   				FileWriter fileWriter = new FileWriter(jsonMetadataFilePath, false);
   				fileWriter.write(jsonData.toJSONString());
   				fileWriter.flush();
   				logger.info("Successfully created "+config.getMetadataFileName()+ " at "+jsonMetadataFilePath);
   			} catch (IOException e) {
   				logger.info("Writing to Json metadata failed due to "+e.getMessage());
   			}
   		}
	}
}
