package ManuSqlJava;

public class Libro {
	
	private String id;
	private String autor;
	private String titulo;
	private String genero;
	private String precio;
	private String fecha;
	private String descripcion;
	
	public Libro() {}
	
	public Libro(String id, String autor, String titulo, String genero, String precio, String fecha,
			String descripcion) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		this.precio = precio;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", autor=" + autor + ", titulo=" + titulo + ", genero=" + genero + ", precio="
				+ precio + ", fecha=" + fecha + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
