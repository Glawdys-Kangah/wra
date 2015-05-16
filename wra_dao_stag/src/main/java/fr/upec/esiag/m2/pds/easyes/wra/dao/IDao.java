package fr.upec.esiag.m2.pds.easyes.wra.dao;

import fr.upec.esiag.m2.easyes.wra.model.AbstractModel;


/**
 * Interface Dao
 * @author Glawdys
 * @param <T>
 */
public interface IDao<T extends AbstractModel> {

	/**
	 * Persist the item in DataBase
	 * 
	 * @param item
	 * @return item which was inserted
	 */
	public T create(T item);

	/**
	 * Delete an item by the id
	 * @param id
	 * @return item was deleted
	 */
	public T deleteById(int id);

	/**
	 * Get an item by the id
	 * 
	 * @param id
	 * @return the item which was requested
	 */
	public T getById(int id);
}

