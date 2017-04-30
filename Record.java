
public class Record {

	private int authorID;
	private String first_name;
	private String last_name;
	private String isbn;
	private String title;
	private int editionNumber;
	private String copyRight;
	private int publisherID;
	private int price;
	private String publisherName;
	
	public Record(int authorID, String first_name, String last_name, String isbn, String title, int editionNumber,
			String copyRight, int publisherID, int price, String publisherName) {
		
		this.authorID = authorID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.isbn = isbn;
		this.title = title;
		this.editionNumber = editionNumber;
		this.copyRight = copyRight;
		this.publisherID = publisherID;
		this.price = price;
		this.publisherName = publisherName;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public int getEditionNumber() {
		return editionNumber;
	}

	public void setEditionNumber(int editionNumber) {
		this.editionNumber = editionNumber;
	}

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
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

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	
	
	
}
