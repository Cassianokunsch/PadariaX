package empresa;

public class Venda {
	private int cod_cliente;
	private String data_venda;
	private int cod_produto;
	private int quantidade;
	private String mod_pagamento;
	
	public Venda(int cod_c, String data, int cod_p, int qnt, String mod_p){
		this.cod_cliente = cod_c;
		this.data_venda = data;
		this.cod_produto = cod_p;
		this.quantidade = qnt;
		this.mod_pagamento = mod_p;
	}
	public double calculaPreçoVenda(double precoProduto){
		return this.quantidade * precoProduto;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getData_venda() {
		return data_venda;
	}

	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
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

	public String getMod_pagamento() {
		return mod_pagamento;
	}

	public void setMod_pagamento(String mod_pagamento) {
		this.mod_pagamento = mod_pagamento;
	}

	@Override
	public String toString() {
		return "Venda [cod_cliente=" + cod_cliente + ", data_venda=" + data_venda + ", cod_produto=" + cod_produto
				+ ", quantidade=" + quantidade + ", mod_pagamento=" + mod_pagamento + "]";
	}
	
}
