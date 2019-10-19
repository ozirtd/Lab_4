package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Person;

class PersonTest {

	private Person person;
	
	
	private void setupSceneary1() {
		
	}
	
	
	@Test
	public void testPerson() {
		setupSceneary1();
		
		person = new Person("68-5724798", "Rennie", "Salman", "rsalmanc@smh.com.au", "female", "Israel", "https://robohash.org/aliquamaccusantiumnon.bmp?size=50x50&set=set1", "9/1/1997");
		
		assertNotNull("the object was not created correctly", person);
		
		assertTrue("the method getId does not work", person.getId().equals("68-5724798"));
		assertTrue("the method getPhoto does not work", person.getPhoto().equals("https://robohash.org/aliquamaccusantiumnon.bmp?size=50x50&set=set1"));
		assertTrue("the method getFirst_name does not work", person.getFirst_name().equals("Rennie"));
		assertTrue("the method getLast_name does not work", person.getLast_name().equals("Salman"));
		assertTrue("the method getCountry does not work", person.getCountry().equals("Israel"));
		
		Person left = new Person("236-9303351","Bennie","MacMenemy","bmacmenemy9@reference.com","Male","China","https://robohash.org/assumendaearumaut.jpg?size=50x50&set=set1","4/12/1965");
		person.setLeft(left);
		assertTrue("the method setLeft does not work", person.getLeft() == left);
		
		Person right = new Person("80-8723801","Giustino","Freddi","gfreddi3@nasa.gov","Male","France","https://robohash.org/dictamaximenihil.png?size=50x50&set=set1","5/19/2007");
		person.setRight(right);
		assertTrue("the method setRight does not work", person.getRight() == right);
		
		Person next = new Person("40-6612176","Brana","Hinchshaw","bhinchshaw8@businessinsider.com","Female","China","https://robohash.org/quamestcupiditate.png?size=50x50&set=set1","1/12/1976");
		person.setNext(next);
		assertTrue("the method setNext does not work", person.getNext() == next);
		
		Person prev = new Person("18-6594147","Bevan","Bonsale","bbonsalef@ox.ac.uk","Male","Indonesia","https://robohash.org/totameaunde.jpg?size=50x50&set=set1","11/19/1988");
		person.setPrev(prev);
		assertTrue("the method setPrev does not work", person.getPrev() == prev);
		
		
		
		
		
	}

}

