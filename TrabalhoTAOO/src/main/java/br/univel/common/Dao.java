/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.common;

import br.univel.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author juliano
 */
public class Dao<Model> {

  private Class<Model> model;

  public Dao() {
    model =  (Class<Model>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  public void create(Model model) {

    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.persist(model);
    session.getTransaction().commit();
    session.close();
//    HibernateUtil.finalizar();
  }

  public List<Model> read(Criterion criterion) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Model> list = session.createCriteria(model).add(criterion).list();
    session.getTransaction().commit();
    session.close();
//    HibernateUtil.finalizar();
    return list;
  }

  public void update(Model model) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.saveOrUpdate(model);
    session.getTransaction().commit();
    session.close();
//    HibernateUtil.finalizar();
  }
  
  public void delete(Model model){
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.delete(model);
    session.getTransaction().commit();
    session.close();
//    HibernateUtil.finalizar();
  }
}
