package aula1;

public class Cilindro extends Circulo {
	public Cilindro(double c) {
		super(c);
	}
		 @Override
		    public double a(){
		    	return a = 2*(3.14*Math.pow(b,2)) + 2*(3.14*r*h);
		    } 
		    @Override
		      public double v(){
		      	return v = Math.pow(3.14,2)*h;
		      }
	}


