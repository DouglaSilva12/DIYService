package Model;

public class Pagamento {
	
	private String tipoPagamento;
	private int idPagamento;
	
	//Constantes
	
	protected static final String TIPO_DINHEIRO = "DINHEIRO";
	protected static final String TIPO_CARTAO = "CARTAO";
	
	// construtor
	
	public Pagamento( String tipoPagamento, int idPagamento) {
		
		this.idPagamento = idPagamento;
		this.tipoPagamento = tipoPagamento;
	}
	
	// encapsulamento

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	// método
	
	public void formaPagamento1() {
		
	}
}

