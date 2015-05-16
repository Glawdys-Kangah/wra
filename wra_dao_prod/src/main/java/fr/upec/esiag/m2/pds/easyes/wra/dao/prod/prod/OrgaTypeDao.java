package fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.upec.esiag.m2.pds.easyes.wra.dao.AbstractTypeDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.utils.HibernateUtil;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.OrgaType;

public class OrgaTypeDao extends AbstractTypeDao <OrgaType>{

	public List<OrgaType> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<OrgaType> lst = (List<OrgaType>) session.createCriteria(OrgaType.class).list();
		session.close();

		return lst;
	}

	

	@Override
	public OrgaType getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
