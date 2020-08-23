package examples.pubhub.model;

import java.time.LocalDate;

public class BookTag {

	private String isbn13;			// International Standard Book Number, unique
	private String tag_name;
	

	
	public BookTag() {
		this.isbn13 = null;
		this.tag_name = null;
		
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(Book books) {
		this.isbn13 = isbn13;
	}
	public String getTagName() {
		return tag_name;
	}
	public void setTagName(String tag_name) {
		this.tag_name = tag_name;
	}
	@Override
	public String toString() {
		return "BookTag [isbn13=" + isbn13 + ", tag_name=" + tag_name +"]";
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
}
