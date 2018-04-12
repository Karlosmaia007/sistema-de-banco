import java.util.Date;

public class ContaCorrente extends Cliente {

	private int numContaCorrente;
	private double saldoCc ;

	public ContaCorrente(String nomeCliente, Date data,int numContaCorrent, double saldoCc) {
		super(nomeCliente, data);
		this.numContaCorrente = numContaCorrent;
		this.saldoCc = saldoCc ; 

	}

	public void setNumContaCorrente(int numConta) {
		numContaCorrente = numConta;
	}

	public int getNumContaCorrente() {
		return numContaCorrente;
	}
	
	public void setSaldoCc(double saldo){
		saldoCc = saldo;
	}
	public double getSaldoCc(){
		return saldoCc;
	}

}
