package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Pedido;

public class CtrlPedido {
	
	/**
	 * Classe respons�vel pelo controle de pedido, onde temos o CRUD.
	 */

	private EntityManagerFactory fabric;
	private EntityManager gerenciador;
	
	public CtrlPedido() {
		
		fabric = Persistence.createEntityManagerFactory("estoque");
		
	}
	
	public void adicionar(Pedido ped) {
		
		gerenciador = fabric.createEntityManager();
		
		gerenciador.getTransaction().begin();
		gerenciador.persist(ped);
		gerenciador.getTransaction().commit();
		gerenciador.close();
		
	}
	
	public void alterar(Pedido ped) {
		
		gerenciador = fabric.createEntityManager();
		
		gerenciador.getTransaction().begin();
		gerenciador.merge(ped);
		gerenciador.getTransaction().commit();
		gerenciador.close();
		
	}
	
	public void excluir(Pedido ped) {
		
		gerenciador = fabric.createEntityManager();
		
		Query query = gerenciador.createQuery("delete from Pedido ped where"
				+ " ped.id_produto = :entrada1 and ped.id_cliente = :entrada2");
		query.setParameter("entrada1", ped.getId_produto());
		query.setParameter("entrada2", ped.getId_cliente());
		gerenciador.close();
		
	}
	
	public List<Pedido> consultar(int entrada1, int entrada2) {
		
		gerenciador = fabric.createEntityManager();
		
		TypedQuery<Pedido> query = gerenciador.createQuery(
				"select ped from Pedido ped where ped.id_produto = :n1 and ped.id_cliente = :n2", 
				Pedido.class);
		query.setParameter("n1", entrada1);
		query.setParameter("n2", entrada2);
		List<Pedido> lista = query.getResultList();
		gerenciador.close();
		
		return lista;
		
	}
	
	public List<Pedido> todosEles() {
		
		gerenciador = fabric.createEntityManager();
		
		TypedQuery<Pedido> query = gerenciador.createQuery(
				"select ped from Pedido ped", 
				Pedido.class);
		List<Pedido> lista = query.getResultList();
		gerenciador.close();
		
		return lista;
		
	}
	
}