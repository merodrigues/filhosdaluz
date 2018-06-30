package br.org.filhosdaluz.sistema.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.org.filhosdaluz.sistema.model.Associado;
import br.org.filhosdaluz.sistema.model.Financeiro;
import br.org.filhosdaluz.sistema.model.Usuario;
import br.org.filhosdaluz.sistema.repository.FinanceiroRepository;

@Service("financeiroService")

public class FinanceiroServiceImpl	implements FinanceiroService  {
		
		@Autowired
		private FinanceiroRepository financeiroRepository;
		
		@PersistenceContext
		private EntityManager entityManager;
		
		public void setFinanceiroRepository(FinanceiroRepository financeiroDao) {
			this.financeiroRepository = financeiroDao;
		}

		
		@Override
		public Financeiro salvar(Financeiro financeiro) {
	     
	        return financeiroRepository.save(financeiro);
		}
		
		@Override
		public void excluir(Long id) {
			financeiroRepository.delete(id);
		}

		@Override
		public Financeiro pesquisarPorId(Long id) {
			return financeiroRepository.findOne(id);
		}
		
		@Override
		public List<Financeiro> pesquisarPorDescricao(String descricao) {
			return financeiroRepository.findByDescricaoContainingIgnoreCase(descricao);
		}
		
		@Override
		public List<Financeiro> todos() {
			Iterable<Financeiro> todos = financeiroRepository.findAll();
			List<Financeiro> retorno = new ArrayList<Financeiro>();
			for(Financeiro financeiro: todos) {
				retorno.add(financeiro);
			}
			return retorno;
		}
		
		
	
		@SuppressWarnings({ "unchecked", "unused" })
		@Override
		public List<Financeiro> pesquisarPorDatas(Date dataInicial, Date dataFinal) {
		
			System.out.println("Data Service" + dataInicial);
			System.out.println("Data Service" + dataFinal);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			String data1 = sf.format(dataInicial);
			String data2 = sf.format(dataFinal);
			// Query query = entityManager.createQuery("From Financeiro");
			Query query = entityManager.createQuery("SELECT e FROM Financeiro e WHERE e.dataVencimento BETWEEN :inicial AND :final ");
			//Query query = entityManager.createQuery("SELECT e FROM Financeiro e ORDER BY e.dataVencimento");
			query.setParameter("inicial", dataInicial);
			query.setParameter("final", dataFinal);
			List<Financeiro> ret = query.getResultList();
			
			return ret;
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
