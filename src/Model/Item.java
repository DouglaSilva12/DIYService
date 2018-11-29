package Model;

public class Item {

	Integer idItem;
	TipoItem tipoItem;
	
	
	// construtor
	
	
	public Item(Integer idItem, TipoItem tipoItem) {
		this.idItem= idItem;
		this.tipoItem = tipoItem;
	}
	
	public Item() {
	}
	
	// encapsulamento

	public Integer getIdItem() {
		return idItem;
	}
	
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}
	
	public TipoItem getTipoItem() {
		return tipoItem;
	}
	
	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

}