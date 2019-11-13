import java.util.ArrayList;

public class Grupo extends ElementoDeEmpresaAgropecuaria{
	private ArrayList<ElementoDeEmpresaAgropecuaria> elems;
	
	public Grupo(){
		elems = new ArrayList<>();
	}

	public ElementoDeEmpresaAgropecuaria getElemento(int indice){
		ElementoDeEmpresaAgropecuaria elem = elems.get(indice);
		return elem;
	}
	
	public ArrayList<ElementoDeEmpresaAgropecuaria> getElementos(){
		ArrayList<ElementoDeEmpresaAgropecuaria> elementos = new ArrayList<>();
		elementos.addAll(elems);
		return elementos;
	}

	public void setElemento(ElementoDeEmpresaAgropecuaria elem){
		elems.add(elem);
	}

	public int obtenerCantidadAnimales(){
		int cantAnimales = 0;
		for(ElementoDeEmpresaAgropecuaria elem:elems){
			cantAnimales += elem.obtenerCantidadAnimales();
		}
		return cantAnimales;
	}
	
	public int obtenerSumaEdad(){
		int sumaEdades = 0;
		for(ElementoDeEmpresaAgropecuaria elem:elems){
			sumaEdades += elem.obtenerSumaEdad();
		}
		return sumaEdades;
	}

	public double obtenerPromedioEdad(){
		return ((this.obtenerSumaEdad()) / (this.obtenerCantidadAnimales()));
	}

	public double obtenerPesoTotal(){
		double pesoTotal = 0;
		for(ElementoDeEmpresaAgropecuaria elem:elems){
			pesoTotal += elem.obtenerPesoTotal();
		}
		return pesoTotal;
	}

	public double obtenerPromedioPeso(){
		return (this.obtenerPesoTotal() / this.obtenerCantidadAnimales());
	}
	
	public ArrayList<Animal> buscar(CriterioAnimal C){
		ArrayList<Animal> Animales = new ArrayList<>();
		for(ElementoDeEmpresaAgropecuaria elem:elems){
			Animales.addAll(elem.buscar(C));
		}
		return Animales;
	}

	public boolean subirAlCamion(Camion C){
		int pos = 0;
		while((!C.seLleno()) && (pos < elems.size())){
			ElementoDeEmpresaAgropecuaria elem = elems.get(pos);
			if(elem.subirAlCamion(C)){
				elems.remove(elem);
			}
			else{
				pos++;
			}
		}
		return false;
	}
}