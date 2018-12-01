package Model;

public class Entrega {

	Integer idEntrega;
	double taxa = 10.00;
	Pedido pedido;
	

	//construtor
	
	public Entrega(Integer idEntrega, double taxa) {
		
		this.idEntrega = idEntrega;
		this.taxa = taxa;
	}
	
	public Entrega() {
		
	}
	
	// encapsulamento

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Integer getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(Integer idEntrega) {
		this.idEntrega = idEntrega;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
}
