package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import control.CtrlProduto;
import model.Produto;
import servicos.Gerenciavel;

@ManagedBean(name="MBProduto")
@SessionScoped
public class MBProduto implements Gerenciavel, Serializable {

	/**
	 * O managedBean responsável pela conversação entre o control e o jsf.
	 * Intermediação do Produto.
	 */
	private static final long serialVersionUID = -4630811472577673767L;
	
	private CtrlProduto controleProd = new CtrlProduto();
	
	private Produto ultimoProd = new Produto();
	private List<Produto> produtos = new ArrayList<>();
	
	public Produto getUltimoProd() {
		return ultimoProd;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setUltimoProd(Produto ultimoProd) {
		this.ultimoProd = ultimoProd;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String adicionar() {
		// TODO Auto-generated method stub
				
		controleProd.adicionar(ultimoProd);
		ultimoProd = new Produto();
		FacesMessage mensag = new FacesMessage("Produto adicionado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		return "";
	}

	@Override
	public String alterar() {
		// TODO Auto-generated method stub
		
		controleProd.alterar(ultimoProd);
		ultimoProd = new Produto();
		FacesMessage mensag = new FacesMessage("Produto alterado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		return "";		
	}

	@Override
	public String consultar() {
		// TODO Auto-generated method stub
		
		setProdutos(controleProd.consultar(ultimoProd.getNome()));
		FacesMessage mensag = new FacesMessage("Foram encontrados " + getProdutos().size() + " Produtos");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		if (getProdutos().size() > 0) { 
			ultimoProd = getProdutos().get(0);
		}
		
		return "";
	}

	@Override
	public String excluir() {
		// TODO Auto-generated method stub
		
		controleProd.excluir(ultimoProd);
		ultimoProd = new Produto();
		FacesMessage mensag = new FacesMessage("Produto deletado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		return "";
	}

	@Override
	public String todos() {
		// TODO Auto-generated method stub
		
		setProdutos(controleProd.todosEles());
		FacesMessage mensag = new FacesMessage("Foram encontrados " + getProdutos().size() + " Produtos");
		FacesContext.getCurrentInstance().addMessage(null, mensag);
		
		if (getProdutos().size() > 0) { 
			ultimoProd = getProdutos().get(0);
		}
		
		return "";
	}
	
}
