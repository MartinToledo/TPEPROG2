import java.util.ArrayList;

public abstract class ElementoDeEmpresaAgropecuaria{
	public abstract int obtenerCantidadAnimales();
	public abstract int obtenerSumaEdad();
	public abstract double obtenerPesoTotal();
	public abstract ArrayList<Animal> buscar(CriterioAnimal C);
	public abstract boolean subirAlCamion(Camion C);
}