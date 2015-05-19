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
	private int idTypeAct;
	/**
	 * Service where the patient is welcomed
	 */
	private int idService;
	/**
	 * patient 
	 */
	private int idPatient;
	/**
	 * Date when the patient arrive
	 */
	private Date dateReception;
	/**
	 * Date when the medecin welcomed the patient
	 */
	private Date dateCare;
	
	// setter and getter
	
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
	public int getIdTypeAct() {
		return idTypeAct;
	}
	public void setIdTypeAct(int idTypeAct) {
		this.idTypeAct = idTypeAct;
	}
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	
	
	
}
