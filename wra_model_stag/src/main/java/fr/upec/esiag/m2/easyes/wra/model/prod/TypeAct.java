package fr.upec.esiag.m2.easyes.wra.model.prod;

import fr.upec.esiag.m2.easyes.wra.model.AbstractType;

/**
 * Model class for a type of medical act
 * @author Glawdys
 *
 */
public class TypeAct extends AbstractType {
	
	public String toSring(){
		return getLabel();
	}
	

}
