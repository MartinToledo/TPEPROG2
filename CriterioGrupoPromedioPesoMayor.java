public class CriterioGrupoPromedioPesoMayor implements CriterioGrupo{
	private double peso;
	
	public CriterioGrupoPromedioPesoMayor(double p){
		peso = p;
	}
	
	public boolean cumple(Grupo elem){
		return (elem.obtenerPromedioPeso() > peso);
	}
}