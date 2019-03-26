package br.com.danielandrade.cast.exercicio3.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.danielandrade.cast.exercicio3.PersonTestFactory;
import br.com.danielandrade.cast.exercicio3.model.Person;
import br.com.danielandrade.cast.exercicio3.service.PersonService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonControllerIntegrationTest {

	@Autowired
	private PersonService service;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void pesquisarTodos() throws Exception
	{
		service.salvar(PersonTestFactory.newPersonSimple("Person1"));
		service.salvar(PersonTestFactory.newPersonSimple("Person2"));
		String body = this.restTemplate.getForObject("/rest/pessoas", String.class);
		assertThat(body).contains("Person1");
		assertThat(body).contains("Person2");
		service.excluirTodos();
	}
	
	@Test
	public void pequisar() {
		Person p = service.salvar(PersonTestFactory.newPersonSimple("Person1"));
		Person body = this.restTemplate.getForObject("/rest/pessoa/"+p.getId(), Person.class);
		assertThat(body.getId()).isEqualTo(p.getId());
		service.excluirTodos();
	}
	
	@Test
	public void cadastrar() {
		Person p = PersonTestFactory.newPersonSimple("Person3");
		Person body = this.restTemplate.postForObject("/rest/pessoa/save", p, Person.class);
		assertThat(body.getName()).isEqualTo("Person3");
		assertThat(body.getId()).isNotNull();
		service.excluirTodos();
	}
	
	@Test
	public void excluir() {
		Person p = service.salvar(PersonTestFactory.newPersonSimple("Person4"));
		this.restTemplate.delete("/rest/pessoa/remove/"+p.getId());
		Person pNotFound = service.obterPorId(p.getId());
		assertThat(pNotFound).isNull();
	}
	
	
}
