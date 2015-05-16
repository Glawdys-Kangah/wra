package fr.upec.esiag.m2.pds.easyes.wra.model.prod;


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
		
		private Set<Organization> organizationSet = new HashSet<Organization>(0);

		public String getCategoryService() {
			return categoryService;
		}

		public void setCategoryService(String categoryService) {
			this.categoryService = categoryService;
		}

		public Set<Organization> getOrganizationSet() {
			return organizationSet;
		}

		public void setOrganizationSet(Set<Organization> organizationSet) {
			this.organizationSet = organizationSet;
		}
		
}
