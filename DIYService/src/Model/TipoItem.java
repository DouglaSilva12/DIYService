package Model;

public class TipoItem {

		private String nomeTipoItem;
		private Double valorTipoItem;
		private Integer idTipoItem;
		
		//Construtor
		
		public TipoItem() {
			
		}
		
		//Encapsulamento
		
		public String getNomeTipoItem() {
			return nomeTipoItem;
		}
		
		public void setNomeTipoItem(String nomeTipoItem) {
			this.nomeTipoItem = nomeTipoItem;
		}
		
		public Double getValorTipoItem() {
			return valorTipoItem;
		}
		
		public void setValorTipoItem(Double valorTipoItem) {
			this.valorTipoItem = valorTipoItem;
		}
		
		public Integer getIdTipoItem () {
			return idTipoItem;
		}
		
		public void setIdTipoItem (Integer idTipoItem) {
			this.idTipoItem = idTipoItem;
		}
		

}
