package fr.upec.esiag.m2.pds.easyes.wra.model.prod;



public class Hospital extends Organization {
		
		/**
		 * FINESS number of the hospital
		 */
		private String finess;
		
		private int idPatient;

		
		public String getFiness() {
			return finess;
		}

		public void setFiness(String finess) {
			this.finess = finess;
		}

		public int getIdPatient() {
			return idPatient;
		}

		public void setIdPatient(int idPatient) {
			this.idPatient = idPatient;
		}
		


}
