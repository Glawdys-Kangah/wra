package fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import fr.upec.esiag.m2.easyes.wra.model.prod.Hospital;
import fr.upec.esiag.m2.easyes.wra.model.prod.Patient;
import fr.upec.esiag.m2.pds.easyes.wra.dao.AbstractEntityDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.utils.HibernateUtil;


/**
 * Patient dao from easyessoft
 * @author Glawdys
 *
 */
public class PatientDao  extends AbstractEntityDao<Patient>{

	@Override
	public Patient getById(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Patient.class);
		cr.add(Restrictions.eq("id", id));
		Patient patient = (Patient) cr.uniqueResult();
		session.close();
		return patient;
	}

	@Override
	public List<Patient> getAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> list = (List<Patient>) session.createCriteria(Patient.class).list();
		session.close();
		return list;
	}
	
	public Patient getByNIR(String nir) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Patient.class);
		cr.add(Restrictions.eq("nir", nir));
		Patient patientFound = (Patient) cr.list().get(0);
		session.close();
		return patientFound;
	}
	
	public List<Patient> getByOrgaID(int OrgaID) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Patient.class);
		cr.add(Restrictions.eq("idOrganization", OrgaID));
		List<Patient> patientList = cr.list();
		session.close();
		return patientList;
	}
	
	public void update(Patient patient){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(patient);
		session.close();
		
	}
	
	public List<Patient> getByHospital(Hospital hospital){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Patient.class);
		cr.add(Restrictions.eq("hospital", hospital));
		// je pense qu'il y a un truc a voir ici
		List<Patient> patientList = cr.list();
		session.close();
		return patientList;
	}
	//Lionel mÃ©thode que j'ai ajoutÃ©... au pire on en parle Jeudi Glawdys
	@SuppressWarnings("unchecked")
	public List<Patient> getAllByIdHospital(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Patient where hospital.id = :id ");
		query.setParameter("id", id);
		List<Patient> lst = (List<Patient>) query.list();
		session.close();
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List <Patient>findByMaritalStatus(String firstName, String lastName,
			 int idHospital) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List <Patient> lst =(List<Patient>) session.createCriteria(Patient.class)
							.add(Restrictions.eq("firstName", firstName))
							.add(Restrictions.eq("lastName", lastName))
							.add(Restrictions.eq("hospital.id", idHospital))
							.list();
		session.close();
		return lst;
	}

	

	@SuppressWarnings("unchecked")
	public List<String> getNamePatientByIdParcours(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("select p.mailAdress from Patient p join p.medicaljourney m where m.idjourney = :id  ");
		query.setParameter("id", id);
		List<String> lstPatient = (List<String>) query.list();
		session.close();
		return lstPatient;
	}
	
/**
 * To get all the new patient between two dates
 * @param startDate
 * @param endDate
 * @return
 */
	public List<Patient> getAllByDate(Date startDate , Date endDate) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Patient> lst =(List<Patient>) session.createCriteria(Patient.class)
		.add(Restrictions.ge("createdate", startDate))
		.add(Restrictions.lt("createdate", endDate))
		.list();
		session.close();
		return lst;
	}
	/**
	 * To get all updated data
	 * @return
	 */
	public List<Patient> getAllByUpdate() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Patient> lst =(List<Patient>) session.createCriteria(Patient.class)
		.add(Restrictions.ne("updatedate", ""))
		.list();
		session.close();
		return lst;
	}
	
	/**
	 * Method to add a list of patient in the database
	 */
	public void addPatient(Patient patient){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(patient);
		session.getTransaction().commit();
		session.close();
	}
	
}
