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
	
	private static Attendee root;
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
				addAttendee(new Attendee(numberOfParticipants,r[1],r[2],r[3],r[4],r[5],r[6],r[7]));
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
		Attendee pastel=null;
		if (!isEmpty()) {
			if (a ==  DataBase.root.getId()) {
				return DataBase.root;
			} else {
				if((a > root.getId()) && (root.getLeft()!=null)) {
					pastel = searchAssitant(a,root.getLeft());
				} else {
					if(root.getRight()!=null) {
					pastel = searchAssitant(a,root.getRight());
					}
				}
			}
		}
		return pastel;	
	}
	
	/** Add's an attendee to the binary three
	 * @param e the attendee that's go in to be added
	 */
	public void addAttendee(Attendee e) {
		if(isEmpty()) {
			 DataBase.root=e;
			numberOfParticipants++;
		} else
			addAttendee(e, DataBase.root);
	}
	
	/** Add's an attendee to the binary three
	 * @param e the attendee that's go in to be added
	 * @param root is the first element of the three that also is the reference for adding objects to the three
	 */
	public void addAttendee(Attendee n,Attendee r) {
		if(n.getId() > r.getId()) {
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
	public static Attendee getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Attendee root) {
		DataBase.root = root;
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
	
	public static void main (String [] args ) {
		
		try {
			DataBase n = new DataBase();
			n.loadFile("../Banner/data/AttendeesList.txt");
			System.out.println(n.getRoot().getRight().getRight());
			System.out.println(n.searchAssitant(3, root).getCountry());
		} catch (IOException | IdNotFoundException e) {
			e.printStackTrace();
		}
	} 
}
