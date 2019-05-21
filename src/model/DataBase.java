package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import exception.IdNotFoundException;

/**
 * @author sas1
 *
 */
public class DataBase {
	
	private Attendee root;
	private Attendee firstAttendee;
	private Attendee firstParticipant;
	private  int numberOfParticipants;
	
	public DataBase() {
		root = null;
		firstAttendee = null;
		firstParticipant = null;
	}
	
	public void loadFile(String filename) throws IOException {
		root = null;
		numberOfParticipants = 0;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
		String f= bufferedReader.readLine();
			while(f !=null) {
				String [] r =f.split(",");
				addAttendee(new Attendee(r[0],r[1],r[2],r[3],r[4],r[5],r[6],r[7]));
				f= bufferedReader.readLine();
		}
		bufferedReader.close();
	}

	public boolean isEmpty() {
		return (root == null);
	}
	
	/** search for an attendee -uses the id attribute as the reference indicator-
	 * @param a is the id that's go in to be search.
	 * @return if the attendee exist returns it or return null if it dosen't exist
	 */
	public Attendee searchAssitant(String cod,Attendee act) throws IdNotFoundException{
		
		boolean find = false;
		while(!find && act != null) {
			if(act.getId().equals(cod)) {
				find = true;
			}
			if(!find) {
				act = act.getNext();
			}
		}
		if(act ==null) {
			throw new IdNotFoundException();
		}
		return act;	
	}
	
	
	
	/**
	 * no usar vacio
	 * 1 add, 2 der 3 izq
	 */
	public void createListParticipants() {
		int cont = 0;
		int des = (int)(Math.random()*3)+1;
		Attendee act = root;
		while(cont < numberOfParticipants/2) {
			if(act == null) {
				act = root;
			}
			if(des == 1) {
				cont += addParticipant(act)? 1: 0;
			}else if( des == 2) {
				act = act.getRight();
			}else {
				act = act.getLeft();
			}
			des = (int)(Math.random()*3)+1;
		}
	}
	
	public void createListAttendee() {
		firstAttendee = root.createList();
	}
	
	public boolean addParticipant(Attendee a) {
		boolean b = false;
		
		if(a.getBefore() == null && a.getNext()== null) {
		if(firstParticipant == null) {
			firstParticipant = a;
			b = !b;
		}else {
			Attendee att = firstParticipant;
			while(!b) {
				if(att.getNext() == null) {
					att.setNext(a);
					a.setBefore(att);
					b = !b;
				}else {
				att = att.getNext();
				}
			}
			
		}
		}
		return b;
	}
	
	/** Add's an attendee to the binary three
	 * @param e the attendee that's go in to be added
	 */
	public void addAttendee(Attendee e) {
		if(isEmpty()) {
			 root=e;
		} else
			root.addAttendee(e);
		numberOfParticipants++;
	}
	
	/** Add's an attendee to the binary three
	 * @param e the attendee that's go in to be added
	 * @param root is the first element of the three that also is the reference for adding objects to the three
	 */
	public void addAttendee(Attendee n,Attendee r) {
		if(n.getId().compareTo(r.getId()) <= 0) {
			if(r.getLeft()==null) {
				r.setLeft(n);
				numberOfParticipants++;
			} else
				addAttendee(n,r.getLeft());
		} else if(r.getRight()==null) {
				r.setRight(n);
				numberOfParticipants++;
			} else
				addAttendee(n,r.getRight()); 
		
		numberOfParticipants++;
	}
	
	/*	public long knowTime() {
		long startTime = System.currentTimeMillis();
		return System.currentTimeMillis() - startTime;
	}
	*/

	
	/**
	 * @return the root
	 */
	public Attendee getRoot() {
		return	root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Attendee root) {
		this.root = root;
	}

	/**
	 * @return the firstAttendee
	 */
	public Attendee getFirstAttendee() {
		return firstAttendee;
	}

	/**
	 * @param firstAttendee the firstAttendee to set
	 */
	public void setFirstAttendee(Attendee firstAttendee) {
		this.firstAttendee = firstAttendee;
	}

	/**
	 * @return the firstParticipant
	 */
	public Attendee getFirstParticipant() {
		return firstParticipant;
	}

	/**
	 * @param firstParticipant the firstParticipant to set
	 */
	public void setFirstParticipant(Attendee firstParticipant) {
		this.firstParticipant = firstParticipant;
	}
	
	 
}
