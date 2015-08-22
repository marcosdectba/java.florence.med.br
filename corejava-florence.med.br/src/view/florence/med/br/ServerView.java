package view.florence.med.br;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import controller.florence.med.br.MensagemController;

public class ServerView {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int porta= 22222;
		String path= "C:\\Users\\Marcos Santos\\Documents\\config.cfg";
		String linha;
		String msg = "";
		System.out.println("\nIniciando...\n");
		
		try {
			
			FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq); 
			
			linha = lerArq.readLine();
			try{
				//Futuras implementacoes de carregamento de parametros devem ser implementadas aqui
				porta = Integer.parseInt(linha); 
				
			}catch(Exception eio){
				
				System.out.println("Arquivo de configura��o invalido, utilizando valores padr�es.");
				
			}
			
			lerArq.close();
			
		}catch (FileNotFoundException e) {
			
			System.out.println("N�o foi possivel ler o arquivo de configura��o, usando os valores padr�es.");
			
		}
		try{
			
			//implemeta��es com threads devem ser feitas aqui
			ServerSocket servidor = new ServerSocket(porta);
			System.out.println("\nEscutando porta: "+porta+"\n");
			
			while(true){
			System.out.println("Esperando por conex�es...");
			Socket cliente = servidor.accept();
			System.out.println("Nova conex�o com o cliente " + cliente.getInetAddress().getHostAddress());
			Scanner leitura = new Scanner(cliente.getInputStream());
		     while (leitura.hasNextLine()) {
		    	 //Concatenar tudo em uma string
		       // msg = (msg+leitura.nextLine());
		    	  System.out.println(leitura.nextLine());
		         
		     }
		     
		     leitura.close();
		     servidor.close();
		     System.out.println("Valor da variavel msg: "+msg);
		     MensagemController novaThread = new MensagemController(msg);
		     novaThread.run();
			}
		     
		}catch(Exception errorport){
			
			System.out.println("Erro ao abrir porta, verifique se a porta "+porta+" n�o est� em uso por outro programa! Aplica��o sendo encerrada!");
			
		}
	}
  
}


