
public class titles {

	
	String isbn,title,copyright;
	int editionnumber,publisherID,price;
	
	public titles(String isbn, String title, String copyright, int editionnumber, int publisherID, int price) {


		this.isbn = isbn;
		this.title = title;
		this.copyright = copyright;
		this.editionnumber = editionnumber;
		this.publisherID = publisherID;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public int getEditionnumber() {
		return editionnumber;
	}

	public void setEditionnumber(int editionnumber) {
		this.editionnumber = editionnumber;
	}

	public int getPublisherID() {
		return publisherID;
	}

	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
