public class CriterioAnimalEdadMayor implements CriterioAnimal{
	private int edad;
	
	public CriterioAnimalEdadMayor(int edadMeses){
		edad = edadMeses;
	}
	
	public boolean cumple(Animal elem){
		return (elem.obtenerEdad() > edad);
	}
}