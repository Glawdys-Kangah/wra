package fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag;

import java.util.List;

import org.hibernate.Session;

import fr.upec.esiag.m2.pds.easyes.wra.dao.AbstractEntityDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.utils.HibernateUtil;
import fr.upec.esiag.m2.pds.easyes.wra.model.stag.PatientReception;

public class PatientReceptionDao extends AbstractEntityDao<PatientReception> {

	@Override
	public PatientReception getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientReception> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method to add a list of patient reception in the database
	 */
	public void addPatientReception(PatientReception patientR){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(patientR);
		session.getTransaction().commit();
		session.close();
	}
}
