package fr.upec.esiag.m2.easyes.wra.model;

public class Address extends AbstractEntity {	
	/**
	 * Street Number of the Address
	 */
	private String streetNumber;
	/**
	 * Street Type of the Address
	 */
	private String streetType;
	/**
	 * Street Name of the Address
	 */
	private String streetName;
	/**
	 * Region/Province/State of the Address
	 */
	private String region;
	/**
	 * Zip Code of the Address
	 */
	private String zipCode;
	/**
	 * City of the Address
	 */
	private String city;
	/**
	 * Owner of the adress
	 */
	private Person person;
	
	
	public String getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(String streetNumber) {
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
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
