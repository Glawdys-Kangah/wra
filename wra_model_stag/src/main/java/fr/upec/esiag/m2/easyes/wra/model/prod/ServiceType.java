package fr.upec.esiag.m2.easyes.wra.model.prod;


/**
 * Service type from easyessoft
 * @author Glawdys
 *
 */
import java.util.HashSet;
import java.util.Set;	
import fr.upec.esiag.m2.easyes.wra.model.AbstractType;

public class ServiceType extends AbstractType {
		/**
		 * indicate the type of organization for which the service is created
		 */
		private String categoryService;
		
		
		public String getCategoryService() {
			return categoryService;
		}

		public void setCategoryService(String categoryService) {
			this.categoryService = categoryService;
		}

		
		
		
}
