import java.util.ArrayList;

public class Camion{
	private int capacidadMaxima;
	private CriterioAnimal requisitoDeCarga;
	private ArrayList<Animal> Animales;

	public Camion(int cM, CriterioAnimal rDC){
		Animales = new ArrayList<>();
		capacidadMaxima = cM;
		requisitoDeCarga = rDC;
	}

	public void cargarAnimal(Animal animl){
			Animales.add(animl);
	}

	public boolean seLleno(){
		return (Animales.size() >= capacidadMaxima);
	}

	public boolean cumpleRequisito(Animal animl){
		return requisitoDeCarga.cumple(animl);
	}
	
	public ArrayList<Animal> obtenerAnimales(){
		ArrayList<Animal> Animls = new ArrayList<>();
		Animls.addAll(Animales);
		return Animls;
	}
}