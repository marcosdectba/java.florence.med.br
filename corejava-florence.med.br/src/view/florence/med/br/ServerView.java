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
				
				System.out.println("Arquivo de configura��o invalido, utilizando valores padr�es.");
				
			}
			
			lerArq.close();
			
		}catch (FileNotFoundException e) {
			
			System.out.println("N�o foi possivel ler o arquivo de configura��o, usando os valores padr�es.");
			
		}
		try{
			//criando server 
			ServerSocket server = new ServerSocket(porta);
			System.out.println("\nEscutando porta: "+porta+"\n");
			
			while(true){	
				System.out.println("Esperando por conex�es...\n");
				Socket sockt = server.accept();
				System.out.println("Nova conex�o com o cliente " + sockt.getInetAddress().getHostAddress()+"\n");
				
				
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
			
			System.out.println("Erro ao abrir porta, verifique se a porta "+porta+" n�o est� em uso por outro programa! Aplica��o sendo encerrada!");
			
		}
	}
  
}


