package fr.upec.esiag.m2.pds.easyes.wra.client_rest;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

import fr.upec.esiag.m2.easyes.wra.model.prod.MedicalAct;
import fr.upec.esiag.m2.easyes.wra.model.prod.OrgaType;
import fr.upec.esiag.m2.easyes.wra.model.prod.Organization;
import fr.upec.esiag.m2.easyes.wra.model.prod.Patient;
import fr.upec.esiag.m2.easyes.wra.model.prod.Service;
import fr.upec.esiag.m2.easyes.wra.model.prod.ServiceType;
import fr.upec.esiag.m2.easyes.wra.model.prod.TypeAct;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.MedicalActDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.OrgaTypeDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.OrganizationDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.PatientDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.ServiceDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.ServiceTypeDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.TypeActDao;

import org.easybatch.core.api.*;
import org.springframework.web.client.RestTemplate;
/**
 * Processor class which fetch data from server and add it to the database following 
 * hibernate mapping
 * @author Glawdys
 *
 */
public class ProdToStaging implements RecordReader {
	/**
	 * Patient dao
	 */
	private PatientDao patientDao = new PatientDao();
	/**
	 * Organization dao
	 */
	private OrganizationDao organizationDao = new OrganizationDao();
	/**
	 * Orga type dao
	 */
	private OrgaTypeDao orgaTypeDao = new OrgaTypeDao();
	/**
	 * Service dao
	 */
	private ServiceDao serviceDao = new ServiceDao();
	/**
	 * MedicalAct dao
	 */
	private MedicalActDao medicalActDao = new MedicalActDao();
	/**
	 * typeAct dao
	 */
	private TypeActDao typeActDao = new TypeActDao();
	/**
	 *  serviceType dao
	 */
	private ServiceTypeDao serviceTypeDao = new ServiceTypeDao();
	/**
	 * Patient uri {getAll}
	 */
	//@todo Add to a properties file
	public static final String GET_PATIENT = "http://localhost:8081/wra_webApp_api/getPatient";
	/**
	 * Organization uri {getAll}
	 */
	//@todo Add to a properties file
	public static final String GET_ORGANIZATION = "http://localhost:8081/wra_webApp_api/getOrganization";
	/**
	 * Orga type uri {getAll}
	 */
	//@todo Add to a properties file
	public static final String GET_ORGA_TYPE = "http://localhost:8081/wra_webApp_api/getOrgaType";
	/**
	 * Medical Act uri {getAll}
	 */
	//@todo Add to a properties file
	public static final String GET_MEDICAL_ACT = "http://localhost:8081/wra_webApp_api/getMedicalAct";

	/**
	 * Type act uri {getAll}
	 */
	//@todo Add to a properties file
	public static final String GET_TYPE_ACT = "http://localhost:8081/wra_webApp_api/getTypeAct";
	/**
	 * Service uri {getAll}
	 */
	//@todo Add to a properties file
	public static final String GET_SERVICE = "http://localhost:8081/wra_webApp_api/getService";
	/**
	 * Service type uri {getAll}
	 */
	//@todo Add to a properties file
	public static final String GET_SERVICE_TYPE = "http://localhost:8081/wra_webApp_api/getServiceType";
	/**
	 * Spring client template to fetch data from server side
	 */
	private RestTemplate restTemplate = new RestTemplate();
	/**
	 * Logger
	 */
	private Logger logger = Logger.getLogger("ProdToStaging.class");

	/**
	 * Method to get all patient data
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getPatientData(){
		List<LinkedHashMap> patientData = new ArrayList<LinkedHashMap>();
		//patientData = restTemplate.getForObject(GET_PATIENT,List.class);
		patientData = dataFetched(GET_PATIENT);
		for(LinkedHashMap lhm : patientData){
			Patient patient = new Patient();
			// Parse data to the right type
			int parseIdHospital = Integer.parseInt(lhm.get("idHospital").toString());
			Character parseGender = lhm.get("gender").toString().charAt(0);
			Date parseBD = stringToDate(lhm.get("birthdate").toString());
			// set patient 
			patient.setBirthdate(parseBD);
			patient.setFirstName(lhm.get("firstName").toString());
			patient.setGender(parseGender);
			patient.setIdHospital(parseIdHospital);
			patient.setLastName(lhm.get("lastName").toString());
			patient.setNir(lhm.get("nir").toString());
			//Add patient to staging database
			patientDao.addPatient(patient);	
		}
	}	

	/**
	 * Method to get organization data
	 */
	@SuppressWarnings("rawtypes")
	public void getOrganizationData(){

		List<LinkedHashMap> organizationData = new ArrayList<LinkedHashMap>();
		organizationData = dataFetched(GET_ORGANIZATION);
		for(LinkedHashMap lhm : organizationData){
			Organization organization = new Organization();
			// Parse data to the right type
			int parseOrgaType = Integer.parseInt(lhm.get("orgaType").toString());
			// set Organization 
			organization.setCity(lhm.get("city").toString());
			organization.setEmail(lhm.get("email").toString());
			organization.setFax(lhm.get("fax").toString());
			organization.setDepartment(lhm.get("department").toString());
			organization.setName(lhm.get("name").toString());
			organization.setOrgaType(parseOrgaType);
			//Add organization to staging database
			organizationDao.addOrganization(organization);	
		}
	}

