package principal.daos;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import principal.modelos.*;


public class IndividuoDAO implements DAO<Individuo> {
	
	private EntityManager em;
	private EntityManagerFactory emf;

	
	public IndividuoDAO() {
		emf = Persistence.createEntityManagerFactory("a1_mysql");
		em = emf.createEntityManager();
	}
	
	@Override
	public Individuo buscarPorId(Integer id) {
		Individuo individuo = em.find(Individuo.class, id);
		return individuo;
	}

	@Override
	public List<Individuo> listar() {
		List<Individuo> lista = em.createQuery("from Individuo", Individuo.class).getResultList();
		return lista;
	}

	@Override
	public Integer salvar(Individuo individuo) {
		em.getTransaction().begin();
		em.persist(individuo);
		em.getTransaction().commit();
		return individuo.getId();

	}

	@Override
	public Integer atualizar(Individuo individuo) {
		em.getTransaction().begin();
		em.merge(individuo);
		em.getTransaction().commit();
		return individuo.getId();
	}

	@Override
	public void apagar(Integer id) {
		Individuo c = em.find(Individuo.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
	}

	@Override
	public void close() {
		em.close();
		emf.close();
		
	}



}