package fr.upec.esiag.m2.pds.easyes.wra.client_rest;

import org.easybatch.core.api.EasyBatchReport;
import org.easybatch.core.impl.EasyBatchEngine;
import org.easybatch.core.impl.EasyBatchEngineBuilder;
import org.easybatch.flatfile.FlatFileRecordReader;
import org.easybatch.flatfile.dsv.DelimitedRecordMapper;

import fr.upec.esiag.m2.pds.easyes.wra.model.stag.PatientReception;

/**
 * Temporary class , to remove after the implementation on batch
 * @author Glawdys
 *
 */
public class StartClient {
	/**
	 * Main method to start the client (temporary)
	 * @param args
	 */
	public static void main(String args[]){
		//First easybatch engine which load data from server
		EasyBatchEngine easyBatchEngine = new EasyBatchEngineBuilder()
		.registerRecordReader(new ProdToStaging())
		.build();
		EasyBatchReport easyBatchReport = easyBatchEngine.call();
		System.out.println(easyBatchReport);

		/* second easybatch engine which load data from csv file for unexisting data from 
			production database*/
		/*@SuppressWarnings("rawtypes")
		EasyBatchEngine easyBatchCsvEngine = new EasyBatchEngineBuilder()
        .registerRecordReader(new FlatFileRecordReader("patientReception.csv")
        .registerRecordMapper(new DelimitedRecordMapper(PatientReception.class, new String[]{"id","name"}))
        .registerRecordProcessor(new PatientReceptionDataLoaderTemp())
        .build();*/

	}
}
