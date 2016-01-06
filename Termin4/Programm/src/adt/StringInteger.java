package adt;

public class StringInteger {

	private String key;
	private Integer value;
	private Integer versuche;
	
	public StringInteger(String key, Integer value){
		this.key = key;
		this.value = value;
		this.versuche = 0;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getVersuche() {
		return versuche;
	}

	public void setVersuche(Integer versuche) {
		this.versuche = versuche;
	}
	
	
	
	
}