	/**
	 * Method to get orga type data
	 */
	@SuppressWarnings("rawtypes")
	public void getOrgaTypeData(){

		List<LinkedHashMap> orgaTypeData = new ArrayList<LinkedHashMap>();
		orgaTypeData = dataFetched(GET_ORGA_TYPE);
		for(LinkedHashMap lhm : orgaTypeData){
			OrgaType orgaType= new OrgaType();
			// Parse data to the right type
			// set Orga type
			orgaType.setLegalStatus(lhm.get("legalStatus").toString());
			orgaType.setCode (lhm.get("code").toString());
			orgaType.setLabel(lhm.get("label").toString());

			//Add orga type to staging database
			orgaTypeDao.addOrgaType(orgaType);	
		}
	}
	/**
	 * Method to get medicalAct data
	 */
	@SuppressWarnings("rawtypes")
	public void getMedicalActData(){

		List<LinkedHashMap> medicalActData = new ArrayList<LinkedHashMap>();
		medicalActData = dataFetched(GET_MEDICAL_ACT);
		for(LinkedHashMap lhm : medicalActData){
			MedicalAct medicalAct= new MedicalAct();
			// Parse data to the right type
			int parseActTime= Integer.parseInt(lhm.get("actTime").toString());
			Date createDate = stringToDate(lhm.get("createDate").toString());
			Date updateDate = stringToDate(lhm.get("updateDate").toString());


			// set medical act

			medicalAct.setCodeAct(lhm.get("codeAct").toString());
			medicalAct.setGroupingCode(lhm.get("groupingCode").toString());
			medicalAct.setActTime (parseActTime);
			medicalAct.setCreateDate(createDate);
			medicalAct.setCreateDate(updateDate);
			medicalAct.setExonerationRule(lhm.get("exonerationRule").toString());
			medicalAct.setNameAct(lhm.get("nameAct").toString());

			//Add medical act to staging database
			medicalActDao.addMedicalAct(medicalAct);
		}
	}			
	/**
	 * Method to get type act data
	 */
	@SuppressWarnings("rawtypes")
	public void getTypeActData(){

		List<LinkedHashMap> typeActData = new ArrayList<LinkedHashMap>();
		typeActData = dataFetched(GET_TYPE_ACT);
		for(LinkedHashMap lhm : typeActData){
			TypeAct typeAct= new TypeAct();
			// set type act
			typeAct.setCode (lhm.get("code").toString());
			typeAct.setLabel(lhm.get("label").toString());

			//Add type act to staging database
			typeActDao.addTypeActDao(typeAct);
		}


	}
	
	/**
	 * Method to get service data
	 */
	/*@SuppressWarnings("rawtypes")
	public void getServiceData(){

		List<LinkedHashMap> serviceData = new ArrayList<LinkedHashMap>();
		serviceData = dataFetched(GET_SERVICE);
		for(LinkedHashMap lhm : serviceData){
			Service service= new Service();
			//Parse to the right format
			int parseIdServiceType = Integer.parseInt(lhm.get("idServiceType").toString());
			int parseIdOrga = Integer.parseInt(lhm.get("idOrganizaton").toString());
			int parseIdST = Integer.parseInt(lhm.get("idServiceTypeCurrent").toString());

			Date parseBD = stringToDate(lhm.get("birthdate").toString());
			
			// set type act
			service.setIdServiceType(parseIdServiceType); 
			service.setIdOrganizaton(parseIdOrga);
			service.setIdServiceTypeCurrent(parseIdST);
				//Add type act to staging database
			serviceDao.addService(service);
		}


	}*/
	
	/*@SuppressWarnings("rawtypes")
	public void getServiceTypeData(){

		List<LinkedHashMap> serviceTypeData = new ArrayList<LinkedHashMap>();
		serviceTypeData = dataFetched(GET_SERVICE_TYPE);
		for(LinkedHashMap lhm : serviceTypeData){
			ServiceType serviceType= new ServiceType();
			//Parse to the right format
				
			// set type act
			serviceType.setCategoryService(lhm.get("categoryService").toString());
			serviceType.setCode(lhm.get("code").toString());
				//Add type act to staging database
			serviceTypeDao.addServiceType(serviceType);
		}


	}*/


	/**
	 * Method to get data from server side
	 * @param uri
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<LinkedHashMap> dataFetched (String uri){
		List<LinkedHashMap> data = new ArrayList<LinkedHashMap>();
		return data = restTemplate.getForObject(uri,List.class);
	}
	/**
	 * Method to parse date
	 * @param stringTarget
	 * @return
	 */
	public Date stringToDate(String stringTarget){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date result = null;
		try {
			result = df.parse(stringTarget);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
		getOrgaTypeData();
		getOrganizationData();
		
		 getTypeActData();
		getMedicalActData();
		//getServiceTypeData();
		//getServiceData();
		

	}

	@Override
	public Record readNextRecord() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
