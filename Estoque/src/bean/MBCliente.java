package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import control.CtrlCliente;
import model.Cliente;
import servicos.Gerenciavel;

@ManagedBean(name="MBCliente")
@SessionScoped
public class MBCliente implements Gerenciavel, Serializable {

	/**
	 * O managedBean responsável pela conversação entre o control e o jsf.
	 * Intermediação do Cliente.
	 */
	private static final long serialVersionUID = -5353528350480182923L;
	
	private CtrlCliente controleCli = new CtrlCliente();
	
	private Cliente ultimoCli = new Cliente();
	private List<Cliente> clientes = new ArrayList<>();
		
	public Cliente getUltimoCli() {
		return ultimoCli;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setUltimoCli(Cliente ultimoCli) {
		this.ultimoCli = ultimoCli;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String adicionar() {
		// TODO Auto-generated method stub
				
		controleCli.adicionar(ultimoCli);
		ultimoCli = new Cliente();
		FacesMessage mensag = new FacesMessage("Cliente adicionado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		return "";
	}

	@Override
	public String alterar() {
		// TODO Auto-generated method stub
		
		controleCli.alterar(ultimoCli);
		ultimoCli = new Cliente();
		FacesMessage mensag = new FacesMessage("Cliente alterado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		return "";		
	}

	@Override
	public String consultar() {
		// TODO Auto-generated method stub
		
		setClientes(controleCli.consultar(ultimoCli.getNome()));
		FacesMessage mensag = new FacesMessage("Foram encontrados " + getClientes().size() + " clientes");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		if (getClientes().size() > 0) { 
			ultimoCli = getClientes().get(0);
		}
		
		return "";
	}

	@Override
	public String excluir() {
		// TODO Auto-generated method stub
		
		controleCli.excluir(ultimoCli);
		ultimoCli = new Cliente();
		FacesMessage mensag = new FacesMessage("Cliente deletado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		return "";
	}

	@Override
	public String todos() {
		// TODO Auto-generated method stub
		
		setClientes(controleCli.todosEles());
		FacesMessage mensag = new FacesMessage("Foram encontrados " + getClientes().size() + " clientes");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		if (getClientes().size() > 0) { 
			ultimoCli = getClientes().get(0);
		}
		
		return "";
	}

}
