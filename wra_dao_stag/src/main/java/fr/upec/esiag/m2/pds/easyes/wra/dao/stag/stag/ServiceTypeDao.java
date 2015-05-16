package fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.upec.esiag.m2.easyes.wra.model.prod.ServiceType;
import fr.upec.esiag.m2.pds.easyes.wra.dao.AbstractTypeDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.utils.HibernateUtil;


public class ServiceTypeDao extends AbstractTypeDao <ServiceType>{
	@Override
	public ServiceType getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ServiceType srvT=  (ServiceType) session.get(ServiceType.class, id);
		session.close();
		return srvT;
	}

	@Override
	public List<ServiceType> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<ServiceType> list = (List<ServiceType>) session.createCriteria(ServiceType.class).list();
		session.close();
		return list;
	}
	
	/**
	 * To get all the new orga type health path between two dates
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ServiceType> getAllByDate(Date startDate , Date endDate) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <ServiceType> lst =(List<ServiceType>) session.createCriteria(ServiceType.class)
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
	public List<ServiceType> getAllByUpdate() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <ServiceType> lst =(List<ServiceType>) session.createCriteria(ServiceType.class)
		.add(Restrictions.ne("updateDate", ""))
		.list();
		session.close();
		return lst;
	}

}
