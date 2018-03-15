package model;

public class Olimpiada {

	 private static final long serialVersionUID = 1L;
		private int id;
	    private int ouro;
		private int prata;
		private int bronze;

		public Olimpiada() {
		}
        public int getOuro() {
			return ouro;
		}
		public void setOuro(int ouro) {
			this.ouro = ouro;
		}
		public int getPrata() {
			return prata;
		}
		public void setPrata(int prata) {
			this.prata = prata;
		}
		public int getBronze() {
			return bronze;
		}
		public void setBronze(int bronze) {
			this.bronze = bronze;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "Olimpiada [id=" + id + ", ouro=" + ouro + ", prata=" + prata + ", bronze=" + bronze + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + bronze;
			result = prime * result + id;
			result = prime * result + ouro;
			result = prime * result + prata;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Olimpiada other = (Olimpiada) obj;
			if (bronze != other.bronze)
				return false;
			if (id != other.id)
				return false;
			if (ouro != other.ouro)
				return false;
			if (prata != other.prata)
				return false;
			return true;
		}
		
	}

