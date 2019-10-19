package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import model.Person;
import model.VolleyballCup;

class VolleyballCupTest {
	
	private VolleyballCup cup;
	

	private void setupScenary1() {
		
	}
	
	
	private void setupScenary2() {
		cup = new VolleyballCup("IV Copa Panamericana de Voleibol Masculino Sub-21", "May 5 to 9, 2019", "Lima");
	}
	
	
	private void setupScenary3() {
		cup = new VolleyballCup("IV Copa Panamericana de Voleibol Masculino Sub-21", "May 5 to 9, 2019", "Lima");
		
		cup.addPersonToTree("78-7115102","Nixie","Cawood","ncawood1@hc360.com","Female","Sweden","https://robohash.org/velsequiexcepturi.png?size=50x50&set=set1","7/9/2009");
		cup.addPersonToTree("72-1139751","Bethena","Cardow","bcardowa@rambler.ru","Female","Russia","https://robohash.org/autrepellatnon.bmp?size=50x50&set=set1","2/7/2011");
		cup.addPersonToTree("80-8723801","Giustino","Freddi","gfreddi3@nasa.gov","Male","France","https://robohash.org/dictamaximenihil.png?size=50x50&set=set1","5/19/2007");
		cup.addPersonToTree("68-5724798","Rennie","Salman","rsalmanc@smh.com.au","Female","Israel","https://robohash.org/aliquamaccusantiumnon.bmp?size=50x50&set=set1","9/1/1997");
		cup.addPersonToTree("73-8369906","Tuck","Englefield","tenglefieldg@tiny.cc","Male","Poland","https://robohash.org/impeditautet.png?size=50x50&set=set1","9/7/1963");
		cup.addPersonToTree("79-5659036","Bevan","Bonsale","bbonsalef@ox.ac.uk","Male","Indonesia","https://robohash.org/totameaunde.jpg?size=50x50&set=set1","11/19/1988");
		cup.addPersonToTree("89-0650975","Moselle","Dwyer","mdwyer6@live.com","Female","Belarus","https://robohash.org/explicabodolorvoluptatem.bmp?size=50x50&set=set1","6/5/2013");
		
		cup.addParticipantToList(new Person("80-8723801","Giustino","Freddi","gfreddi3@nasa.gov","Male","France","https://robohash.org/dictamaximenihil.png?size=50x50&set=set1","5/19/2007"));
		cup.addParticipantToList(new Person("79-5659036","Bevan","Bonsale","bbonsalef@ox.ac.uk","Male","Indonesia","https://robohash.org/totameaunde.jpg?size=50x50&set=set1","11/19/1988"));
		cup.addParticipantToList(new Person("68-5724798","Rennie","Salman","rsalmanc@smh.com.au","Female","Israel","https://robohash.org/aliquamaccusantiumnon.bmp?size=50x50&set=set1","9/1/1997"));
	}

	@Test
	void testVolleyballCup() {
		setupScenary1();
		
		cup = new VolleyballCup("IV Copa Panamericana de Voleibol Masculino Sub-21", "May 5 to 9, 2019", "Lima");
		
		assertNotNull("the object was not created correctly", cup);
		
		Person root = new Person("80-8723801","Giustino","Freddi","gfreddi3@nasa.gov","Male","France","https://robohash.org/dictamaximenihil.png?size=50x50&set=set1","5/19/2007");
		cup.setRootSpectator(root);
		assertTrue("the method setRootSpectator does not work", cup.getRootSpectator() == root);
		
		Person first = new Person("79-5659036","Bevan","Bonsale","bbonsalef@ox.ac.uk","Male","Indonesia","https://robohash.org/totameaunde.jpg?size=50x50&set=set1","11/19/1988");
		cup.setFirstParticipant(first);
		assertTrue("the method setRootSpectator does not work", cup.getFirstParticipant() == first);
		
		
	}
	
	@Test
	void testLoadInformation() {
		setupScenary2();
		
		try {
			cup.loadInformation("data/MOCK_DATA (1).csv");
			assertNotNull("did not read the file properly", cup.getFirstParticipant());
			assertNotNull("did not read the file properly", cup.getRootSpectator());
		}catch(IOException e) {
			fail("caught the exception when it should not");
		}
	}
	
	@Test
	void testLoadInformation2() {
		setupScenary2();
		
		try {
			cup.loadInformation("data/numbers");
			fail("he did not catch the exception when he should not");
		}catch(IOException e) {
			
		}
	}
	
	@Test
	void testAddParticipantToList() {
		setupScenary2();
		
		Person newPer = new Person("64-4243696","Viv","Keaveney","vkeaveney0@furl.net","Female","Mongolia","https://robohash.org/nisifugiata.png?size=50x50&set=set1","4/21/1985");
		cup.addParticipantToList(newPer);
		assertNotNull("does not add to the element correctly", cup.getFirstParticipant());
		assertTrue("does not add to the element correctly", cup.getFirstParticipant() == newPer);
		
	}
	
	@Test
	void testAddPersonToTree() {
		setupScenary2();
		
		cup.addPersonToTree("64-4243696","Viv","Keaveney","vkeaveney0@furl.net","Female","Mongolia","https://robohash.org/nisifugiata.png?size=50x50&set=set1","4/21/1985");
		assertNotNull("does not add to the element correctly", cup.getRootSpectator());
		
		
		
	}
	
	@Test
	void testSearchPersonById() {
		setupScenary3();
		
		Person found = cup.searchPersonById("89-0650975");
		assertNotNull("the person was not found", found);
		assertTrue("the person found is not correct", found.getFirst_name().equals("Moselle") && found.getLast_name().equals("Dwyer"));
		
		Person found2 = cup.searchPersonById("78-7115102");
		assertNotNull("the person was not found", found2);
		assertTrue("the person found is not correct", found2.getFirst_name().equals("Nixie") && found2.getLast_name().equals("Cawood"));
	
		Person notFound = cup.searchPersonById("15-9632468");
		assertNull("the person was found when he should not", notFound);
	}
	
	@Test
	void testSearchParticipantById() {
		setupScenary3();
		
		Person found = cup.searchParticipantById("80-8723801");
		assertNotNull("the person was not found", found);
		assertTrue("the person found is not correct", found.getFirst_name().equals("Giustino") && found.getLast_name().equals("Freddi"));
		
		Person found2 = cup.searchParticipantById("68-5724798");
		assertNotNull("the person was not found", found2);
		assertTrue("the person found is not correct", found2.getFirst_name().equals("Rennie") && found2.getLast_name().equals("Salman"));
	
		Person notFound = cup.searchParticipantById("89-0650975");
		assertNull("the person was found when he should not", notFound);
	}
	
	@Test
	void testTreeSearchTime() {
		setupScenary2();
		
	  	long time = System.currentTimeMillis();
	  	try {
			cup.loadInformation("data/testTime.csv");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  	
	  	cup.searchPersonById("91-5620528");
		time = (System.currentTimeMillis()-time)/1000;
		
		assertTrue("the time is not optimal", time < 1);
	}
	
	@Test
	void testSearchTimeList() {
		setupScenary2();
		
	  	long time = System.currentTimeMillis();
	  	try {
			cup.loadInformation("data/testTime.csv");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  	cup.searchParticipantById("47-7667205");
		time = (System.currentTimeMillis()-time)/1000;
		
		assertTrue("the time is not optimal", time < 1);
	}
}
