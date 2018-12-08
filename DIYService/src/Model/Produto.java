package Model;
import java.util.List;

public class Produto {


		private Integer idProduto;
		private String nomeProduto;
		private List<Item> itensEscolhidos;
		private double valor;
		
		// construtor
		
		public Produto(Integer idProduto, String nomeProduto, List<Item> itensEscolhidos) {
			this.idProduto = idProduto;
			this.nomeProduto = nomeProduto;
			this.itensEscolhidos = itensEscolhidos;
			calculaValor();
		}

		public Produto() {
		}
		
		// metodo para somar o valor dos itens escolhidos
		
		public void calculaValor() {
			valor = 0;
			for(Item x: itensEscolhidos) {
				valor = valor + x.getTipoItem().getValorTipoItem();
			}
		}
		
		// encapsulamento	
		public double getValor() {
			return valor;
		}
		
		public void setValor(double valor) {
			this.valor = valor;
		}

		public Integer getIdProduto() {
			return idProduto;
		}

		public void setIdProduto(Integer idProduto) {
			this.idProduto = idProduto;
		}

		public String getNomeProduto() {
			return nomeProduto;
		}

		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}
		
		public List<Item> getItensEscolhidos(){
			return itensEscolhidos;
		}
		
		public void setItensEscolhidos (List<Item> itensEscolhidos) {
			this.itensEscolhidos = itensEscolhidos;
		}
	}
