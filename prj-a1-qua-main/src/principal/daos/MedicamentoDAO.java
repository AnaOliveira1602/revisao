package principal.daos;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import principal.modelo.Medicamento;


public class MedicamentoDAO implements DAO<Medicamento> {
	
	private EntityManager em;
	private EntityManagerFactory emf;

	
	public MedicamentoDAO() {
		emf = Persistence.createEntityManagerFactory("a1_mysql");
		em = emf.createEntityManager();
	}
	
	@Override
	public Medicamento buscarPorId(Integer id) {
		Medicamento medicamento = em.find(Medicamento.class, id);
		return medicamento;
	}

	@Override
	public List<Medicamento> listar() {
		List<Medicamento> lista = em.createQuery("from Medicamento", Medicamento.class).getResultList();
		return lista;
	}

	@Override
	public Integer salvar(Medicamento medicamento) {
		em.getTransaction().begin();
		em.persist(medicamento);
		em.getTransaction().commit();
		return medicamento.getId();

	}

	@Override
	public Integer atualizar(Medicamento medicamento) {
		em.getTransaction().begin();
		em.merge(medicamento);
		em.getTransaction().commit();
		return medicamento.getId();
	}

	@Override
	public void apagar(Integer id) {
		Medicamento c = em.find(Medicamento.class, id);
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
