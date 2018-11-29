package Model;

import java.util.List;

public class Pedido {

	Integer idPedido;
	double valorTotal;
	List<Produto> listaProdutos;
	Cliente cliente;
	Entrega entrega;
	Pagamento pagamento;
	
	
	// metodo
	

	public void somaValorTotal() {
		valorTotal = 0;
		for(Produto x: listaProdutos) {
			valorTotal = valorTotal + x.getValor();
		}
	}
	
	// construtor
	
	public Pedido() {
		
	}
	
	// encapsulamento
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
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

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
}