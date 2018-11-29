package Model;

public class Pagamento {
	
	private String tipoPagamento;
	private Integer idPagamento;
	private Pedido pedido;
	
	// construtor
	
	public Pagamento( String tipoPagamento, Integer idPagamento) {
		
		this.idPagamento = idPagamento;
		this.tipoPagamento = tipoPagamento;
	}
	
	public Pagamento() {
		
	}
	
	// encapsulamento
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setTipoPagamento(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	// método
	
	public void formaPagamento1() {
		tipoPagamento = "Dinheiro";
		idPagamento = 1;
	}
	
	public void formaPagamento2() {
		tipoPagamento = "Cartão";
		idPagamento = 2;
	}
}
