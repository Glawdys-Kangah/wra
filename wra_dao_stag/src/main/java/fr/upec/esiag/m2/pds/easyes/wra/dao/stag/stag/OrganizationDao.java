package fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.upec.esiag.m2.easyes.wra.model.prod.Organization;
import fr.upec.esiag.m2.pds.easyes.wra.dao.AbstractEntityDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.utils.HibernateUtil;

/**
 * Dao class from easyessoft
 * @author Glawdys
 *
 */
public class OrganizationDao extends AbstractEntityDao<Organization> {

	@Override
	public Organization getById(int id) {
		return null;
		
	}

	
	@Override
	/**
	 * Get the list of all organization
	 */
	public List<Organization> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(Organization.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Organization> list = (List<Organization>) criteria.list();
		session.close();
		return list;
	}
	/**
	 * Get a organization by it siret number
	 * @param mySiret
	 * @return
	 */
	public Organization findBySiret(String mySiret){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(Organization.class);
		Organization myOrganization=null;
		try{
			myOrganization=(Organization) criteria.add(Restrictions.eq("siret", mySiret)).uniqueResult();
		}catch (HibernateException e) {
			@SuppressWarnings("unchecked")
			List<Organization> list = (List<Organization>) criteria.add(Restrictions.eq("siret", mySiret)).list();
			myOrganization = list.get(0);
		}
		session.close();
		return myOrganization;	
	}

	/**
	 * get by type
	 * @return get All organisation which are T Type
	 */
	public <T> List<T> getAllByType(Class<T> clazz){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<T> list  =(List<T>) session.createCriteria(clazz).list();
		session.close();
		return list;
	}
	
	/**
	 * To get all the new organization between two dates
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Organization> getAllByDate(Date startDate , Date endDate) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Organization> lst =(List<Organization>) session.createCriteria(Organization.class)
		.add(Restrictions.ge("createDate", startDate))
		.add(Restrictions.lt("createDate", endDate))
		.list();
		session.close();
		return lst;
	}
	/**
	 * To get all updated data
	 * @return
	 */
	public List<Organization> getAllByUpdate() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Organization> lst =(List<Organization>) session.createCriteria(Organization.class)
		.add(Restrictions.ne("updateDate", ""))
		.list();
		session.close();
		return lst;
	}
	/**
	 * Get all from a organization type by date
	 * @param clazz
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public <T> List<T> getAllByTypeByDate(Class<T> clazz,Date startDate, Date endDate){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<T> list  =(List<T>) session.createCriteria(clazz)
				.add(Restrictions.ge("createDate", startDate))
				.add(Restrictions.lt("createDate", endDate))
				.list();
		session.close();
		return list;
	}

	/**
	 * Method to add a list of organization in the database
	 */
	public void addOrganization(Organization organization){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(organization);
		session.getTransaction().commit();
		session.close();
	}
}
