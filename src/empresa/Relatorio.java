package empresa;
import java.util.ArrayList;
import leitordearquivos.Lercsv;
import Util.Util;

public class Relatorio {
	private ArrayList<Cliente> dados_cliente;
	private ArrayList<Venda> dados_venda;
	private ArrayList<Compra> dados_compra;
	private ArrayList<Produto> dados_produto;
	private ArrayList<Fornecedor> dados_fornecedor;
	private Lercsv ler = new Lercsv();
	
	public Relatorio(String dir_cliente, String dir_venda, String dir_compra, String dir_produto, String dir_fornecedor){
		this.dados_cliente = ler.le_e_cria_cliente(dir_cliente);
		this.dados_venda = ler.le_e_cria_venda(dir_venda);
		this.dados_compra = ler.le_e_cria_compra(dir_compra);
		this.dados_produto = ler.le_e_cria_produto(dir_produto);
		this.dados_fornecedor = ler.le_e_cria_fornecedor(dir_fornecedor);
		
	}

	
	public void gera_a_pagar_fornecedor(){
		ArrayList<ArrayList<String>> dadosAllFornecedores = new ArrayList<ArrayList<String>>();
		ArrayList<String> dadosFornecedor = new ArrayList<String>();
		double precoCompra = 0;
		
		for(Fornecedor fornecedor : dados_fornecedor){
			dadosFornecedor.add(fornecedor.getNome());
			dadosFornecedor.add(fornecedor.getCnpj());
			dadosFornecedor.add(fornecedor.getContato());
			dadosFornecedor.add(fornecedor.getTelefone());
			for(Compra compra : dados_compra){
				if (fornecedor.getCod_fornecedor() == compra.getCod_fornecedor()){
					for(Produto produto : dados_produto){
						if (compra.getCod_produto() == produto.getCodigo()){
							precoCompra = precoCompra + compra.calculaPreçoCompra(produto);
							produto.aumentaEstoque(compra.getQuantidade());
						}
					}
				}
			}
			dadosFornecedor.add(Util.FormatPreco(precoCompra, "R$0.00"));
			precoCompra = 0;
			dadosAllFornecedores.add(dadosFornecedor);
			dadosFornecedor = new ArrayList<String>();
		}
		System.out.println(dadosAllFornecedores);
	}
	
	public void gera_a_receber_cliente(){
		ArrayList<ArrayList<String>> dadosAllCliente = new ArrayList<ArrayList<String>>();
		ArrayList<String> dadosCliente = new ArrayList<String>();
		double precoAReceber = 0;
		
		for(Cliente cliente : dados_cliente){
			dadosCliente.add(cliente.getNome());
			dadosCliente.add(cliente.getTipo());
			dadosCliente.add(cliente.getDocumento());
			dadosCliente.add(cliente.getTelefone());
			dadosCliente.add(cliente.getData());
			for(Venda venda : dados_venda){
				if (cliente.getCodigo() == venda.getCod_cliente() && venda.getMod_pagamento().equals("F")){
					for(Produto produto : dados_produto){
						if (venda.getCod_produto() == produto.getCodigo()){
							precoAReceber = precoAReceber + venda.calculaPreçoVenda(produto.calculaPreco());
							produto.diminuiEstoque(venda.getQuantidade());
						}
					}
				}
			}
			dadosCliente.add(Util.FormatPreco(precoAReceber, "R$0.00"));
			precoAReceber = 0;
			dadosAllCliente.add(dadosCliente);
			dadosCliente = new ArrayList<String>();
		}
		
		//Atualizo o estoque com as vendas de clientes que nao pagaram fiado 
		for(Venda venda : dados_venda){
			if (!venda.getMod_pagamento().equals("F")){
				for(Produto produto : dados_produto){
					if (venda.getCod_produto() == produto.getCodigo()){
						produto.diminuiEstoque(venda.getQuantidade());
					}
				}
			}
		}
		System.out.println(dadosAllCliente);
	}
	
	public void gera_estoque(){
		ArrayList<ArrayList<String>> dadosAllProduto = new ArrayList<ArrayList<String>>();
		ArrayList<String> dadosProduto = new ArrayList<String>();
		
		for(Produto produto : dados_produto){
			dadosProduto = new ArrayList<String>();
			dadosProduto.add(String.valueOf(produto.getCodigo()));
			dadosProduto.add(produto.getDescricao());
			if (produto.getEst_atual() < produto.getEst_min() ){
				dadosProduto.add(String.valueOf(produto.getEst_atual()));
				dadosProduto.add("COMPRAR MAIS");
			}else{
				dadosProduto.add(String.valueOf(produto.getEst_atual()));
			}
			dadosAllProduto.add(dadosProduto);
			
		}
		System.out.println(dadosAllProduto);
	}
	
	public void gera_vendasPorProduto(){
		ArrayList<ArrayList<String>> dadosAllVendasProduto = new ArrayList<ArrayList<String>>();
		ArrayList<String> dadosVendaProduto = new ArrayList<String>();
		double receitaBruta = 0;
		
		for(Produto produto : dados_produto){
			dadosVendaProduto.add(String.valueOf(produto.getCodigo()));
			dadosVendaProduto.add(produto.getDescricao());
			for (Venda venda : dados_venda){
				if (produto.getCodigo() == venda.getCod_produto()){
					receitaBruta = receitaBruta + venda.calculaPreçoVenda(produto.calculaPreco());
				}
			}
			double lucro = (receitaBruta * produto.getPct_lucro())/100;
			dadosVendaProduto.add(Util.FormatPreco(receitaBruta, "R$0.00"));
			dadosVendaProduto.add(Util.FormatPreco(lucro, "R$0.00"));
			dadosAllVendasProduto.add(dadosVendaProduto);
			dadosVendaProduto = new ArrayList<String>();
			receitaBruta = 0;
		}
		System.out.println(dadosAllVendasProduto);
	}
}
