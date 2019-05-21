package model;

/**
 * @author Natalia Gonzalez & Duvan Cuero
 * @Date 20/05/2019
 */
public class Attendee {
	
	private String id;
	
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthday;
	private Attendee next;
	private Attendee before;
	private Attendee left;
	private Attendee right;
	
	/** Attendee class builder
	 * @param id -the identification of every attendee- id !=null
	 * @param first_name -every attendee first name-
	 * @param last_name -every attendee last name-
	 * @param email -email direction of every attendee-
	 * @param gender -biological gender MALE or FEMALE-
	 * @param country -country where the attendee was born-
	 * @param photo -and url or id of the photo-
	 * @param birthday -what can this be? i don't know, maybe some magic trick-
	 */
	public Attendee(String id, String first_name, String last_name, String email, String gender, String country,
			String photo, String birthday) {
		
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
		next =null;
		right= null;
		left = null;
	}
	
	public void addAttendee(Attendee a) {
		
		if(a.getId().compareTo(this.id) <=0) {
			if(left != null) {
				left.addAttendee(a);
			}else {
				left = a;
			}
		}else {
			if(right != null) {
				right.addAttendee(a);
			}else {
				right = a;
			}
		}
	}
	

	
	public String toStringList() {
		String msj = this.id;
		msj += this.id+"\n";
		if(this.next != null)
		msj += next.toStringList();
		return msj;
	}
	
	public String toStringTree() {
		String a = this.id+"\n ";
		if(this.left != null)
		a += left.toStringTree();
		if(this.right != null)
			a += right.toStringTree();
		return a;
	}
	
	public void addNext(Attendee a) {
		if(next== null) {
			next = a;
		}else {
			next.addNext(a);
		}
	}
	
	public Attendee createList() {
		Attendee att = null;
		if(this.before == null && this.next == null) {
			att = this;
			att.addNext(left != null ?left.createList(): null);
			att.addNext(right != null ?right.createList(): null);
			
		}else {
			att = left != null ?left.createList(): null;
			if(att == null) {
				att = right != null ?right.createList(): null;
			}else {
				att.addNext(right != null ?right.createList(): null);
			}
		}
		return att;
	}
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Attendee getNext() {
		return next;
	}
	public void setNext(Attendee next) {
		this.next = next;
	}
	
	/**
	 * @return the left
	 */
	public Attendee getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(Attendee left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public Attendee getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(Attendee right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return id+"";
	}
	public Attendee getBefore() {
		return before;
	}
	public void setBefore(Attendee before) {
		this.before = before;
	}
	
}
