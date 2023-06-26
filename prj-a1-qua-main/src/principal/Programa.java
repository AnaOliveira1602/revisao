package principal;

import principal.modelo.*;
import principal.daos.*;

public class Programa {
	
	public static void main(String[] args) {
		
		PacienteDAO pdao = new PacienteDAO();
		
		Paciente p = new Paciente();
		
		Paciente p2 = pdao.buscarPorId(1);
		
		//pdao.salvar(p);
		
		MedicamentoDAO mdao = new MedicamentoDAO();
		
		Medicamento m1 = new Medicamento("Benztropina", p);
		Medicamento m2 = new Medicamento("Metocarbamol", p);
		
//		mdao.salvar(m1);
//		mdao.salvar(m2);
//		
//		p.addMed(m1);
//		p.addMed(m2);
//
//		p2.setNome("Pedro Silva");
//		pdao.atualizar(p);
		
		pdao.apagar(4);
		
		pdao.close();
		mdao.close();
		

		
	}
}
