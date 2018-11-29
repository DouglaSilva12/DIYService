package Model;

public class Endereco {

	String rua;
	Integer numero;
	String bairro;
	Cliente cliente;
	
	// construtor
	
	public Endereco() {
		
	}
	
	// encapsulamento
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
