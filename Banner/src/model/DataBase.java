package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import exception.IdNotFoundException;

/**
 * @author sas1
 *
 */
public class DataBase {
	
	private Attendee root;
	private Attendee firstAttendee;
	private Attendee firstParticipant;
	public static int numberOfParticipants;
	public DataBase() {
		root = null;
		firstAttendee = null;
		firstParticipant = null;
	}
	
	public void loadFile(String filename) throws IOException {
		String f;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
			while((f=bufferedReader.readLine())!=null) {
				String [] r =f.split(",");
				addAttendee(new Attendee(numberOfParticipants,r[1],r[2],r[3],r[4],r[5],r[6],r[7]),this.root);
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
	public Attendee searchAssitant(int a,Attendee root) throws IdNotFoundException{
		if (!isEmpty()) {
			if (a == root.getId()) {
				return this.root;
			} else {
				if (a < root.getId()) {
					return searchAssitant(a,root.getLeft());
				} else {
					return searchAssitant(a,root.getRight());
				}
			}
		}
		else 
			return null;	
	}
	
	/** Add's an attendee to the binary three
	 * @param e the attendee that's go in to be added
	 * @param root is the first element of the three that also is the reference for adding objects to the three
	 */
	public void addAttendee(Attendee e,Attendee r) {
		if(isEmpty()) {
			root=e;
			numberOfParticipants++;
		}
		if(r.getId()>r.getId()) {
		 if(r.getLeft()!=null) {
			 addAttendee(e,r.getLeft());
			}
			else {
				r.setLeft(e);
				numberOfParticipants++;
			}
		}
		else  {
			if(r.getRight()!=null) {
				addAttendee(e,r.getRight());
			}
			else {
				r.setRight(e);
				numberOfParticipants++;
			}
		}
	}
	
	/*	public long knowTime() {
		long startTime = System.currentTimeMillis();
		return System.currentTimeMillis() - startTime;
	}
	*/
	public static void main (String [] args ) {
		DataBase r = new DataBase();
		try {
			
			r.loadFile("File:data/AttendeesList.txt");
			System.out.println(r.root.getCountry());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the root
	 */
	public Attendee getRoot() {
		return root;
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
