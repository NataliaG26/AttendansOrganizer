/**
 * 
 */
package exception;

import javax.swing.JOptionPane;

/**
 * @author sas1
 *
 */
public class IdNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotFoundException() {
		JOptionPane.showMessageDialog(null, "This ID Doesn't exist, please check that isn't wrong writted");
	}

}
