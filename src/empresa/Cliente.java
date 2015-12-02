package empresa;

public class Cliente {
	private int codigo;
	private String nome;
	private String endereco;
	private String telefone;
	private String data;
	private String tipo;
	private String documento;	
	private int estadual;
		
	public Cliente(int cod, String nome, String end, String tel, String data, String type, String doc, int est){
		this.codigo = cod;
		this.nome = nome;
		this.endereco = end;
		this.telefone = tel;
		this.data = data;
		this.tipo = type;
		this.documento = doc;		
		this.estadual = est;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public int getEstadual() {
		return estadual;
	}

	public void setEstadual(int estadual) {
		this.estadual = estadual;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", data=" + data + ", tipo=" + tipo + ", documento=" + documento + ", estadual=" + estadual + "]";
	}
	
	

}
