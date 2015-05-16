package fr.upec.esiag.m2.pds.easyes.wra.model.stag;

import java.util.Date;

import fr.upec.esiag.m2.easyes.wra.model.AbstractEntity;
import fr.upec.esiag.m2.easyes.wra.model.prod.Patient;
import fr.upec.esiag.m2.easyes.wra.model.prod.Service;
import fr.upec.esiag.m2.easyes.wra.model.prod.TypeAct;

/**
 * Model class which modeled the reception of a patient
 * @author Glawdys
 *
 */
public class PatientReception extends AbstractEntity{
	
	/**
	 * Type act 
	 */
	private TypeAct typeAct;
	/**
	 * Service where the patient is welcomed
	 */
	private Service service;
	/**
	 * patient 
	 */
	private Patient patient;
	/**
	 * Date when the patient arrive
	 */
	private Date dateReception;
	/**
	 * Date when the medecin welcomed the patient
	 */
	private Date dateCare;
	
	// setter and getter
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getDateReception() {
		return dateReception;
	}
	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}
	public Date getDateCare() {
		return dateCare;
	}
	public void setDateCare(Date dateCare) {
		this.dateCare = dateCare;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public TypeAct getTypeAct() {
		return typeAct;
	}
	public void setTypeAct(TypeAct typeAct) {
		this.typeAct = typeAct;
	}
	
	
}
