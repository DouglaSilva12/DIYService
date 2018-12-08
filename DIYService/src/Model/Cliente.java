package Model;

import java.util.List;

public class Cliente {

		private Integer idCliente;
		private String nomeCliente;
		private String senha;
		private String telefone;
		private String endereco;
		private List<Pedido> listaPedidos;
		
		// construtor
		public Cliente(String nomeCliente, String telefone) {
			this.nomeCliente = nomeCliente;
			this.telefone = telefone;
		}
		public Cliente(Integer idCliente) {
			this.idCliente = idCliente;
		}
		public Cliente() {
			
		}
		
		// encapsulamento
		public List<Pedido> getListaPedidos() {
			return listaPedidos;
		}

		public void setListaPedidos(List<Pedido> listaPedidos) {
			this.listaPedidos = listaPedidos;
		}
		
		public String getSenha() {
			return senha;
		}
		
		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
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

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
}

