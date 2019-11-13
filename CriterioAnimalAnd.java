public class CriterioAnimalAnd implements CriterioAnimal{
	private CriterioAnimal C1;
	private CriterioAnimal C2;

	public CriterioAnimalAnd(CriterioAnimal Criterio1, CriterioAnimal Criterio2){
		C1 = Criterio1;
		C2 = Criterio2;
	}

	public boolean cumple(Animal elem){
		return (C1.cumple(elem) && C2.cumple(elem));
	}
}