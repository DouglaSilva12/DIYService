package Model;

public class Entrega {

	Integer idEntrega;
	double taxaEntrega;
	String endereco;
	
	protected static final double taxaEntregaUnica = 10.00;
	
	
	//construtor
	
	public Entrega(Integer idEntrega, double taxaEntrega, String enderecoEntrega) {
		
		this.endereco = enderecoEntrega;
		this.idEntrega = idEntrega;
		this.taxaEntrega = taxaEntrega;
	}
	
	// encapsulamento

	public Integer getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(Integer idEntrega) {
		this.idEntrega = idEntrega;
	}

	public double getTaxaEntrega() {
		return taxaEntrega;
	}

	public void setTaxaEntrega(double taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEnderecoEntrega(String endereco) {
		this.endereco = endereco;
	}
	
	// metodo
	
	
}

