package org.nuytsm.HibernateDtoDuplicateTableMapping.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.nuytsm.HibernateDtoDuplicateTableMapping.SuperClass;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SuperClassDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "SID", nullable = false)
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperClassDto other = (SuperClassDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	

}
