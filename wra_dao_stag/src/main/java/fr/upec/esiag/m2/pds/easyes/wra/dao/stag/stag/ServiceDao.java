package fr.upec.esiag.m2.pds.easyes.wra.dao.stag.stag;

 import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.upec.esiag.m2.easyes.wra.model.prod.Organization;
import fr.upec.esiag.m2.easyes.wra.model.prod.Service;
import fr.upec.esiag.m2.pds.easyes.wra.dao.AbstractEntityDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.stag.utils.HibernateUtil;




public class ServiceDao extends AbstractEntityDao<Service>{

	@Override
	public Service getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Service srv=  (Service) session.get(Service.class, id);
		session.close();
		return srv;
	}

	@Override
	public List<Service> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Service> list = (List<Service>) session.createCriteria(Service.class).list();
		session.close();
		return list;
	}
	
	
	
	@SuppressWarnings("unchecked")

	public List<Service> getServicesByOrga(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Service where idOrganization = :id ");
		query.setParameter("id", id);
		List<Service> lst = (List<Service>)query.list();
		session.close();
		return lst;
	}
	
	/**
	 * To get all the new organization between two dates
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Service> getAllByDate(Date startDate , Date endDate) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Service> lst =(List<Service>) session.createCriteria(Service.class)
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
	public List<Service> getAllByUpdate() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Service> lst =(List<Service>) session.createCriteria(Service.class)
		.add(Restrictions.ne("updateDate", ""))
		.list();
		session.close();
		return lst;
	}

}
