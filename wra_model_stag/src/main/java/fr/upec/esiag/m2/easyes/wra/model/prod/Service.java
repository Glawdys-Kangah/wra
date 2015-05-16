package fr.upec.esiag.m2.easyes.wra.model.prod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import fr.upec.esiag.m2.easyes.wra.model.AbstractEntity;

/**
 * Service class from easyessoft
 * @author Glawdys
 *
 */
public class Service extends AbstractEntity {
	/**
	 * The id of the organization in which the service is provided 
	 */
	private int idOrganizaton;
	/**
	 * The id of the ServiceType provided 
	 */
	private int idServiceTypeCurrent;
	/**
	 * The ids of services selected by user input 
	 */
	private ArrayList<Integer> listIdTypeOfServices= new ArrayList<Integer>();
	/**
	 * The set of Service types selected by the user  
	 */
	private Set<ServiceType> services = new HashSet<ServiceType>();
	
	public int getIdOrganizaton() {
		return idOrganizaton;
	}
	public void setIdOrganizaton(int idOrganizaton) {
		this.idOrganizaton = idOrganizaton;
	}
	public int getIdServiceTypeCurrent() {
		return idServiceTypeCurrent;
	}
	public void setIdServiceTypeCurrent(int idServiceTypeCurrent) {
		this.idServiceTypeCurrent = idServiceTypeCurrent;
	}
	public ArrayList<Integer> getListIdTypeOfServices() {
		return listIdTypeOfServices;
	}
	public void setListIdTypeOfServices(ArrayList<Integer> listIdTypeOfServices) {
		this.listIdTypeOfServices = listIdTypeOfServices;
	}
	public Set<ServiceType> getServices() {
		return services;
	}
	public void setServices(Set<ServiceType> services) {
		this.services = services;
	}
	


}
