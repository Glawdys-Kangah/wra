package wra_webApp_api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod.MedicalActDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod.OrganizationDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod.PatientDao;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.MedicalAct;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.Organization;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.Patient;
import fr.upec.esiag.m2.pds.easyes.wra.server.WraRestServer;
import mockit.Mocked;

/**
 * Test class for REST SERVER UNIT TEST
 * @author Glawdys
 *
 */
public class WraRestServerTest {
/**
 * PATIENT DAO MOCK
 */
	@Mocked
	PatientDao patientDao;
	/**
	 * PATIENT MOCK
	 */
	@Mocked
	Patient patient;
	/**
	 * ORGANIZATION DAO MOCK
	 */
	@Mocked
	OrganizationDao organizationDao;
	/**
	 * ORGANIZATION MOCK
	 */
	@Mocked
	Organization organization;
	/**
	 * MEDICAL DAO MOCK
	 */
	@Mocked
	MedicalActDao medicalActDao;
	/**
	 * MEDICAL ACT MOCK
	 */
	@Mocked
	MedicalAct medicalAct;
	
	/**
	 * 
	 */
	@Before
	public void init() {
		patient= new Patient();
		patientDao= new PatientDao();
		medicalActDao= new MedicalActDao();
		organizationDao = new OrganizationDao();
		
	}

	WraRestServer wraRestServer = new WraRestServer();
	/**
	 * get patient list from prod BD 
	 * 
	 */
	//I've take only the 10 first patient because it's too long to execute
	@Test
	public void testGetAllPatient() {
		for (int i =0; i<10;i++){
		 assertEquals(wraRestServer.listPatient().get(i).getId(),patientDao.getAll().get(i).getId());
	}
	}
	/**
		 * get Organization list from prod BD 
		 * 
		 */
		//I've take only the 10 first organizationt because it's too long to execute
		@Test
		public void testGetAllOrganization() {
			for (int i =0; i<10;i++){
			 assertEquals(wraRestServer.listOrganization().get(i).getSiret(),organizationDao.getAll().get(i).getSiret());
		}
		
	
	}
		/**
		 * get medical act list from prod BD 
		 * 
		 */
		//I've take only the 10 first medicalAct because it's too long to execute
		@Test
		public void testGetAllMedicalAct() {
			for (int i =0; i<10;i++){
			 assertEquals(wraRestServer.listMedicalAct().get(i).getId(),medicalActDao.getAll().get(i).getId());
		}
			
	}
	
}
