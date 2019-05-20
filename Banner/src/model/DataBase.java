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
	
	public Attendee root;
	public Attendee firstAttendee;
	public Attendee firstParticipant;
	
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
			Attendee q = new Attendee(Integer.parseInt(r[0]),r[1],r[2],r[3],r[4],r[5],r[6],r[7]);
			addAttendee(q,this.root);
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
	public void addAttendee(Attendee e,Attendee root) {
		if(isEmpty()) {
			root=e;
		}
		else if(root.getRight().getId()>e.getId()) {
			if(root.getRight()==null) {
				root.setRight(e);
			}
			else {
				addAttendee(e,root.getRight());
			}
		}
		else  {
			if(root.getLeft()==null) {
				root.setLeft(e);
			}
			else {
				addAttendee(e,root.getLeft());
			}
		}
	}
	
}
