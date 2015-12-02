package empresa;

public class Compra {
	private int nf;
	private int cod_fornecedor;
	private String data_compra;
	private int cod_produto;
	private int quantidade;
	
	public Compra(int nf, int cod_f, String data, int cod_p, int qnt){
		this.nf = nf;
		this.cod_fornecedor = cod_f;
		this.data_compra = data;
		this.cod_produto = cod_p;
		this.quantidade = qnt;
	}
	public double calculaPreçoCompra(Produto produto){
		return this.quantidade * produto.getCusto() ;
	}

	public int getNf() {
		return nf;
	}

	public void setNf(int nf) {
		this.nf = nf;
	}

	public int getCod_fornecedor() {
		return cod_fornecedor;
	}

	public void setCod_fornecedor(int cod_fornecedor) {
		this.cod_fornecedor = cod_fornecedor;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}

	public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Compra [nf=" + nf + ", cod_fornecedor=" + cod_fornecedor + ", data_compra=" + data_compra
				+ ", cod_produto=" + cod_produto + ", quantidade=" + quantidade + "]";
	}

}
