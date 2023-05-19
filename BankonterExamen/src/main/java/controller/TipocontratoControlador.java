package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Tipocontrato;
import model.Usuario;

public class TipocontratoControlador {

private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BankonterExamen");
	
	public static List<Tipocontrato> findAll() {	
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM tipocontrato", Tipocontrato.class);
		List<Tipocontrato> l = (List<Tipocontrato>) q.getResultList();
		
		em.close();
		return l;
	}
	
	public static List<Tipocontrato> findById (int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM tipocontrato where id like ?", Tipocontrato.class);
		q.setParameter(1, "%" + id + "%");
		List<Tipocontrato> l = (List<Tipocontrato>) q.getResultList();
		
		em.close();
		return l;
	}
}
