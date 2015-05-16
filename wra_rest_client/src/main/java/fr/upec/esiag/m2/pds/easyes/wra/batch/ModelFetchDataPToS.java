package fr.upec.esiag.m2.pds.easyes.wra.batch;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

/**
 * Model class for fetching data from server with spring rest client  (RestTemplate)
 * @author Glawdys
 *
 */
public class ModelFetchDataPToS  {
		
	/**
	 * RestTemplate to fetch json data from server side
	 */
	private RestTemplate restTemplate;
	/**
	 * Method to get list of data sent by the server
	 * @param <T>
	 * @param uri
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<LinkedHashMap> getDataFromProdDB(String uri,Class<T> clazz){
		
		   List<LinkedHashMap> dataFetched = new ArrayList <LinkedHashMap>();
		   dataFetched =restTemplate.getForObject(uri, List.class);
		   return dataFetched;
		
		
		
	}


	

}
