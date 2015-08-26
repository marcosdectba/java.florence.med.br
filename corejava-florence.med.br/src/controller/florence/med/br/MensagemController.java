package controller.florence.med.br;

	public class MensagemController implements Runnable{
		
		private String msg;
		public MensagemController(String mensagem) {
			// TODO Auto-generated constructor stub
			msg = mensagem;
			
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Executando nova Thread com a mensagem: "+ msg);
			for(int aux=0; aux< 1000;aux++){
				
				System.out.println(aux);
				
				try {
					
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
 
}
