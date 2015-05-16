package fr.upec.esiag.m2.easyes.wra.model.prod;

import java.util.HashSet;
import java.util.Set;

import fr.upec.esiag.m2.easyes.wra.model.AbstractEntity;

/**
 * 
 * Model of an organization
 *
 */
public class Organization extends AbstractEntity {

	
	private String name;
	
	private String siret;
	
	private int streetNumber;
	
	private String streetType;
	
	private String streetName;
	
	private String zipCode;


	private String city;


	private String department;


	private String phone;


	private String fax;
	

	private String email;
	
	private String legalStatus;
	
	private Float latitude;
	
	private Float longitude;
	
	private OrgaType orgaType;

	private Set<ServiceType> servicesSet = new HashSet<ServiceType>(0);

	public Set<ServiceType> getServicesSet() {
		return servicesSet;
	}

	public void setServicesSet(Set<ServiceType> servicesSet) {
		this.servicesSet = servicesSet;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetType() {
		return streetType;
	}
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLegalStatus() {
		return legalStatus;
	}
	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
	public OrgaType getOrgaType() {
		return orgaType;
	}

	public void setOrgaType(OrgaType orgaType) {
		this.orgaType = orgaType;
	}
	
}
