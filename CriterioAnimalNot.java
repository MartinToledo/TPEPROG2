public class CriterioAnimalNot implements CriterioAnimal{
	private CriterioAnimal C;
	
	public CriterioAnimalNot(CriterioAnimal Criteri){
		C = Criteri;
	}
	
	public boolean cumple(Animal elem){
		return (!C.cumple(elem));
	}
}