package Model;

import java.util.List;

public class Cliente {

	private Integer idCliente;
	private String nomeCliente;
	private Integer telefone;
	private List<Endereco> listaEnderecos;
	private List<Pedido> listaPedidos;
	
	
	// construtor
	

	public Cliente(Integer idCliente, String nomeCliente, Integer telefone) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.telefone = telefone;
		
	}
	
	// metodo
	
	

	// encapsulamento
	
	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Integer getTelefoneUsuario() {
		return telefone;
	}


	public void setTelefoneUsuario(Integer telefoneUsuario) {
		this.telefone = telefoneUsuario;
	}
	
}