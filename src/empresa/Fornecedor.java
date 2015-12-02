package empresa;

public class Fornecedor {
	private int cod_fornecedor;
	private String nome;
	private String endereco;
	private String telefone;
	private String cnpj;
	private String contato;
		
	public Fornecedor(int cod, String nome, String end, String tel, String cnpj, String cont){
		this.cod_fornecedor = cod;
		this.nome = nome;		
		this.endereco = end;
		this.telefone = tel;
		this.cnpj = cnpj;
		this.contato = cont;
	}

	public int getCod_fornecedor() {
		return cod_fornecedor;
	}

	public void setCod_fornecedor(int cod_fornecedor) {
		this.cod_fornecedor = cod_fornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Fornecedor [cod_fornecedor=" + cod_fornecedor + ", nome=" + nome + ", endereco=" + endereco
				+ ", telefone=" + telefone + ", cnpj=" + cnpj + ", contato=" + contato + "]";
	}
	
	

}
