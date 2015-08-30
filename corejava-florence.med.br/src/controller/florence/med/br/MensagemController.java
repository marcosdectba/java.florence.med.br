package controller.florence.med.br;

	public class MensagemController implements Runnable{
		
		private String mensagem;
		private String ipClient;
		
		public MensagemController(String mensagem,String ipClient) {
			// TODO Auto-generated constructor stub
			this.mensagem = mensagem;
			this.ipClient = ipClient;
			
		}
		@Override
		public void run() {
			//Lendo e trocando caracteres
			//System.out.println("Mensagem original: "+mensagem);
			//mensagem = mensagem.replace("|", " ");
			//mensagem = mensagem.replace("^", " ");
			//mensagem = mensagem.replace("&", " ");
			//mensagem = mensagem.replace("\\", " ");
			System.out.println(mensagem);
			if(mensagem.contains("ADT^A04")){
				System.out.println("Mensagem de inclusão de paciente recebida");
				incluirPaciente(mensagem);
			}else{
				System.out.println("Mensagem com operação invalida");
			}
			
			//String linha[] = mensagem.split("="); 
			
			}
		public boolean incluirPaciente(String mensagem){
			
			return true;
			
		}
		
		
 
}
