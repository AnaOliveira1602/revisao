package principal.daos;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import principal.modelo.Paciente;


public class PacienteDAO implements DAO<Paciente> {
	
	private EntityManager em;
	private EntityManagerFactory emf;

	
	public PacienteDAO() {
		emf = Persistence.createEntityManagerFactory("a1_mysql");
		em = emf.createEntityManager();
	}
	
	@Override
	public Paciente buscarPorId(Integer id) {
		Paciente paciente = em.find(Paciente.class, id);
		return paciente;
	}

	@Override
	public List<Paciente> listar() {
		List<Paciente> lista = em.createQuery("from Paciente", Paciente.class).getResultList();
		return lista;
	}

	@Override
	public Integer salvar(Paciente paciente) {
		em.getTransaction().begin();
		em.persist(paciente);
		em.getTransaction().commit();
		return paciente.getId();

	}

	@Override
	public Integer atualizar(Paciente paciente) {
		em.getTransaction().begin();
		em.merge(paciente);
		em.getTransaction().commit();
		return paciente.getId();
	}

	@Override
	public void apagar(Integer id) {
		Paciente c = em.find(Paciente.class, id);
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
