package com.jusoft.ligaregional.persistencia.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AbstractBean implements Serializable, Cloneable {

	private static final long serialVersionUID = 2278275861548870333L;

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE,true);
	}

	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object object){
		return EqualsBuilder.reflectionEquals(this, object);
	}
}
