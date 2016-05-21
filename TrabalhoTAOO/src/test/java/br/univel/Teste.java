package br.univel;

import br.univel.common.Dao;
import br.univel.dao.AdressDao;
import br.univel.dao.ClientDao;
import br.univel.model.Address;
import java.util.Date;

import org.hibernate.Session;

import br.univel.model.Client;
import br.univel.util.HibernateUtil;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.hibernate.criterion.Restrictions;

public class Teste {
	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//
//		session.beginTransaction();

		Client cliente = new Client();
		cliente.setName("Juliano");
		cliente.setLastName("Grams");
		cliente.setBirthDate(new Date(1995, 3, 6));
    
		Client cliente2 = new Client();
		cliente2.setName("Abraham");
		cliente2.setLastName("burnes");
		cliente2.setBirthDate(new Date(1980, 5, 16));
		
    
		Client cliente3 = new Client();
		cliente3.setName("Mario");
		cliente3.setLastName("Silva");
		cliente3.setBirthDate(new Date(1975, 9, 1));
		cliente3.setBirthDate(new Date(1975, 9, 1));
    
		Client cliente4 = new Client();
		cliente4.setName("Flavio");
		cliente4.setLastName("Moura");
		cliente4.setBirthDate(new Date(1965, 12, 23));
		cliente4.setBirthDate(new Date(1965, 12, 23));
    
    Address address = new Address();
    
    cliente2.setAddress(address);
    cliente3.setAddress(address);
    cliente4.setAddress(address);
    
    
    address.setNumber(1262);
    address.setStreet("Alexandre de Gusmão");
    address.setClients(Arrays.asList(cliente2, cliente3, cliente4));
    
    Dao clienteDao = new ClientDao();
    Dao addressDao = new AdressDao();
    addressDao.create(address);
    
    cliente.setAddress(address);
    clienteDao.create(cliente);
    
    cliente.setBirthDate(new Date(new GregorianCalendar(1995, 3, 6).getTimeInMillis()));
    
    clienteDao.update(cliente);
    
    clienteDao.delete(cliente3);
    Address a = (Address) addressDao.read(Restrictions.eq("id", 1l)).get(0);
    JOptionPane.showMessageDialog(null, a.getStreet());
    
    
		HibernateUtil.finalizar();
	}
}
