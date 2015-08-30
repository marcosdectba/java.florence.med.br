package view.florence.med.br;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import controller.florence.med.br.MensagemController;

public class ServerView {

	public static void main(String[] args) throws FileNotFoundException {

		int porta= 22222;
		String path= "C:\\Users\\Marcos Santos\\Documents\\config.cfg";
		String linha;
		String ipClient;
		
		System.out.println("Iniciando...\n");
		
		try {
			
			FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq); 
			
			linha = lerArq.readLine();
			String parametros[] = linha.split("="); 
			if(parametros[0].equals("porta")){
				
				try{
					
					porta = Integer.parseInt(parametros[1]); 
					
				}catch(Exception exception){
					
					System.out.println("Arquivo de configuração invalido, use portas entre 1025 e 65535. Utilizando valores padrões.\n");
					
				}
			}else{
				System.out.println("Parametros invalidos, use: porta=[1025-65535]\n");
			}
			
			//fechando arquivo e buffer de leitura
			lerArq.close();
			arq.close();
			
		}catch (IOException e) {
			
			System.out.println("Não foi possivel ler o arquivo de configuração, usando os valores padrões.\n");
			
		}
		
		try{
			//criando server 
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(porta);
			System.out.println("Escutando porta: "+porta+"\n");
			
			while(true){	
				
				System.out.println("Esperando por conexões...\n");
				Socket sockt = server.accept();
				ipClient = sockt.getInetAddress().getHostAddress();
				System.out.println("Nova conexão com: "+ ipClient);
				//Lendo dados enviados pelo client
				//variavel tam mostra o tamanho do buffer a ser lido, depois e criado um array de bytes que e convertido em string
				InputStream input = sockt.getInputStream();
				int tam = input.available();
				BufferedReader in = new BufferedReader(new InputStreamReader(input));
			    byte[] dados = new byte[tam];
			    input.read(dados);
			    String msgClient = new String(dados);
			    in.close(); 
				System.out.println("Dados recebidos, fim da leitura");
			//implementacao de  threads	
		     MensagemController novaThread = new MensagemController(msgClient, ipClient);
		     Thread mensagemControllerThread = new Thread(novaThread);
		     mensagemControllerThread.start();
			
			}
		}catch(Exception errorport){
			
			System.out.println("Erro ao abrir porta, verifique se a porta "+porta+" não está em uso por outro programa. Aplicação sendo encerrada.");
			
		}
	}
  
}


