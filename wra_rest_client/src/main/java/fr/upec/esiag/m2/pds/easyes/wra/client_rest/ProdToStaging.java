package fr.upec.esiag.m2.pds.easyes.wra.client_rest;



import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import fr.upec.esiag.m2.easyes.wra.model.Address;
import fr.upec.esiag.m2.easyes.wra.model.prod.Patient;
import fr.upec.esiag.m2.pds.easyes.wra.batch.ModelFetchDataPToS;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.PatientDao;

import org.easybatch.core.api.*;
import org.springframework.web.client.RestTemplate;

public class ProdToStaging implements RecordReader {
	private ModelFetchDataPToS modelFetch = new ModelFetchDataPToS();
	private PatientDao patientDao = new PatientDao();
	public static final String GET_PATIENT = "http://localhost:8081/wra_webApp_api/getPatient";
	private RestTemplate restTemplate = new RestTemplate();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getPatientData(){
		List<LinkedHashMap> patientData = new ArrayList<LinkedHashMap>();
		patientData = restTemplate.getForObject(GET_PATIENT,List.class);
		for(LinkedHashMap lhm : patientData){
			System.out.println(lhm.get("firstName").toString());
        	Patient patient = new Patient();
        	
        	patient.setFirstName(lhm.get("firstName").toString());
        	/*patient.setBirthdate((Date)lhm.get("birthdate"));
        	patient.setAddress((Address)lhm.get("address"));
        	patient.setCreateDate((Date)lhm.get("createDate"));
        	patient.setUpdateDate((Date)lhm.get("updateDate"));
        	patient.setId((Integer)lhm.get("id"));
        	patient.setGender((Character)lhm.get("gender"));
        	patient.setIdOrganization((Integer)lhm.get("idOrganisation"));
        	patient.setLastName(lhm.get("lastName").toString());
        	patient.setNir(lhm.get("nir").toString());
*/			patientDao.addPatient(patient);	
		}
		
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDataSourceName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotalRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNextRecord() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void open() throws Exception {
		getPatientData();
		
	}

	@Override
	public Record readNextRecord() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
