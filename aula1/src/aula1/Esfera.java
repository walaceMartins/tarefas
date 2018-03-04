package aula1;

public class Esfera extends Circulo {

	public Esfera(double c) {
		super(c);
		
	}
	    @Override
	    public double a(){
	    	return a = a/360*4*3.14*Math.pow(b,2);
	    } 
	    @Override
	    public double v(){
	    	return v = 4*3.14*Math.pow(b,2);
	    }

	}


