package wra_rest_client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import fr.upec.esiag.m2.easyes.wra.model.prod.MedicalAct;
import fr.upec.esiag.m2.easyes.wra.model.prod.Organization;
import fr.upec.esiag.m2.easyes.wra.model.prod.Patient;
import fr.upec.esiag.m2.pds.easyes.wra.client_rest.ProdToStaging;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.MedicalActDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.OrganizationDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.PatientDao;
import fr.upec.esiag.m2.pds.easyes.wra.server.WraRestServer;
import mockit.Mocked;
public class ProdToStagingTest {
	

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
		 * Spring rest client
		 */
		@Mocked
		RestTemplate restTemplate;
		
		static String GET_PATIENT = "http://localhost:8081/wra_webApp_api/getPatient";
		
		/**
		 * 
		 */
		@Before
		public void init() {
			patient= new Patient();
			patientDao= new PatientDao();
			medicalActDao= new MedicalActDao();
			organizationDao = new OrganizationDao();
			restTemplate= new RestTemplate();
			
			
		}

		WraRestServer wraRestServer = new WraRestServer();
		ProdToStaging prodToStaging = new ProdToStaging();
		/**
		 * test of data fetched method
		 * 
		 */
		@Test
		public void testDataFetched() {
			for (int i =0; i<10;i++){
			 assertEquals(Integer.parseInt(prodToStaging.dataFetched(GET_PATIENT).get(i).get("id").toString()),wraRestServer.listPatient().get(i).getId());
		}
		}
		
		
	}



