package model;

public class Categoria {
	
	private Integer idCategoria;
	private String categoriaName;

	public Categoria(int idCategoria, String categoriaName) {
		this.idCategoria = idCategoria;
		this.categoriaName = categoriaName;
	}
	
	

	public Integer getIdCategoria() {
		return idCategoria;
	}



	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}



	public String getCategoriaName() {
		return categoriaName;
	}

	public void setCategoriaName(String categoria) {
		this.categoriaName = categoria;
	}
	
	

}
