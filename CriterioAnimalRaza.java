public class CriterioAnimalRaza implements CriterioAnimal{
	private String raza;
	
	public CriterioAnimalRaza(String r){
		raza = r;
	}
	
	public boolean cumple(Animal elem){
		return (raza == elem.obtenerRaza());
	}
}