package principal;

import principal.modelos.*;
import principal.daos.*;

public class Programa {
	
	public static void main(String[] args) {
		
		IndividuoDAO pdao = new IndividuoDAO();
		
		Individuo p = new Individuo();
		
//		Individuo p = pdao.buscarPorId(1);
		
		//pdao.salvar(p);
		
		SequenciaDAO sdao = new SequenciaDAO();
		
		Sequencia s1 = new Sequencia("ABCD", p);
		
		sdao.salvar(s1);
//		
//		p.addSeq(s1);
//
		p.setNome("Pedro Silva");
//		pdao.atualizar(p);
		
		pdao.apagar(4);
		
		pdao.close();
		sdao.close();
		

		
	}
}