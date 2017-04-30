import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Entity;

import com.mysql.jdbc.PreparedStatement;

public class JDBCAllTable {
	
	

	//Create sql clause
	
	//Create Author_Table
	public static final String AUTHORTABLE="CREATE TABLE author_table ( " + "authorID integer NOT NULL PRIMARY KEY, "
	+ "first_name char(20) NOT NULL, "
	+ "last_name char(20) NOT NULL " + ")"; 
	
	//Create authorISBN_Table
	public static final String AUTHORISBNTABLE="Create TABLE authorISBN_Table ( " + "authorID integer NOT NULL, "
	+ "isbn char(10) NOT NULL " + ")";
	
	//Create titles_Table
	public static final String TITLESTABLE="Create Table titles_Table ( " + "isbn CHAR(10) NOT NULL PRIMARY KEY, "
																		+ "title VARCHAR(500) NOT NULL, "
																		+ "editionNumber integer NOT NULL, "
																		+ "copyright CHAR(4) NOT NULL, "
																		+ "publisherID INTEGER NOT NULL, "
																		+ "price int NOT NULL " + ")";
	//Create pulishers_Table
	public static final String PUBLISHERSTABLE="Create Table publishers_Table ( " + "publisherID Integer NOT NULL, "
																				+ "publisherName CHAR(100) NOT NULL " + ")";
	
	
	public static Statement stmt=null;


	public static List<students> stus=Arrays.asList(new students(1,"Tom","Z"),
			new students(2,"Mary","Z"),
			new students(3,"Kate","W"),
			new students(4,"Rose","M"),
			new students(5,"Lily","T"));
	
	public static List<authorISBN> autisbn=Arrays.asList(new authorISBN(1,"01"),
			new authorISBN(2,"02"),
			new authorISBN(3,"03"),
			new authorISBN(4,"04"),
			new authorISBN(5,"05")
			);
	
	public static List<titles> tits=Arrays.asList(new titles("01","SUNNY","16",1010,1,100),
			new titles("02","CLOUDY","15",3030,2,200),
			new titles("03","FUNNY","17",4040,3,300),
			new titles("04","HAPPY","13",5050,4,400),
			new titles("05","LUCKY","12",6060,5,500)
			
			);
	
	
	public static List<publisher> pubs=Arrays.asList(new publisher(1,"SAN"),
			new publisher(2,"ALICE"),
			new publisher(3,"SOFT"),
			new publisher(4,"WIN"),
			new publisher(5,"CAROLINE")
			
			);
	

	public static final String sort1 = ""
			+ "select authorid,first_name,last_name "
			+ "from author_table "
			+ "ORDER BY last_name,first_name";
	
	
}
