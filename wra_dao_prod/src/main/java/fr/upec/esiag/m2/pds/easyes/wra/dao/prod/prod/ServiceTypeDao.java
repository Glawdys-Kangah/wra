package fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod;

import java.util.List;

import org.hibernate.Session;
import fr.upec.esiag.m2.pds.easyes.wra.dao.AbstractTypeDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.utils.HibernateUtil;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.ServiceType;
/**
 * Servicestype dao class from easyessoft
 * @author Glawdys
 *
 */
public class ServiceTypeDao extends AbstractTypeDao <ServiceType>{
	/**
	 * get one service type by it's ID
	 */
	@Override
	public ServiceType getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ServiceType srvT=  (ServiceType) session.get(ServiceType.class, id);
		session.close();
		return srvT;
	}
	/**
	 * List of all services type
	 */
	@Override
	public List<ServiceType> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<ServiceType> list = (List<ServiceType>) session.createCriteria(ServiceType.class).list();
		session.close();
		return list;
	}
	
	

}
