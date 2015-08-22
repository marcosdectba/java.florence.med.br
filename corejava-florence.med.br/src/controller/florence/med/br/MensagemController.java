package controller.florence.med.br;

	public class MensagemController implements Runnable{
		
		private String msg;
		public MensagemController(String mensagem) {
			// TODO Auto-generated constructor stub
			msg= mensagem;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Executando nova Thread com a mensagem: "+ msg);
		}
		
 
}
