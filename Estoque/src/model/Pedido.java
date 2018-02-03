package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pedido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3431912354155218698L;
	
	@Id
	private int id_produto;
	private int id_cliente;
	
	public int getId_produto() {
		return id_produto;
	}
	
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}
	
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	
	
}
