package fr.upec.esiag.m2.pds.easyes.wra.dao.prod.prod;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.upec.esiag.m2.pds.easyes.wra.dao.AbstractTypeDao;
import fr.upec.esiag.m2.pds.easyes.wra.dao.prod.utils.HibernateUtil;
import fr.upec.esiag.m2.pds.easyes.wra.model.prod.TypeAct;


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

	
}
