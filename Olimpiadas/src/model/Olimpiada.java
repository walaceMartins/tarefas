package model;

public class Olimpiada {

	 private static final long serialVersionUID = 1L;
		private int ano;
	    private String tipo;
		
	    public Olimpiada() {
		}

		public int getAno() {
			return ano;
		}

		public void setAno(int ano) {
			this.ano = ano;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Olimpiada [ano=" + ano + ", tipo=" + tipo + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ano;
			result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
			if (ano != other.ano)
				return false;
			if (tipo == null) {
				if (other.tipo != null)
					return false;
			} else if (!tipo.equals(other.tipo))
				return false;
			return true;
		}

		
        
		
	}

