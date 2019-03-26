package br.com.danielandrade.cast.exercicio3.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.danielandrade.cast.exercicio3.model.Person;


public interface PersonRepository extends CrudRepository<Person, Long>{

}
