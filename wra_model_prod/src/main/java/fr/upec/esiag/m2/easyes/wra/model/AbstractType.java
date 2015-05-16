package fr.upec.esiag.m2.easyes.wra.model;

public class AbstractType extends AbstractModel {
		/**
		 * Functional key which permit to retrieve a label
		 */
		private String code;
		/**
		 * Label about a type
		 */
		private String label;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {	
			this.label = label;
		}


}
