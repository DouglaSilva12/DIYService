package Model;

import java.util.List;

public class Pedido {

	int idPedido;
	double valorTotal;
	List<Produto> listaProdutos;
	Cliente cliente;
	Entrega entrega;
	
	
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

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
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