package fr.upec.esiag.m2.pds.easyes.wra.client_rest;

import org.easybatch.core.api.AbstractRecordProcessor;

import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag.PatientReceptionDao;
import fr.upec.esiag.m2.pds.easyes.wra.model.stag.PatientReception;
/**
 * Temporary class to add date for patient reception (unexisting table in production database)
 * @author Glawdys
 *
 */
public class PatientReceptionDataLoaderTemp extends AbstractRecordProcessor<PatientReception> {


    public void processRecord(final PatientReception patientR) {
    	PatientReceptionDao patientRDao = new PatientReceptionDao();
    	patientRDao.addPatientReception(patientR);
          
        
    }
}
