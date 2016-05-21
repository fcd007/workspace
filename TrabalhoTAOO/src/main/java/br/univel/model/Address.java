package br.univel.model;

import java.io.Serializable;
import java.util.Collection;
import javafx.print.Collation;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address implements Serializable{
  
  @Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
  
  @Column(name = "street")
  private String street;
  
  @Column(name = "number")
  private Integer number;
  
  @OneToMany(mappedBy = "address", targetEntity = Client.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Collection<Client> clients;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Collection<Client> getClients() {
    return clients;
  }

  public void setClients(Collection<Client> clients) {
    this.clients = clients;
  }
  
  
  
  
}
