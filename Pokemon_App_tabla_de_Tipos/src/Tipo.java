import java.util.ArrayList;

public class Tipo {
	
	//////////////////////////////////////////////////////////
	/// Atributos
	//////////////////////////////////////////////////////////
	
	
	private String nombre;
	private boolean estado;
	private ArrayList<Integer> debilidades;
	private ArrayList<Integer> fortalezas;
	private String Rutaimg;
	
	
	public Tipo(String nombre, String rutaimg) {
		super();
		this.nombre = nombre;
		this.estado = false;
		this.debilidades = new ArrayList<Integer>();
		this.fortalezas = new ArrayList<Integer>();;
		Rutaimg = rutaimg;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public ArrayList<Integer> getDebilidades() {
		return debilidades;
	}
	public void setDebilidades(int... pdebilidades) {
		for (int i = 0; i < pdebilidades.length; i++) {
			debilidades.add(pdebilidades[i]);
			
		};
	}
	public ArrayList<Integer> getFortalezas() {
		return fortalezas;
	}
	public void setFortalezas(int... pfortalezas) {
		for (int i = 0; i < pfortalezas.length; i++) {
			fortalezas.add(pfortalezas[i]);
		}
	}
	public String getRutaimg() {
		return Rutaimg;
	}
	

}
