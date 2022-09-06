package localhost.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JpaController {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	
	protected JpaController() {}
	
	public JpaController(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName=%s, lastName=%s]"
				,id, firstName, lastName);
	}
	public Long getId() {
		return id;
	}
	public String firstName() {
		return firstName;
	}
	public String lastName() {
		return lastName;
	}
	

}
