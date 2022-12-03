import java.util.*;

class Fatura{
	private String numero;
	private String descricao;
	private int qntd;
	private int ind;
	private double preco;

	private Fatura proximo;
	private Fatura inicio;
	private Fatura novo;
	private Fatura fim;

	Fatura(String numero,String descricao,int qntd,double preco){//construtor manual
		setNumero(numero);
		setDescricao(descricao);
		setQntd(qntd);
		setPreco(preco);
	}

	Fatura(){ind = 0;};
	//metodos set e get
	private void setNumero(String numero){this.numero = numero;}

	private void setDescricao(String descricao){this.descricao = descricao;}

	private void setQntd(int qntd){this.qntd = qntd;}

	private void setPreco(double preco){this.preco = preco * qntd;}

	public String getNumero(){return numero;}

	public String getDescricao(){return descricao;}

	public int getQntd(){return qntd;}

	public double getPreco(){return preco;}
	//comportamentos

	public Fatura injectFatura(){
		Scanner scn = new Scanner(System.in);
		Fatura gen = new Fatura();
		System.out.println("Informe a descricao do produto:");
		gen.descricao = scn.nextLine();
		System.out.println("Informe o codigo do produto:");
		gen.numero = scn.next();
		System.out.println("Informe a quantidade do produto:");
		gen.qntd = scn.nextInt();
		System.out.println("Informe o preco por unidade do produto:");
		gen.preco = scn.nextDouble();

		return gen;
	}

	public void addFatura(){
		if(ind == 0){
			inicio = new Fatura();
			inicio = injectFatura();
			fim = inicio;
			fim.proximo = null;
			ind++;
		}else{
			novo = new Fatura();
			novo = injectFatura();
			novo.proximo = null;
			fim.proximo = novo;
			fim = novo;
		}
	}

	public void fatura(){
		Fatura aux = inicio;
		double totalPreco = 0.0;
		while (aux != null){
			if(aux.preco > 0.0 && aux.qntd > 0){
				System.out.printf("descricao:%s\nnumero:%s\tquantidade:%d\npreco p/unidade:%f\tpreco total:%f\n",aux.getDescricao(),aux.getNumero(),aux.getQntd(),aux.getPreco(),aux.getPreco()*aux.getQntd());
				totalPreco += aux.qntd*aux.preco;
				aux = aux.proximo;
			}else if(aux.qntd < 0){
				aux.qntd = 0;
				System.out.printf("descricao:%s\nnumero:%s\tquantidade:%d\npreco p/unidade:%f\tpreco total:%f\n",aux.getDescricao(),aux.getNumero(),aux.getQntd(),aux.getPreco(),aux.getPreco()*aux.getQntd());
				aux = aux.proximo;
			}else if(aux.preco < 0.0){
				aux.preco = 0.0;
				System.out.printf("descricao:%s\nnumero:%s\tquantidade:%d\npreco p/unidade:%f\tpreco total:%f\n",aux.getDescricao(),aux.getNumero(),aux.getQntd(),aux.getPreco(),aux.getPreco()*aux.getQntd());
				aux = aux.proximo;
			}
		}
		System.out.printf("\tTotal:%f\n",totalPreco);
	}
}