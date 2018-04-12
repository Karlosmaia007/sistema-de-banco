import java.util.Date;

public class Cliente {
	
	public String nomeCliente = "";
	private  Date data; 
	
	
	public Cliente (String nomeCliente  ,Date data ){
		this.nomeCliente = nomeCliente ; 
		this.data = data ;
		
	}
	
	public void setNomeCliente(String nomeCliente){
		nomeCliente = nomeCliente ;
	}
	public String getNomeCliente(){
		return nomeCliente; 
	}
	
	public void setData(Date data){
		data = data;
	}
	public Date getData(){
		return data;
	}
	
	

}
