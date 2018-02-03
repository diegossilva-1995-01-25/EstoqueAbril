package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import control.CtrlPedido;
import model.Pedido;
import servicos.Gerenciavel;

@ManagedBean(name="MBPedido")
@SessionScoped
public class MBPedido implements Gerenciavel, Serializable {

	/**
	 * O managedBean responsável pela conversação entre o control e o jsf.
	 * Intermediação do Pedido.
	 */
	private static final long serialVersionUID = 3288079959463904200L;
	
	private CtrlPedido controlePed = new CtrlPedido();
	
	private Pedido ultimoPed = new Pedido();
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Pedido getUltimoPed() {
		return ultimoPed;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setUltimoPed(Pedido ultimoPed) {
		this.ultimoPed = ultimoPed;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String adicionar() {
		// TODO Auto-generated method stub
				
		controlePed.adicionar(ultimoPed);
		ultimoPed = new Pedido();
		FacesMessage mensag = new FacesMessage("Pedido adicionado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		return "";
	}

	@Override
	public String alterar() {
		// TODO Auto-generated method stub
		
		controlePed.alterar(ultimoPed);
		ultimoPed = new Pedido();
		FacesMessage mensag = new FacesMessage("Pedido alterado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		return "";		
	}

	@Override
	public String consultar() {
		// TODO Auto-generated method stub
		
		setPedidos(controlePed.consultar(ultimoPed.getId_produto(), ultimoPed.getId_cliente()));
		FacesMessage mensag = new FacesMessage("Foram encontrados " + getPedidos().size() + " Pedidos");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		if (getPedidos().size() > 0) { 
			ultimoPed = getPedidos().get(0);
		}
		
		return "";
	}

	@Override
	public String excluir() {
		// TODO Auto-generated method stub
		
		controlePed.excluir(ultimoPed);
		ultimoPed = new Pedido();
		FacesMessage mensag = new FacesMessage("Pedido deletado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		return "";
	}

	@Override
	public String todos() {
		// TODO Auto-generated method stub
		
		setPedidos(controlePed.todosEles());
		FacesMessage mensag = new FacesMessage("Foram encontrados " + getPedidos().size() + " Pedidos");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		if (getPedidos().size() > 0) { 
			ultimoPed = getPedidos().get(0);
		}
		
		return "";
	}
	
}
