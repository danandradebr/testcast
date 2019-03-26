package br.com.danielandrade.cast.exercicio3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielandrade.cast.exercicio3.model.Person;
import br.com.danielandrade.cast.exercicio3.repository.PersonRepository;

/**
* @author Daniel Andrade
*/


@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
//	@PersistenceContext
//    private EntityManager em;
	
	 @Autowired
	 private EntityManagerFactory emf;

	public List<Person> obterTodos() {
		List<Person> persons = getTransaction().unwrap(Session.class)
				.createCriteria(Person.class)
				.list();
		
		return persons;
	}

	public Person obterPorId(Long id) {
		return repository.findOne(id);
	}

	@Transactional
	public Person salvar(Person newPerson) {
		Person p = repository.save(newPerson);
		return p;
	}

	@Transactional
	public void excluir(Long id) {
		repository.delete(id);
	}
	
	@Transactional
	public void excluirTodos() {
		repository.deleteAll();
	}

	private EntityManager getTransaction()
	{
		return emf.createEntityManager();
	}

}
