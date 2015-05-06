package org.nuytsm.HibernateDtoDuplicateTableMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "SubClass2")
public class SubClass2 extends SuperClass{
	
	@Column(name="BYTEARRAY")
	@Lob
	private byte[] someBigArray;

	public byte[] getSomeBigArray() {
		return someBigArray;
	}

	public void setSomeBigArray(byte[] someBigArray) {
		this.someBigArray = someBigArray;
	}

}
