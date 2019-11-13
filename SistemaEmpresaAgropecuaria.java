import java.util.ArrayList;

public class SistemaEmpresaAgropecuaria{
	public static void main(String[] args) {
		Animal vaca1 = new Animal(1, 20, 459.12, "Aberti", true, false);
		Animal vaca2 = new Animal(2, 15, 390.87, "Ferrit", false, true);
		Animal vaca3 = new Animal(3, 10, 334.13, "Magan", false, false);
		Animal vaca4 = new Animal(4, 34, 607.62, "Ferrit", true, true);
		Animal vaca5 = new Animal(5, 26, 515.51, "Ferrit", false, false);
		Animal vaca6 = new Animal(6, 31, 579.32, "Aberti", true, true);
		Animal vaca7 = new Animal(7, 16, 398.65, "Magan", true, true);
		Animal vaca8 = new Animal(8, 22, 489.10, "Ferrit", true, false);
		Animal vaca9 = new Animal(9, 19, 421.71, "Aberti", false, true);
		Animal vaca10 = new Animal(10, 29, 501.24, "Aberti", true, false);
		Animal vaca11 = new Animal(11, 8, 291.41, "Magan", false, false);
		Animal vaca12 = new Animal(12, 20, 459.12, "Aberti", true, false);
		Animal vaca13 = new Animal(13, 15, 390.87, "Ferrit", false, true);
		Animal vaca14 = new Animal(14, 10, 334.13, "Magan", false, false);
		Animal vaca15 = new Animal(15, 34, 607.62, "Ferrit", true, true);
		Animal vaca16 = new Animal(16, 26, 515.51, "Ferrit", false, false);
		Animal vaca17 = new Animal(17, 31, 579.32, "Aberti", true, true);
		Animal vaca18 = new Animal(18, 16, 398.65, "Magan", true, true);
		Animal vaca19 = new Animal(19, 22, 489.10, "Ferrit", true, false);
		Animal vaca20 = new Animal(20, 19, 421.71, "Aberti", false, true);
		Grupo grupo1 = new Grupo();
		Grupo grupo2 = new Grupo();
		Grupo grupo3 = new Grupo();
		Grupo grupo4 = new Grupo();
		Grupo grupo5 = new Grupo();
		Grupo grupo6 = new Grupo();
		grupo1.setElemento(vaca1);
		grupo1.setElemento(vaca2);
		grupo1.setElemento(vaca3);
		grupo2.setElemento(vaca4);
		grupo2.setElemento(vaca5);
		grupo2.setElemento(grupo1);
		grupo2.setElemento(vaca6);
		grupo2.setElemento(vaca7);
		grupo2.setElemento(vaca8);
		grupo3.setElemento(vaca9);
		grupo3.setElemento(vaca10);
		grupo3.setElemento(vaca11);
		grupo3.setElemento(vaca12);
		grupo3.setElemento(vaca13);
		grupo4.setElemento(vaca14);
		grupo4.setElemento(vaca15);
		grupo4.setElemento(vaca16);
		grupo4.setElemento(vaca17);
		grupo4.setElemento(vaca18);
		grupo5.setElemento(vaca19);
		grupo5.setElemento(vaca20);
		grupo5.setElemento(grupo3);
		grupo5.setElemento(grupo4);
		grupo6.setElemento(grupo2);
		grupo6.setElemento(grupo5);
		CriterioAnimal edadMayor = new CriterioAnimalEdadMayor(15);
		CriterioAnimal pesoMayor = new CriterioAnimalPesoMayor(500.10);
		CriterioAnimal pesoMayorYedadMayor = new CriterioAnimalAnd(edadMayor, pesoMayor);
		CriterioGrupo promedioEdadMayor = new CriterioGrupoPromedioEdadMayor(22);
		CriterioGrupo promedioPesoMayor = new CriterioGrupoPromedioPesoMayor(243.19);
		Categoria cat1 = new Categoria("Pridufo", pesoMayorYedadMayor);
		Categoria cat2 = new Categoria("Barquen", edadMayor);
		Categoria cat3 = new Categoria("Quinsik", pesoMayor);
		ArrayList<Categoria> categorias = new ArrayList<>();
		categorias.add(cat1);
		categorias.add(cat2);
		categorias.add(cat3);
		SistemaEmpresaAgropecuaria Empresa = new SistemaEmpresaAgropecuaria(grupo6, categorias);
		System.out.println(grupo6.obtenerCantidadAnimales());
		System.out.println(grupo6.obtenerPromedioEdad());
		System.out.println(grupo6.obtenerPesoTotal());
		System.out.println(grupo6.obtenerPromedioPeso());
		System.out.println(Empresa.esAptoParaVender(grupo6, promedioPesoMayor));
		System.out.println(Empresa.esAptoParaVender(grupo6, promedioEdadMayor));
		for(Animal A:(Empresa.buscar(pesoMayor))){			
			System.out.print("|-" + A.obtenerIdentificador() + "-|");
		}
		Camion camion1 = new Camion(5, edadMayor);
		Empresa.cargarCamion(camion1);
		System.out.println("");
		for(Animal A:(camion1.obtenerAnimales())){
			System.out.print("|-" + A.obtenerIdentificador() + "-|");
		}
		System.out.println("");
		for(String cat:Empresa.categorizarAnimal(vaca1)){
			System.out.print("|-" + cat + "-|");
		}
	}
	
	private Grupo Empresa;
	private ArrayList<Categoria> Categorias;

	public SistemaEmpresaAgropecuaria(Grupo G, ArrayList<Categoria> categ){
		Empresa = G;
		Categorias = new ArrayList<>();
		Categorias.addAll(categ);
	}

	public ArrayList<String> categorizarAnimal(Animal A){
		ArrayList<String> CategoriasCoincidentes = new ArrayList<>();
		for(Categoria categ:Categorias){
			if(categ.clasifica(A)){
				CategoriasCoincidentes.add(categ.getNombre());
			}
		}
		return CategoriasCoincidentes;
	}

	public ArrayList<Animal> buscar(CriterioAnimal C){
		return Empresa.buscar(C);
	}

	public boolean esAptoParaVender(Grupo G, CriterioGrupo CondicionParaLaVenta){
		return CondicionParaLaVenta.cumple(G);
	}
	
	public void cargarCamion(Camion C){
		Empresa.subirAlCamion(C);
	}
}