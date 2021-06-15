package com.philips.mr.metadatacreator.configuration;

public class Configuration {
	private String localDirectoryPath;
	private String resourceTypeValue;
	private String modalityValue;
	private String metadataFileName;
	private String subject;
	private String uploadType;
	private String cdlSubjectValue;
	private String cdlSubjectType;
	
	
	
	public String getUploadType() {
		return uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	public String getCdlSubjectValue() {
		return cdlSubjectValue;
	}

	public void setCdlSubjectValue(String cdlSubjectValue) {
		this.cdlSubjectValue = cdlSubjectValue;
	}

	public String getCdlSubjectType() {
		return cdlSubjectType;
	}

	public void setCdlSubjectType(String cdlSubjectType) {
		this.cdlSubjectType = cdlSubjectType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMetadataFileName() {
		return metadataFileName;
	}

	public void setMetadataFileName(String metadataFileName) {
		this.metadataFileName = metadataFileName;
	}

	public String getModalityValue() {
		return modalityValue;
	}

	public void setModalityValue(String modalityValue) {
		this.modalityValue = modalityValue;
	}

	public String getResourceTypeValue() {
		return resourceTypeValue;
	}

	public void setResourceTypeValue(String resourceTypeValue) {
		this.resourceTypeValue = resourceTypeValue;
	}

	public String getLocalDirectoryPath() {
		return localDirectoryPath;
	}

	public void setLocalDirectoryPath(String localDirectoryPath) {
		this.localDirectoryPath = localDirectoryPath;
	}
}
