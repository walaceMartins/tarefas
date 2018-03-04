package aula1;

import java.util.ArrayList;

public class Geometria extends Figura {
	Retangulo r = new Retangulo(2);
	Triangulo t = new Triangulo(2);
	Losango   l = new Losango(2);
	Quadrado  q = new Quadrado(2);
	Circulo   c = new Circulo(2);

	public static void main(String[] args) {
		ArrayList<Figura> Figura = new ArrayList<>();
		Figura.add(new Triangulo("Triangulo",+ t.Triangulo()));
		Figura.add(new Circulo("Circulo",+ c.Circulo()));
		Figura.add(new Losango("Losango",+ l.Losango()));
		Figura.add(new Quadrado("Quadrado", + q.Quadrado()));
		Figura.add(new Retangulo("Retangulo"+ r.Retangulo()));
		 for(Figura Figuras:Figura){
			 System.out.println(Figura.getTriangulo());
			 System.out.println(Figura.getCirculo());
			 System.out.println(Figura.getLosango());
			 System.out.println(Figura.getQuadrado());
			 System.out.println(Figura.getRetragulo());
		 }
	}
}
