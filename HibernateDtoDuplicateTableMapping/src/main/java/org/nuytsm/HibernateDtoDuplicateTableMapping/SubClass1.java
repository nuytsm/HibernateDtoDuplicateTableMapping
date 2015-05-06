package org.nuytsm.HibernateDtoDuplicateTableMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "SubClass1")
public class SubClass1 extends SuperClass{

	@Column(name="LONGSTRING")
	@Lob
	private String tooLongStringSoINeedDTO;

	public String getTooLongStringSoINeedDTO() {
		return tooLongStringSoINeedDTO;
	}

	public void setTooLongStringSoINeedDTO(String tooLongStringSoINeedDTO) {
		this.tooLongStringSoINeedDTO = tooLongStringSoINeedDTO;
	}
	
}
