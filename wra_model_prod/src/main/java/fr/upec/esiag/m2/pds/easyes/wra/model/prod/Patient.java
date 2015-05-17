package fr.upec.esiag.m2.pds.easyes.wra.model.prod;

import fr.upec.esiag.m2.easyes.wra.model.Person;


public class Patient extends Person{

	/**
	 * Social security number of patient 
	 */
	private String nir; 
	/** 
	 * Medical Record of patient
	 */
	//private MedicalRecord medicalRecord;
	/**
	 * RPPS of the Phone Number Work
	 */
	private String phoneNumberHome;
	/**
	 * RPPS of the Phone Number Mobile
	 */
	private String phoneNumberMobile;
	/**
	 * RPPS of the Mail adress
	 */
	private String mailAdress;
	
	private int idOrganization;
	
	private int idHospital;
	
	
	public String getNir() {
		return nir;
	}
	public void setNir(String nir) {
		this.nir = nir;
	}

	public String getPhoneNumberHome() {
		return phoneNumberHome;
	}
	public void setPhoneNumberHome(String phoneNumberHome) {
		this.phoneNumberHome = phoneNumberHome;
	}
	public String getPhoneNumberMobile() {
		return phoneNumberMobile;
	}
	public void setPhoneNumberMobile(String phoneNumberMobile) {
		this.phoneNumberMobile = phoneNumberMobile;
	}
	public String getMailAdress() {
		return mailAdress;
	}
	
	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}
	public int getIdOrganization() {
		return idOrganization;
	}
	public void setIdOrganization(int idOrganization) {
		this.idOrganization = idOrganization;
	}
	public int getIdHospital() {
		return idHospital;
	}
	public void setIdHospital(int idHospital) {
		this.idHospital = idHospital;
	}

}
