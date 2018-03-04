package aula1;

public class Cubo extends Quadrado {
    
    public Cubo(double a){
    super(a);
    }
    @Override
    public double a(){
    	return a = a*6;
    } 
    @Override
    public double v(){
    	return v = Math.pow(a,3);
    }

}