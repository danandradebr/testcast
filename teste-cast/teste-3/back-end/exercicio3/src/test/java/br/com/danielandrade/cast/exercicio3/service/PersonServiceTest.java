package br.com.danielandrade.cast.exercicio3.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.danielandrade.cast.exercicio3.PersonTestFactory;
import br.com.danielandrade.cast.exercicio3.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc	
public class PersonServiceTest {
	
	@Autowired
	private PersonService service;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void notFound() throws Exception {
		Person person1 = service.salvar(PersonTestFactory.newPersonSimple("Person1"));
		Person personNotFound = service.obterPorId(person1.getId()+1);
		Person personFound = service.obterPorId(person1.getId());
		Assert.assertEquals((personNotFound), Matchers.isNull());
		Assert.assertEquals((personFound.getId()), person1.getId());
		service.excluir(person1.getId());
	}
	
	@Test
	public void savePersonComplete() throws Exception {
		Person person1 = service.salvar(PersonTestFactory.newPersonComplete("Person1", "Stret1", "4", "Sava", "BelZonte", "MG", "33456", "443"));
		Person personFound = service.obterPorId(person1.getId());
		Assert.assertThat(personFound.getName(), org.hamcrest.Matchers.is("Person1"));
		Assert.assertThat(personFound.getCellphone(), org.hamcrest.Matchers.is("33456"));
		Assert.assertThat(personFound.getCity(), org.hamcrest.Matchers.is("BelZonte"));
		Assert.assertThat(personFound.getNeighborhood(), org.hamcrest.Matchers.is("Sava"));
		Assert.assertThat(personFound.getNumber(), org.hamcrest.Matchers.is("4"));
		Assert.assertThat(personFound.getPhone(), org.hamcrest.Matchers.is("443"));
		Assert.assertThat(personFound.getState(), org.hamcrest.Matchers.is("MG"));
		Assert.assertThat(personFound.getStreet(), org.hamcrest.Matchers.is("Stret1"));
		service.excluir(personFound.getId());
	}
	
	@Test
	public void listFull()
	{
		service.salvar(PersonTestFactory.newPersonSimple("Person1"));
		service.salvar(PersonTestFactory.newPersonSimple("Person2"));
		service.salvar(PersonTestFactory.newPersonSimple("Person3"));
		List<Person> persons = service.obterTodos();
		Assert.assertEquals((persons.size()), 3l);
	}
	
	@Test
	public void remove()
	{
		Person person1 = service.salvar(PersonTestFactory.newPersonSimple("Person1"));
		service.excluir(person1.getId());
		Person personNotFound = service.obterPorId(person1.getId());
		Assert.assertEquals((personNotFound), Matchers.isNull());
	}
	 

}
