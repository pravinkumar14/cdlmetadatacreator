package com.philips.mr.metadatacreator.metadatatemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.philips.mr.metadatacreator.configuration.Configuration;
import com.philips.mr.metadatacreator.constants.Constants;
import com.philips.mr.metadatacreator.utility.FilePathRetriever;

public class CreateMetadataTemplate {
	@SuppressWarnings("unchecked")
	public static JSONObject createMetadataJsonTemplate(Configuration config) {
		JSONObject jsonMetadata = new JSONObject();
		List<String> filePathList = new ArrayList<String>();
		filePathList = FilePathRetriever.obtainFilePathsInFolder(new File(config.getLocalDirectoryPath()), config);
		if(filePathList.size() > 0) {
			JSONObject metadataJsonObject = new JSONObject();
			metadataJsonObject.put(Constants.KEYMODALITY, config.getModalityValue());
			metadataJsonObject.put(Constants.KEYSUBJECT, config.getSubject());
			metadataJsonObject.put(Constants.KEYUPLOADTYPE, config.getUploadType());
			JSONObject referenceJsonObject = new JSONObject();
			JSONObject cdlSubjectJsonObject = new JSONObject();
			cdlSubjectJsonObject.put(Constants.KEYVALUE, config.getCdlSubjectValue());
			cdlSubjectJsonObject.put(Constants.KEYTYPE, config.getCdlSubjectType());
			referenceJsonObject.put(Constants.KEYCDLSUBJECT, cdlSubjectJsonObject);
			Map<String, Object> dataObjectJsonObject = new LinkedHashMap<String, Object>();
			dataObjectJsonObject.put(Constants.KEYRESOURCETYPE, config.getResourceTypeValue());
			dataObjectJsonObject.put(Constants.KEYFILES, filePathList);
			dataObjectJsonObject.put(Constants.KEYMETADATA, metadataJsonObject);
			dataObjectJsonObject.put(Constants.KEYREFERENCE, referenceJsonObject);
			JSONArray dataObjectJsonArray = new JSONArray();
			dataObjectJsonArray.add(dataObjectJsonObject);
			JSONObject dataCollectionDataObject = new JSONObject();
			dataCollectionDataObject.put(Constants.KEYDATAOBJECT, dataObjectJsonArray);
			JSONArray dataCollectionJsonArray = new JSONArray();
			dataCollectionJsonArray.add(dataCollectionDataObject);
			jsonMetadata.put(Constants.KEYDATACOLLECTION, dataCollectionJsonArray);
			return jsonMetadata;
		}
		return jsonMetadata;
	}
}
