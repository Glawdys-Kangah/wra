package fr.upec.esiag.m2.easyes.wra.model.prod;

import java.util.HashSet;
import java.util.Set;

public class Hospital extends Organization {
		
		/**
		 * FINESS number of the hospital
		 */
		private String finess;
		
		private Set<Patient> patients = new HashSet<Patient>(0);

		public Set<Patient> getPatients() {
			return patients;
		}

		public void setPatients(Set<Patient> patients) {
			this.patients = patients;
		}

		public String getFiness() {
			return finess;
		}

		public void setFiness(String finess) {
			this.finess = finess;
		}
		


}
