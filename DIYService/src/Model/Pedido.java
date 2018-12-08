package Model;

import java.util.List;

public class Pedido {

		Integer idPedido;
		double valorTotal;
		List<Produto> listaProdutos;
		Cliente cliente;
		String pagamento;
		
		//Constante de pagamento e taxa de entrega
		public final String TIPO_1 = "Cartão";
		public final String TIPO_2 = "Dinheiro";
		public final double TAXA_ENTREGA = 10.00;
		
		// metodo
		public void somaValorTotal() {
			valorTotal = 0;
			for(Produto x: listaProdutos) {
				valorTotal = valorTotal + x.getValor();
			}
			valorTotal = valorTotal + TAXA_ENTREGA;
		}
		
		// construtor
		public Pedido() {
			
		}
		
		public Pedido(List<Produto> listaProdutos, Cliente cliente, String pagamento) {
			this.listaProdutos = listaProdutos;
			somaValorTotal();
			
		}
		
		// Função
		public void formaPagamento(Integer codigo) {
			if (codigo ==1)
				pagamento = this.TIPO_1;
			if (codigo ==2)
				pagamento = this.TIPO_2;
		}
		
		// encapsulamento
		
		public String getPagamento() {
			return pagamento;
		}

		public void setPagamento(String pagamento) {
			this.pagamento = pagamento;
		}
		
		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public List<Produto> getListaProdutos() {
			return listaProdutos;
		}

		public void setListaProdutos(List<Produto> listaProdutos) {
			this.listaProdutos = listaProdutos;
		}

		public Integer getIdPedido() {
			return idPedido;
		}

		public void setIdPedido(Integer idPedido) {
			this.idPedido = idPedido;
		}

		public double getValorTotal() {
			return valorTotal;
		}

		public void setValorTotal(double valorTotal) {
			this.valorTotal = valorTotal;
		}

	}
