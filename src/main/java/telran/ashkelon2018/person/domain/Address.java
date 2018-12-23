package telran.ashkelon2018.person.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String city;
	String street;
	int building;
	
}
