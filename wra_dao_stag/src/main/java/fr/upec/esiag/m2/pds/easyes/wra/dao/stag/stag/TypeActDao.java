package fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.upec.esiag.m2.easyes.wra.model.prod.Patient;
import fr.upec.esiag.m2.easyes.wra.model.prod.TypeAct;
import fr.upec.esiag.m2.pds.easyes.wra.dao.AbstractTypeDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.utils.HibernateUtil;



public class TypeActDao extends AbstractTypeDao<TypeAct> {

	@Override
	public TypeAct getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TypeAct> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<TypeAct> lst = (List<TypeAct>) session.createCriteria(TypeAct.class).list();
		session.close();
		return lst;
		
	}

	/**
	 * To get all the new type act type between two dates
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<TypeAct> getAllByDate(Date startDate , Date endDate) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <TypeAct> lst =(List<TypeAct>) session.createCriteria(TypeAct.class)
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
	public List<TypeAct> getAllByUpdate() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <TypeAct> lst =(List<TypeAct>) session.createCriteria(TypeAct.class)
		.add(Restrictions.ne("updateDate", ""))
		.list();
		session.close();
		return lst;
	}
	/**
	 * Method to add a list of patient in the database
	 */
	public void addTypeActDao(TypeAct typeAct){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(typeAct);
		session.getTransaction().commit();
		session.close();
	}
}
