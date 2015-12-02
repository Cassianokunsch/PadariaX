import empresa.Relatorio;

public class Main {
	
	public static void main(String[] args) {
		
	
		String dir_cliente = "C:\\Users\\magma_000\\workspace\\Trabalho\\src\\clientes.csv";
		String dir_venda = "C:\\Users\\magma_000\\workspace\\Trabalho\\src\\vendas.csv";
		String dir_compra = "C:\\Users\\magma_000\\workspace\\Trabalho\\src\\compras.csv";
		String dir_produto = "C:\\Users\\magma_000\\workspace\\Trabalho\\src\\produtos.csv";
		String dir_fornecedor = "C:\\Users\\magma_000\\workspace\\Trabalho\\src\\fornecedores.csv";
		
		Relatorio rat = new Relatorio(dir_cliente, dir_venda, dir_compra, dir_produto, dir_fornecedor);
		//rat.gera_a_pagar_fornecedor();
		//rat.gera_a_receber_cliente();
		//rat.gera_estoque();
		rat.gera_vendasPorProduto();
	}
	
}
