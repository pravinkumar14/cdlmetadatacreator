# cdlmetadatacreator
1. Import this as Maven project
2. Update config.properties present in src/main/resources accordingly
   - localDirPath: The path to the parent folder that needs to be uploaded
   - resourceType: Update this field according to the desired mode of processing.
                   DICOM if standard way of processing
		   DICOMStaging / other resourceTypes if custom way of processing
   - metadataFileName: Name of the metadata. Mostly it is cdlmetadata.json
   - modalityValue: This is based on the modality of the project (MR/DXR etc.)
   - subject: This could be any value preferably the name of the folder to be uploaded.
              This is useful when querying the data.
   - uploadType: This is usually 'Standard' or 'Custom' to denote the way of processing
   - cdlSubjectType: Usually it is 'Patient'
   - cdlSubjectValue: The value or Patient Id.

Note: After the upload of data, create a patient with id same as cdlSubjectValue under 'Upload' tab.
Once the patient is created and if the upload is successful, the uploaded objects can be viewed/downloaded under 
'Study Browser' tab by clicking on the patient id created.
