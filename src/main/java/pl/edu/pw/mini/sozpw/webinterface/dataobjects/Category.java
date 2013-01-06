package pl.edu.pw.mini.sozpw.webinterface.dataobjects;

public enum Category {
	
	ROZRYWKA ("Rozrywka"),
	NAUKA ("Nauka"),
	SPORT ("Sport"),
	SPOTKANIE ("Spotkanie"),
	OGLOSZENIE ("Ogłoszenie"),
	BRAK_KATEGORII ("Brak kategorii");
	
	private String catString;
	
	private Category(String catString){
		this.catString = catString;
	}
	
	@Override
	public String toString(){
		return catString;
	}

}
