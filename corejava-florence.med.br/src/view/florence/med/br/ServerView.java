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
			//criando server 
			ServerSocket servidor = new ServerSocket(porta);
			System.out.println("\nEscutando porta: "+porta+"\n");
			
			while(true){
				System.out.println("Esperando por conex�es...\n");
				Socket cliente = servidor.accept();
				System.out.println("Nova conex�o com o cliente " + cliente.getInetAddress().getHostAddress()+"\n");
				Scanner leitura = new Scanner(cliente.getInputStream());
				//N�o est� saindo do la�o, sempre verdadeiro
					while (true) {
		               //msg = leitura.next();
						//testa, se conteudo acabou de ser transmitodo encerra conex�o
						if(leitura.hasNext() ){
							System.out.println("Ainda lendo...");
							msg=(leitura.next());
			                System.out.println(msg);
						}else{
							System.out.println("Leitura terminada\n");
							cliente.close();
							leitura.close();
							break;
						}
					}
					
		     
		    // MensagemController novaThread = new MensagemController(msg);
		    // novaThread.run();
			}
		     
		}catch(Exception errorport){
			
			System.out.println("Erro ao abrir porta, verifique se a porta "+porta+" n�o est� em uso por outro programa! Aplica��o sendo encerrada!");
			
		}
	}
  
}


