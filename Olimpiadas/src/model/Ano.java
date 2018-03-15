package model;

public class Ano {
private int id;
private int ano;
private String tipo;
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

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "Ano [id=" + id + ", ano=" + ano + ", tipo=" + tipo + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ano;
	result = prime * result + id;
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
	Ano other = (Ano) obj;
	if (ano != other.ano)
		return false;
	if (id != other.id)
		return false;
	if (tipo == null) {
		if (other.tipo != null)
			return false;
	} else if (!tipo.equals(other.tipo))
		return false;
	return true;
}

}
