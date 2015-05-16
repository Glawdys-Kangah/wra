package fr.upec.esiag.m2.pds.easyes.wra.server;



import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.upec.esiag.m2.easyes.wra.model.ParseDate;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod.MedicalActDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod.OrgaTypeDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod.OrganizationDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod.PatientDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod.ServiceDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod.TypeActDao;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.Hospital;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.MedicalAct;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.OrgaType;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.Organization;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.Patient;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.Service;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.TypeAct;

@RestController
/**
 * Rest server class which load all the data from the production table
 * @author Glawdys
 *
 */
public class WraRestServer {

	private PatientDao patientDao = new PatientDao();
	private OrganizationDao organizationDao = new OrganizationDao();
	private MedicalActDao medicalDao = new MedicalActDao();
	private TypeActDao typeActDao = new TypeActDao();
	private ServiceDao serviceDao = new ServiceDao();
	private OrgaTypeDao orgaTypeDao = new OrgaTypeDao();
    private static final Logger logger = Logger.getLogger(WraRestServer.class);


	private ParseDate parserDate = new ParseDate();


	//**************************************Patient section******************************************************//
	@RequestMapping(value = "/getPatient/{startDate}/{endDate}", 	
			method = RequestMethod.GET)
	/**
	 * List of patient adding between to date
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Patient> listPatientDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		Date stDate = parserDate.parseFormatDateWithHyphen(startDate);
		Date enDate = parserDate.parseFormatDateWithHyphen(endDate);
		return patientDao.getAllByDate(stDate, enDate);
	}


	/**
	 * Get all the list of patient
	 * @return
	 */
	@RequestMapping(value = "/getPatient", 	
			method = {RequestMethod.POST,RequestMethod.GET})

	public List<Patient> listPatient() {
		return patientDao.getAll();
	}

	@RequestMapping(value="/getPatientUpdated", method = RequestMethod.GET)
	public List<Patient> listPatientUpdated(){
		return patientDao.getAllByUpdate();

	}

	//************************************Organization section*************************************************//

	@RequestMapping(value = "/getOrganization/{startDate}/{endDate}", 	
			method = RequestMethod.GET)
	/**
	 * List of organization adding between to date
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Organization> listOrganizationDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		Date stDate = parserDate.parseFormatDateWithHyphen(startDate);
		Date enDate = parserDate.parseFormatDateWithHyphen(endDate);

		return organizationDao.getAllByDate(stDate, enDate);
	}

	@RequestMapping(value = "/getOrganization", 	
			method = RequestMethod.GET)
	/**
	 * Get all the list of organization
	 * @return
	 */
	public List<Organization> listOrganization() {
		return organizationDao.getAll();
	}

	@RequestMapping(value="/getOrganizationUpdated", method = RequestMethod.GET)
	public List<Organization> listOrganizationUpdated(){
		return organizationDao.getAllByUpdate();

	}



	@RequestMapping(value = "/getOrgaType", 	
			method = RequestMethod.GET)
	/**
	 * Get all the list of organization
	 * @return
	 */
	public List<OrgaType> listOrgaType() {
		return orgaTypeDao.getAll();
	}




	//Start --Not necessary 
	@RequestMapping(value="/getHospital", method = RequestMethod.GET)
	/**
	 * Get all the list of hospital
	 * @return list of hospital
	 */
	public List<Hospital> listHospital(){
		return organizationDao.getAllByType(Hospital.class);

	}
	@RequestMapping(value = "/getHospital/{startDate}/{endDate}", 	
			method = RequestMethod.GET)
	public List<Hospital> listHospitalDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate")String endDate){
		Date stDate = parserDate.parseFormatDateWithHyphen(startDate);
		Date enDate = parserDate.parseFormatDateWithHyphen(endDate);
		return organizationDao.getAllByTypeByDate(Hospital.class, stDate, enDate);

	}
	//End -- Not necessary

	//****************************************Medical Act and Type act section**********************************//

	@RequestMapping(value = "/getMedicalAct/{startDate}/{endDate}", 	
			method = RequestMethod.GET )
	/**
	 * List of medicalAct adding between to date
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<MedicalAct> listMedicalActDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		Date stDate = parserDate.parseFormatDateWithHyphen(startDate);
		Date enDate = parserDate.parseFormatDateWithHyphen(endDate);
		return medicalDao.getAllByDate(stDate, enDate);
	}

	@RequestMapping(value = "/getMedicalAct", 	
			method = RequestMethod.GET)
	/**
	 * Get all the list of medical act
	 * @return
	 */
	public List<MedicalAct> listMedicalAct() {
		return medicalDao.getAll();
	}

	@RequestMapping(value="/getMedicalActUpdated", method = RequestMethod.GET)
	public List<MedicalAct> listMedicalActUpdated(){
		return medicalDao.getAllByUpdate();

	}



	@RequestMapping(value = "/getTypeAct", 	
			method = RequestMethod.GET)
	/**
	 * Get all the list of type of act
	 * @return
	 */
	public List<TypeAct> listTypeAct() {
		return typeActDao.getAll();
	}



	//****************************************Service section***********************************************//

	@RequestMapping(value = "/getService/{startDate}/{endDate}", 	
			method = RequestMethod.GET)
	/**
	 * List of service adding between to date
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Service> listServiceDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		Date stDate = parserDate.parseFormatDateWithHyphen(startDate);
		Date enDate = parserDate.parseFormatDateWithHyphen(endDate);
		return serviceDao.getAllByDate(stDate, enDate);
	}

	@RequestMapping(value = "/getService", 	
			method = RequestMethod.GET)
	/**
	 * Get all the list of type of act
	 * @return
	 */
	public List<Service> listService() {
		return serviceDao.getAll();
	}

	@RequestMapping(value="/getServiceUpdated", method = RequestMethod.GET)
	public List<Service> listServiceUpdated(){
		return serviceDao.getAllByUpdate();

	}

	//****************************************Health Path section***********************************************//
	/*
	 *//**
	 * @param startDate
	 * @param endDate
	 * @return
	 *//*
	@RequestMapping(value = "/getHeathPath/{startDate}/{endDate}", 	
			method = RequestMethod.GET)
	  *//**
	  * List of service adding between to date
	  * @param startDate
	  * @param endDate
	  * @return
	  *//*
	public List<HealthPath> listHealthPathDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		Date stDate = parserDate.parseFormatDateWithHyphen(startDate);
		Date enDate = parserDate.parseFormatDateWithHyphen(endDate);
		return healthPathDao.getAllByDate(stDate, enDate);
	}

	@RequestMapping(value = "/getHealthPath", 	
			method = RequestMethod.GET)
	   *//**
	   * Get all the list of type of act
	   * @return
	   *//*
	public List<HealthPath> listHealthPath() {
		return healthPathDao.getAll();
	}

	@RequestMapping(value="/getHealthPathUpdated", method = RequestMethod.GET)
	public List<HealthPath> listHealthPathUpdated(){
		return healthPathDao.getAllByUpdate();

	}*/

}
