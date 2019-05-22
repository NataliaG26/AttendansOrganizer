package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import exception.IdNotFoundException;
import userInterface.APO;
import userInterface.MIS;

class DataBaseTest {
	
	private DataBase data;
	
	//vacio
	void escenario1() {
		data = new DataBase();
	}
	
	//con raiz
	void escenario() {
		data = new DataBase();
		data.setRoot(new Attendee("02-4155448","Anselma","Deavall","adeavall0@arstechnica.com","Female","Bolivia","https://robohash.org/molestiaereprehenderittotam.jpg?size=50x50&set=set1","7/14/1970"));
	}
	
	@Test
	void test1() throws IOException {
		escenario1();
		data.loadFile("./data/dataPrueba.txt");
		
	}
	

	@Test
	void testSearchAssitant() throws IdNotFoundException {
		escenario();
		assertTrue(data.searchAssitant("02-4155448", data.getRoot()).getFirst_name().equals("Anselma") );
	}
	
	@Test
	void testLoadFIle() throws IOException {
		escenario1();
		data.loadFile("./data/dataPrueba.txt");
		assertTrue(data.getRoot()!=null);
	}
	@Test void addAttendee() {
		escenario1();
		Attendee q = new Attendee("47-0364871","Mia","Gibbon","mgibbona@nhs.uk","Female","Bulgaria","https://robohash.org/dignissimosdeseruntoccaecati.jpg?size=50x50&set=set1","4/27/2009");
		data.addAttendee(q );
		assertTrue(data.getRoot().equals(q));
	}
}
