package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

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
		data.loadFile("..\data\dataPrueba.txt");
		
	}
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
