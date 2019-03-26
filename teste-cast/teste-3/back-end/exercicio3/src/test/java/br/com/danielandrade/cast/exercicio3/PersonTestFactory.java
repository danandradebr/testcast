package br.com.danielandrade.cast.exercicio3;


import br.com.danielandrade.cast.exercicio3.model.Person;

public class PersonTestFactory {
	
	public static Person newPersonComplete(String name, 
			String street,String number, String neighborhood, String city,
			String state, String cellphone,String phone)
	{
		Person newPerson = new Person();
		newPerson.setName(name);
		newPerson.setStreet(street);
		newPerson.setNumber(number);
		newPerson.setNeighborhood(neighborhood);
		newPerson.setCity(city);
		newPerson.setState(state);
		newPerson.setCellphone(cellphone);
		newPerson.setPhone(phone);
		return newPerson;
		
	}
	
	public static Person newPersonSimple(String name)
	{
		Person newPerson = new Person();
		newPerson.setName(name);
		return newPerson;
		
	}

}
