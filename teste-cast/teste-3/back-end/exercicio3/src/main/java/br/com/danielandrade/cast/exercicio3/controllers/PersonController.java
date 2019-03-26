package br.com.danielandrade.cast.exercicio3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielandrade.cast.exercicio3.model.Person;
import br.com.danielandrade.cast.exercicio3.service.PersonService;

/**Classe PersonController que disponibiza os serviços para serem consumidos .
* @author Daniel Andrade
*/

@RestController
@RequestMapping(path = "/rest")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	 /**Método que consulta todas as pessoas 
	 * @return List<Person>
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pessoas")
	public List<Person> list() {
		return service.obterTodos();
	}	
	 
	/**Método que consulta uma pessoa 
	 * @param id Long - Id da pessoa a ser consultada.
	 * @return Person
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pessoa/{id}")
	public Person obterPorId(@PathVariable Long id) {
		Person j = service.obterPorId(id);
		return j;
	}
	
	/**Método que salva um novo registro de pessoa 
	 * @param person Person - pessoa sem o id.
	 * @return Person - com o id
	 */
	@RequestMapping(method = RequestMethod.POST,  value = "/pessoa/save")
	public Person salvar(@RequestBody Person newPerson) {
		return service.salvar(newPerson);
	}
	
	/**Método que exclui um registro de pessoa 
	 * @param id Long-  Id da pessoa a ser excluida.
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/pessoa/remove/{id}")
	public void excluir(@PathVariable Long id) {
		service.excluir(id);
	}

}
