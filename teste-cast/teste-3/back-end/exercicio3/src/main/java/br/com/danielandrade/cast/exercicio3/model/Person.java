package br.com.danielandrade.cast.exercicio3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**Classe da entidade Person que será persistida no banco de dados.
* @author Daniel Andrade
*/

@Entity(name = "person")
public class Person {
	
	@Id
    @GeneratedValue
    @Column(nullable=false)
    private Long id;
	@Column(nullable=false)
    private String name;
	@Column
	private String street;
	@Column
	private String number;
	@Column
	private String neighborhood;
	@Column
	private String city;
	@Column
	private String state;
	@Column	
	private String cellphone;
	@Column
	private String phone;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
