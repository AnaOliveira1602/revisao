package principal.daos;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import principal.modelos.*;


public class SequenciaDAO implements DAO<Sequencia> {
	
	private EntityManager em;
	private EntityManagerFactory emf;

	
	public SequenciaDAO() {
		emf = Persistence.createEntityManagerFactory("a1_mysql");
		em = emf.createEntityManager();
	}
	

	public Sequencia buscarPorId(Integer id) {
		Sequencia sequencia = em.find(Sequencia.class, id);
		return sequencia;
	}


	public List<Sequencia> listar() {
		List<Sequencia> lista = em.createQuery("from Sequencia", Sequencia.class).getResultList();
		return lista;
	}


	public Integer salvar(Sequencia sequencia) {
		em.getTransaction().begin();
		em.persist(sequencia);
		em.getTransaction().commit();
		return sequencia.getId();

	}


	public Integer atualizar(Sequencia sequencia) {
		em.getTransaction().begin();
		em.merge(sequencia);
		em.getTransaction().commit();
		return sequencia.getId();
	}


	public void apagar(Integer id) {
		Sequencia c = em.find(Sequencia.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
	}


	public void close() {
		em.close();
		emf.close();
		
	}



}