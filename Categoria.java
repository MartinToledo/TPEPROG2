
public class Categoria{
	private String nombre;
	private CriterioAnimal condicion;
	
	public Categoria(String nmbre, CriterioAnimal cond){
		nombre = nmbre;
		condicion = cond;
	}

	public String getNombre(){
		return nombre;
	}
	
	public boolean clasifica(Animal A){
		return condicion.cumple(A);
	}
}