package fr.upec.esiag.m2.pds.easyes.wra.client_rest;

import org.easybatch.core.api.EasyBatchReport;
import org.easybatch.core.impl.EasyBatchEngine;
import org.easybatch.core.impl.EasyBatchEngineBuilder;


public class StartClient {

	  public static void main(String args[]){
	    	EasyBatchEngine easyBatchEngine = new EasyBatchEngineBuilder()
			  .registerRecordReader(new ProdToStaging())
			  .build();
			EasyBatchReport easyBatchReport = easyBatchEngine.call();
			System.out.println(easyBatchReport);
	    }
}
