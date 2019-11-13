public class CriterioGrupoPromedioEdadMayor implements CriterioGrupo{
	private int edad;
	
	public CriterioGrupoPromedioEdadMayor(int edadMeses){
		edad = edadMeses;
	}
	
	public boolean cumple(Grupo elem){
		return (elem.obtenerPromedioEdad() > edad);
	}
}