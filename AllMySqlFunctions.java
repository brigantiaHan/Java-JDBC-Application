import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AllMySqlFunctions {

	

	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/jdbc";
	private static final String username="root";
	private static final String password="root";
	static Connection conn=null;
	static Statement stmt=null;
	static Statement stmt2=null;
	static ResultSet myRs=null;
	
	public static void UpdatePublisher(Statement stmt)
	{
		int publisherid=0;
		String publishername="";
		Scanner input = new Scanner(System.in);
		System.out.println("Please input publisherid,new publishername to Update...");
		String s=input.nextLine();
		String[] ss=s.split(",");
		publisherid=Integer.parseInt(ss[0]);
		publishername=ss[1];
		
		try {
			String sql = "UPDATE publishers_table"
					+ " SET publishername = '"+publishername+"' "
					+ " WHERE publisherid = '"+publisherid+"'";
			
			stmt.executeUpdate(sql);
			GUIMySQL.LK.setText("Update Publisher Info Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void AddPublisher(Statement stmt,int publisherid)
	{
		
		String publishername="";
		Scanner input = new Scanner(System.in);
		System.out.println("new publishername");
		String s=input.nextLine();
		publishername=s;
		
		try 
		{
			String sql= ""
					+ "insert into publishers_Table(PUBLISHERID,PUBLISHERNAME) values ('"+publisherid+"','"+publishername+"')";
			stmt.executeUpdate(sql);
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void AddTitle(Statement stmt,ResultSet Rs)
	{
		int id=0,editionnumber=0,publisherid=0,price=0;
		String isbn="",title="",copyright="";
		Scanner input = new Scanner(System.in);
		System.out.println("Please input An Existing AuthorID,new ISBN,new title,editionnumber,copyright,publisherid,price to Update...");
		String s=input.nextLine();
		String[] ss=s.split(",");
		id=Integer.parseInt(ss[0]);
		isbn=ss[1];
		title=ss[2];
		editionnumber=Integer.parseInt(ss[3]);
		copyright=ss[4];
		publisherid=Integer.parseInt(ss[5]);
		price=Integer.parseInt(ss[6]);
		
		try {
			String sql = ""
					+ "insert into AUTHORISBN_TABLE(AUTHORID,ISBN) values ('"+id+"','"+isbn+"')";
//			String sql1=""
//					+ "Select PUBLISHERID from TITLES_TABLE where PUBLISHERID='"+isbn+"'";
			String sql1=""
					+ "Select PUBLISHERID from publishers_Table where PUBLISHERID='"+publisherid+"'";
			String sql2= ""
					+ "insert into titles_Table(ISBN,TITLE,EDITIONNUMBER,COPYRIGHT,PUBLISHERID,PRICE) values ('"+isbn+"','"+title+"','"+editionnumber+"','"+copyright+"','"+publisherid+"','"+price+"')";
			
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			
			
			Rs=stmt.executeQuery(sql1);
			
			if(!Rs.next())
			{
				
				AddPublisher(stmt,publisherid);
			}
			
			GUIMySQL.LO.setText("Add title and publisher successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateAuthor(Statement stmt)
	{
		int id=0;
		String firstName="",lastName="";
		
		Scanner input=new Scanner(System.in);
		System.out.println("Please input AuthorID,new FirstName,new LastName to Update...");
		String s=input.nextLine();
//		String[] ss=s.split("\\s+");
		String[] ss=s.split(",");
		id=Integer.parseInt(ss[0]);
		firstName=ss[1];
		lastName=ss[2];
		
		
		try {
//			String sql = ""
//					+ "update AUTHOR_TABLE set first_name='"+firstName+"', last_name='"+lastName+"' where authorid='"+id+"'";
			String updateTableSQL = "UPDATE author_table"
					+ " SET first_name = '"+firstName+"', last_name='"+lastName+"' "
					+ " WHERE authorid = '"+id+"'";
			System.out.println(updateTableSQL);
			stmt.execute(updateTableSQL);
			System.out.println("Record is updated to DBUSER table!");
			GUIMySQL.LG.setText("Update Author Info Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public static void insertNewAuthor(Statement stmt,Record record)
	{
		int authorID;
		String first_name;
		String last_name;
		String isbn;
		String title;
		int editionNumber;
		String copyRight;
		int publisherID;
		int price;
		String publisherName;
		authorID=record.getAuthorID();
		first_name=record.getFirst_name();
		last_name=record.getLast_name();
		isbn=record.getIsbn();
		title=record.getTitle();
		editionNumber=record.getEditionNumber();
		copyRight=record.getCopyRight();
		publisherID=record.getPublisherID();
		price=record.getPrice();
		publisherName=record.getPublisherName();
		

		
		String sql1=""
				+ "insert into author_table(authorID,FIRST_NAME,LAST_NAME) values ('"+authorID+"','"+first_name+"','"+last_name+"')";
		
		
		String sql2= ""
				+ "insert into titles_Table(ISBN,TITLE,EDITIONNUMBER,COPYRIGHT,PUBLISHERID,PRICE) values ('"+isbn+"','"+title+"','"+editionNumber+"','"+copyRight+"','"+publisherID+"','"+price+"')";
		
		String sql3 = ""
				+ "insert into AUTHORISBN_TABLE(AUTHORID,ISBN) values ((select max(AUTHORID) from AUTHOR_TABLE),(select max(ISBN) from TITLES_TABLE))";
		
		String sql4= ""
				+ "insert into publishers_Table(publisherid,publishername) values ((select max(publisherid) from TITLES_TABLE),'"+publisherName+"')";
		
		try {			
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			GUIMySQL.LF.setText("New Author Created!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void specialPublisher(Statement stmt,ResultSet Rs)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Please input the special publisherid");
		int publisherid=Integer.parseInt(input.nextLine());
		
		
		try {
			Rs=stmt.executeQuery("select p.publishername, t.title, t.copyright,t.isbn from publishers_table p join titles_table t on p.publisherid=t.publisherid and p.publisherid='"+publisherid+"' ORDER BY t.title");
			while(Rs.next())
			{
				System.out.println("PUBLISHERNAME: "+Rs.getString("PUBLISHERNAME")+" TITLE: "+Rs.getString("TITLE")+" COPYRIGHT: "+Rs.getString("COPYRIGHT")+" ISBN: "+Rs.getString("ISBN"));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public static void showPublisher(Statement stmt,ResultSet Rs)
	{
		try {
			
			Rs=stmt.executeQuery("select * from publishers_Table");
			while(Rs.next())
			{
				System.out.println(Rs.getString("PUBLISHERID")+", "+Rs.getString("PUBLISHERNAME"));
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}
	public static void sortAll(Statement stmt,ResultSet Rs,String sort1)
	{
		try {
			
			Rs=stmt.executeQuery(sort1);
			
			while(Rs.next())
			{
				System.out.println(Rs.getString("AUTHORID")+", "+Rs.getString("first_name")+", "+Rs.getString("last_name"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void executeAll(Statement stmt,String creT1,String creT2,String creT3,String creT4
			)
	{
		try 
		
		{
			//Create all tables
			stmt.executeUpdate(creT1);
			stmt.executeUpdate(creT2);
			stmt.executeUpdate(creT3);
			stmt.executeUpdate(creT4);
			
			//insert all tables
			String insertSql="INSERT INTO AUTHOR_TABLE VALUES(?,?,?)";
			PreparedStatement pstmt1=(PreparedStatement) conn.prepareStatement(insertSql);
			for(students s:JDBCAllTable.stus)
			{
				pstmt1.setInt(1, s.getAuthorID());
				pstmt1.setString(2, s.getFirstName());
				pstmt1.setString(3, s.getLastName());
				pstmt1.addBatch();
			}
			
			pstmt1.executeBatch();
			
			
			
			String insertSql2="INSERT INTO AUTHORISBN_TABLE VALUES(?,?)";
			PreparedStatement pstmt2=(PreparedStatement) conn.prepareStatement(insertSql2);
			for(authorISBN a:JDBCAllTable.autisbn)
			{
				pstmt2.setInt(1, a.getAuthorID());
				pstmt2.setString(2, a.getIsbn());
			
				pstmt2.addBatch();
			}
			
			pstmt2.executeBatch();
			
			
		
			
			String insertSql3="INSERT INTO TITLES_TABLE VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt3=(PreparedStatement) conn.prepareStatement(insertSql3);
			for(titles a:JDBCAllTable.tits)
			{
				pstmt3.setString(1,a.getIsbn());
				pstmt3.setString(2, a.getTitle());
				pstmt3.setInt(3, a.getEditionnumber());
				pstmt3.setString(4, a.getCopyright());
				pstmt3.setInt(5, a.getPublisherID());
				pstmt3.setInt(6, a.getPrice());
				pstmt3.addBatch();
			}
			
			pstmt3.executeBatch();
			
			
			String insertSql4="INSERT INTO PUBLISHERS_TABLE VALUES(?,?)";
			PreparedStatement pstmt4=(PreparedStatement) conn.prepareStatement(insertSql4);
			for(publisher a:JDBCAllTable.pubs)
			{
				pstmt4.setInt(1,a.getPublisherID());
				pstmt4.setString(2, a.getPublisherName());
				
				pstmt4.addBatch();
			}
			
			pstmt4.executeBatch();


			

			GUIMySQL.LB.setText("Tables Created Successfully");
			
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public static void getConnection()
	{
		
		try {
			//register JDBC driver
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
			stmt=conn.createStatement();
			stmt2=conn.createStatement();

			GUIMySQL.LA.setText("Connected Successfully!");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}
	
	public static void dropConnection()
	{
		try 
		{
			conn.close();
			stmt.close();
		} 
	catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	

		

	

}
