package leitordearquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import empresa.Cliente;
import empresa.Fornecedor;
import empresa.Venda;
import empresa.Produto;
import empresa.Compra;


public class Lercsv {
	
	public ArrayList<String[]> loadfile(String diretorio) {
		ArrayList<String[]> linha = new ArrayList<String[]>();
		String conteudo;
		String csv_divisor = ";";
		int i = 0;
	    BufferedReader br = null;
	    try {

	        br = new BufferedReader(new FileReader(diretorio));
	        while ((conteudo = br.readLine()) != null) {
	            linha.add(i, conteudo.split(csv_divisor));
	            i++;
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		return linha;
	  }
	
	public ArrayList<Cliente> le_e_cria_cliente(String diretorio){
		ArrayList<Cliente> array_cliente = new ArrayList<Cliente>();
		ArrayList<String[]> tabela = loadfile(diretorio);
		for(int i=1;i<tabela.size();i++){
			int codigo = Integer.parseInt(tabela.get(i)[0]);
			String nome = tabela.get(i)[1];
			String endereco = tabela.get(i)[2];
			String telefone = tabela.get(i)[3];
			String data = tabela.get(i)[4];
			String tipo = tabela.get(i)[5];
			String documento = tabela.get(i)[6];
			int estadual = 0;
			if (tipo.equals("J")){estadual = Integer.parseInt(tabela.get(i)[7]);}
			
			Cliente C = new Cliente(codigo, nome, endereco , telefone, data, tipo, documento, estadual);
			array_cliente.add(C);
		}
		
		return array_cliente;
	}
	
	public ArrayList<Fornecedor> le_e_cria_fornecedor(String diretorio){
		ArrayList<Fornecedor> array_fornecedor = new ArrayList<Fornecedor>();
		ArrayList<String[]> tabela = loadfile(diretorio);
		
		for(int i=1;i<tabela.size();i++){
			int codigo = Integer.parseInt(tabela.get(i)[0]);
			String nome = tabela.get(i)[1];
			String endereco = tabela.get(i)[2];
			String telefone = tabela.get(i)[3];
			String cnpj = tabela.get(i)[4];
			String contato = tabela.get(i)[5];
			
			Fornecedor F = new Fornecedor(codigo, nome, endereco , telefone, cnpj, contato);
			array_fornecedor.add(F);
		}
		
		return array_fornecedor;		
	}
	
	public ArrayList<Venda> le_e_cria_venda(String diretorio){
		ArrayList<Venda> array_venda = new ArrayList<Venda>();
		ArrayList<String[]> tabela = this.loadfile(diretorio);
		
		for(int i=1;i<tabela.size();i++){
			int codigo = 0;
			if (!tabela.get(i)[0].equals("")){codigo = Integer.parseInt(tabela.get(i)[0]);}
			String data = tabela.get(i)[1];
			int cod_produto = Integer.parseInt(tabela.get(i)[2]);
			int quantidade = Integer.parseInt(tabela.get(i)[3]);
			String mod_pagamento = tabela.get(i)[4];
			Venda V = new Venda(codigo, data, cod_produto , quantidade, mod_pagamento);
			array_venda.add(V);
		}
		
		return array_venda;		
	}
	
	public ArrayList<Compra> le_e_cria_compra(String diretorio){
		ArrayList<Compra> array_compra = new ArrayList<Compra>();
		ArrayList<String[]> tabela = this.loadfile(diretorio);
		
		for(int i=1;i<tabela.size();i++){
			int nf = Integer.parseInt(tabela.get(i)[0]);
			int cod_fornecedor = Integer.parseInt(tabela.get(i)[1]);
			String data_compra = tabela.get(i)[2];
			int cod_produto = Integer.parseInt(tabela.get(i)[3]);
			int quantidade = Integer.parseInt(tabela.get(i)[4]);
			
			Compra C = new Compra(nf, cod_fornecedor, data_compra , cod_produto, quantidade);
			array_compra.add(C);
		}
		
		return array_compra;		
	}
	
	public ArrayList<Produto> le_e_cria_produto(String diretorio){
		ArrayList<Produto> array_produto = new ArrayList<Produto>();
		ArrayList<String[]> tabela = loadfile(diretorio);
		
		for(int i=1;i<tabela.size();i++){
			int codigo = Integer.parseInt(tabela.get(i)[0]);
			String descricao = tabela.get(i)[1];
			int est_min = Integer.parseInt(tabela.get(i)[2]);
			int est_atual = Integer.parseInt(tabela.get(i)[3]);
			double custo = Double.parseDouble(tabela.get(i)[4].replace(",", "."));
			int pct_lucro = Integer.parseInt(tabela.get(i)[5]);
			
			Produto P = new Produto(codigo, descricao, est_min , est_atual, custo, pct_lucro);
			array_produto.add(P);
		}
		
		return array_produto;		
	}
	
}