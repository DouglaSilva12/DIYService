package Model;

public class Item {

		Integer idItem;
		TipoItem tipoItem;
		Produto produto;
		
		// construtor
		public Item(Integer idItem, TipoItem tipoItem) {
			this.idItem= idItem;
			this.tipoItem = tipoItem;
		}
		
		public Item() {
		}
		
		// encapsulamento
		
		public Produto getProduto() {
			return produto;
		}

		public void setIdProduto(Produto produto) {
			this.produto = produto;
		}
		
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
