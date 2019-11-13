import java.util.ArrayList;

public class Animal extends ElementoDeEmpresaAgropecuaria{
	private int identificador;
	private int mesesEdad;
	private double kgPeso;
	private String raza;
	private boolean esMacho;
	private boolean fueCapado;
	private int cantTernerosParidos;
	
	public Animal(int ident, int mEdad, double p, String r, boolean esM, boolean estaCapado){
		identificador = ident;
		mesesEdad = mEdad;
		kgPeso = p;
		raza = r;
		esMacho = esM;
		fueCapado = estaCapado;
	}
	
	public int obtenerIdentificador(){
		return identificador;
	}

	public int obtenerCantidadAnimales(){
		return 1;
	}

	public int obtenerEdad(){
		return mesesEdad;
	}

	public int obtenerSumaEdad(){
		return this.obtenerEdad();
	}

	public double obtenerPeso(){
		return kgPeso;
	}
	
	public double obtenerPesoTotal(){
		return this.obtenerPeso();
	}

	public ArrayList<Animal> buscar(CriterioAnimal C){
		ArrayList<Animal> elemento = new ArrayList<>();
		if(C.cumple(this)){
			elemento.add(this);
		}
		return elemento;
	}

	public String obtenerRaza(){
		return raza;
	}

	public boolean subirAlCamion(Camion C){
		if((C.cumpleRequisito(this)) && (!C.seLleno())){
			C.cargarAnimal(this);
			return true;
		}
		else{
			return false;
		}
	}

	public boolean equals(Object o){
			return ((o != null) && this.getClass().equals(o.getClass()) && (this.obtenerIdentificador() == (((Animal) o).obtenerIdentificador())));
	}
}