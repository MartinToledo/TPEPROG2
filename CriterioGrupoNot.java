public class CriterioGrupoNot implements CriterioGrupo{
	private CriterioGrupo C;
	
	public CriterioGrupoNot(CriterioGrupo Criteri){
		C = Criteri;
	}
	
	public boolean cumple(Grupo elem){
		return (!C.cumple(elem));
	}
}