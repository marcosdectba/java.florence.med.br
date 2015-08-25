package view.florence.med.br;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

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
				
				System.out.println("Arquivo de configuração invalido, utilizando valores padrões.");
				
			}
			
			lerArq.close();
			
		}catch (FileNotFoundException e) {
			
			System.out.println("Não foi possivel ler o arquivo de configuração, usando os valores padrões.");
			
		}
		try{
			//criando server 
			ServerSocket server = new ServerSocket(porta);
			System.out.println("\nEscutando porta: "+porta+"\n");
			
			while(true){	
				System.out.println("Esperando por conexões...\n");
				Socket sockt = server.accept();
				System.out.println("Nova conexão com o cliente " + sockt.getInetAddress().getHostAddress()+"\n");
				
				
				InputStream input = sockt.getInputStream();
				int tam = input.available();
				//input.read();
				System.out.println("Qta de bytes a ler: "+tam);
				
				BufferedReader in = new BufferedReader(new InputStreamReader(input));
		 
			    byte[] arg0 = new byte[tam];
				//System.out.println(aux);
			    input.read(arg0);
			    //System.out.println(Arrays.toString(arg0));
			    String teste = new String(arg0);
			    System.out.println(teste);
			    //s = input.read();
			    in.close(); 
				System.out.println("Dados recebdos, fim da leitura");
		    // MensagemController novaThread = new MensagemController(msg);
		    // novaThread.run();
			
			}
		}catch(Exception errorport){
			
			System.out.println("Erro ao abrir porta, verifique se a porta "+porta+" não está em uso por outro programa! Aplicação sendo encerrada!");
			
		}
	}
  
}


