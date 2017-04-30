
public class authorISBN 
{
	private int authorID;
	private String isbn;
	
	
	public authorISBN(int authorID, String isbn) 
	{
		
		this.authorID = authorID;
		this.isbn = isbn;
	}


	public int getAuthorID() {
		return authorID;
	}


	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	
	
}
