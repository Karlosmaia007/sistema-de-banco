import java.util.Date;

public class ContaPoupanca extends Cliente {
	
	private int  numeroContaPoupanca;
	private Date dataAniversario ; 
	private double saldoCp ; 
 
	
	
	
	public ContaPoupanca(String nomeCliente  ,Date data ,double saldoCc, int  numeroContaPoupanca , Date dataAniversario, double saldoCp){
			super(nomeCliente , data);
		this.numeroContaPoupanca = numeroContaPoupanca; 
		 this.dataAniversario = dataAniversario ; 
		 this.saldoCp = saldoCp;
	}
	
	public void setNumeroContaPoupanca(int numCp){
		numeroContaPoupanca = numCp ; 
	}
	public int getNumeroContaPoupanca(){
		return numeroContaPoupanca ; 
	}
	
	public void setDataAniversario(Date dataNiver){
		dataAniversario = dataNiver ; 
	}
	public Date getDataAniversario(){
		return dataAniversario ; 
	}
	
	public void setSaldoCp(double saldoCp){
		saldoCp = saldoCp ; 
	}
	public double getSaldoCp(){
		return saldoCp ; 
	}

}
