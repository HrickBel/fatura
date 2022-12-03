import java.util.*;

class Main{
	public static void main(String args[]){
		Fatura fat = new Fatura();
		boolean fecharFatura = true;

		while (fecharFatura != false) {
			Scanner scn = new Scanner(System.in);
			System.out.println("\tOPCOES\nA- adicionar a fatura\nC-cancelar fatura\nM-mostrar fatura\nF-fechar fatura\nL-limpar Console");
			char opt = scn.next().charAt(0);
			switch(opt){
				case 'A':
				case 'a':
					fat.addFatura();
					break;
				case 'C':
				case 'c':
					fat = null;
					break;
				case 'F':
				case 'f':
					fat.fatura();
					fecharFatura = false;
					break;
				case 'M':
				case 'm':
					fat.fatura();
					break;
				case 'L':
				case 'l':
					System.out.print("\033[H\033[2J");
					System.out.flush();
					break; 
				default:
					System.out.println("opcao invalida!\n");
					break;
			}
		}
	}
}