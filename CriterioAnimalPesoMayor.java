public class CriterioAnimalPesoMayor implements CriterioAnimal{
	private double peso;
	
	public CriterioAnimalPesoMayor(double p){
		peso = p;
	}
	
	public boolean cumple(Animal elem){
		return (elem.obtenerPeso() > peso);
	}
}