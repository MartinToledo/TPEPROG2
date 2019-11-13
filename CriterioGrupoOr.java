public class CriterioGrupoOr implements CriterioGrupo{
	private CriterioGrupo C1;
	private CriterioGrupo C2;
	
	public CriterioGrupoOr(CriterioGrupo Criterio1, CriterioGrupo Criterio2){
		C1 = Criterio1;
		C2 = Criterio2;
	}
	
	public boolean cumple(Grupo elem){
		return (C1.cumple(elem) || C2.cumple(elem));
	}
}