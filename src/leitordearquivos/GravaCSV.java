package leitordearquivos;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import empresa.Fornecedor;

public class GravaCSV {
	
	public void createCsvFileApagar(){ 
		//A estrutura try-catch é usada pois o objeto BufferedWriter exige que as
		//excessões sejam tratadas
		try{
			//Criação de um buffer para a escrita em uma stream
			BufferedWriter StrW = new BufferedWriter(new FileWriter("C:\\Users\\magma_000\\Desktop\\1-apagar.csv"));
			StrW.write("Fornecedor;cnpj;pessoa de contato;telefone;Total a pagar\n");
			for(Fornecedor fornecedor : dados_fornecedor){
				System.out.println(fornecedor.getCod_fornecedor());
			}
			//Escrita dos dados da tabela
			StrW.write("Nome;Telefone;Idade\n"); 
			StrW.write("Juliana;6783-8490;23\n"); 
			StrW.write("Tatiana;6743-7480;45\n"); 
			StrW.write("Janice;6909-9380;21");
		
			//Fechamos o buffer
			StrW.close(); 
		}catch (FileNotFoundException ex)
		{
		ex.printStackTrace(); 
		}catch (IOException e)
		{
		e.printStackTrace(); } 
	}

}
