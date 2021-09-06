package com.ivoronline.springboot_db_query_native_create_projections.controllers;

import com.ivoronline.springboot_db_query_native_create_projections.entities.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
public class MyController {

  @PersistenceContext EntityManager entityManager;

  //================================================================
  // RETURN PERSON
  //================================================================
  @RequestMapping("ReturnPerson")
  Person returnPerson() {

    //CREATE QUERY
    String select = "SELECT * FROM Person WHERE name = :name";
    Query  query  = entityManager.createNativeQuery(select, Person.class);
           query.setParameter("name", "John");

    //SELECT PERSON
    Person person = (Person) query.getSingleResult();

    //RETURN PERSON
    return person;

  }

  //================================================================
  // RETURN ARRAY
  //================================================================
  @RequestMapping("ReturnArray")
  Object[] returnArray() {

    //CREATE QUERY
    String select = "SELECT age, name FROM Person WHERE name = :name";
    Query  query  = entityManager.createNativeQuery(select);
           query.setParameter("name", "John");

    //SELECT PERSON
    Object[] array = (Object[]) query.getSingleResult();

    //RETURN PERSON
    return array;

  }
  //================================================================
  // RETURN SCALAR
  //================================================================
  @RequestMapping("ReturnScalar")
  Integer returnScalar() {

    //CREATE QUERY
    String select = "SELECT age FROM Person WHERE name = :name";
    Query  query  = entityManager.createNativeQuery(select);
           query.setParameter("name", "John");

    //SELECT PERSON
    Integer age = (Integer) query.getSingleResult();

    //RETURN PERSON
    return age;

  }

  //================================================================
  // RETURN STRING (NOT WORKING)
  //================================================================
  @RequestMapping("ReturnString")
  String returnString() {

    //CREATE QUERY
    String select = "SELECT name, age FROM Person WHERE name = :name";
    Query  query  = entityManager.createNativeQuery(select);
           query.setParameter("name", "John");

    //SELECT PERSON
    String nameAge = (String) query.getSingleResult();

    //RETURN PERSON
    return nameAge;

  }

}


