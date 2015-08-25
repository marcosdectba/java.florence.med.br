package florence.med.br;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Iniciando servidor...");
		//laco para nao interromper execucao do server
		while(true){
			
			try{
				 ServerSocket servidor = new ServerSocket(22222);
			     System.out.println("Porta 22222 aberta, iniciado com sucesso!");
			     Socket cliente = servidor.accept();
			     
			     
			     //A ser implementado com uma thread
			     System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
			    
			     Scanner s = new Scanner(cliente.getInputStream());
			     
			     boolean linha= true;
			     
			     while ( linha == true) {	 
			       System.out.println(s.nextLine());
			       
			       if(s.hasNext()){
			    	   
			    	   System.out.println("Lendo");
			       }else{
			    	 
					   System.out.println("Encerrando");
			    	   break;
			       }
			       
			     }
			     
			     s.close();
		    	 servidor.close();
				 cliente.close();
			     
			     //A ser implementado com uma thread
				
			}catch(Exception e){
				System.out.println("Verifique se essa porta não está sendo usada por outro programa, encerrando...");
				System.out.println("Erro: "+ e);
				break;
			}	
		}
	}
}
