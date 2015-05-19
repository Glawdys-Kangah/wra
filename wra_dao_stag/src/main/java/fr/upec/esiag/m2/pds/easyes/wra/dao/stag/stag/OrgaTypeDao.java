package fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.upec.esiag.m2.easyes.wra.model.prod.OrgaType;
import fr.upec.esiag.m2.pds.easyes.wra.dao.AbstractTypeDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.utils.HibernateUtil;


public class OrgaTypeDao extends AbstractTypeDao <OrgaType>{

	public List<OrgaType> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<OrgaType> lst = (List<OrgaType>) session.createCriteria(OrgaType.class).list();
		session.close();

		return lst;
	}

	/**
	 * To get all the new orga type health path between two dates
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<OrgaType> getAllByDate(Date startDate , Date endDate) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <OrgaType> lst =(List<OrgaType>) session.createCriteria(OrgaType.class)
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
	public List<OrgaType> getAllByUpdate() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <OrgaType> lst =(List<OrgaType>) session.createCriteria(OrgaType.class)
		.add(Restrictions.ne("updateDate", ""))
		.list();
		session.close();
		return lst;
	}

	@Override
	public OrgaType getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Method to add a list of orgaType in the database
	 */
	public void addOrgaType(OrgaType orgaType){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(orgaType);
		session.getTransaction().commit();
		session.close();
	}

}
