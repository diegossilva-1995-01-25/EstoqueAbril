package servicos;

public interface Gerenciavel {

	/**
	 * Interface usada para fornecer os m�todos aos managedBeans 
	 */
	
	public String adicionar();
	public String alterar();
	public String consultar();
	public String excluir();
	public String todos();
	
}
