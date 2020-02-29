package ManuSqlJava;

public class Subasta {
	 
	private int idSubasta, nLotes, nPiezas, ventaTotal;
	private String fecha_Sub, director_Sub, lugar;
	
	public Subasta() {}
	
	public Subasta(int idSubasta, String fecha_Sub, String director_Sub,
			String lugar, int nLotes, int nPiezas, int ventaTotal) {
		super();
		this.idSubasta = idSubasta;
		this.nLotes = nLotes;
		this.nPiezas = nPiezas;
		this.ventaTotal = ventaTotal;
		this.fecha_Sub = fecha_Sub;
		this.director_Sub = director_Sub;
		this.lugar = lugar;
	}

	public int getIdSubasta() {
		return idSubasta;
	}

	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}

	public int getnLotes() {
		return nLotes;
	}

	public void setnLotes(int nLotes) {
		this.nLotes = nLotes;
	}

	public int getnPiezas() {
		return nPiezas;
	}

	public void setnPiezas(int nPiezas) {
		this.nPiezas = nPiezas;
	}

	public int getVentaTotal() {
		return ventaTotal;
	}

	public void setVentaTotal(int ventaTotal) {
		this.ventaTotal = ventaTotal;
	}

	public String getFecha_Sub() {
		return fecha_Sub;
	}

	public void setFecha_Sub(String fecha_Sub) {
		this.fecha_Sub = fecha_Sub;
	}

	public String getDirector_Sub() {
		return director_Sub;
	}

	public void setDirector_Sub(String director_Sub) {
		this.director_Sub = director_Sub;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	@Override
	public String toString() {
		return "Subasta [getIdSubasta()=" + getIdSubasta() + ", getnLotes()=" + getnLotes() + ", getnPiezas()="
				+ getnPiezas() + ", getVentaTotal()=" + getVentaTotal() + ", getFecha_Sub()=" + getFecha_Sub()
				+ ", getDirector_Sub()=" + getDirector_Sub() + ", getLugar()=" + getLugar() + "]";
	}
	
	
	
}
