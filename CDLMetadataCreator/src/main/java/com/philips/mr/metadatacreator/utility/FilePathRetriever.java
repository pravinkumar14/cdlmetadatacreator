package com.philips.mr.metadatacreator.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.philips.mr.metadatacreator.configuration.Configuration;

public class FilePathRetriever {
	private static Logger logger = Logger.getLogger(FilePathRetriever.class);
	static List<String> filePathList = new ArrayList<String>();
	
	public static List<String> obtainFilePathsInFolder(File directory, Configuration config) {
		String localDirPath = config.getLocalDirectoryPath();
		if(!directory.exists()) {
			logger.info("The given directory is not found. Exiting...");
		}
		else {
			File [] listOfFiles = directory.listFiles();
			for (File file:listOfFiles) {
				if(file.isDirectory()) {
					obtainFilePathsInFolder(file, config);
				}
				else {
					filePathList.add(file.getPath().substring(localDirPath.length()+1, file.getPath().length()).toString().replaceAll("\\\\", "/"));
				}
			}
		}
		return filePathList;
	}
}
