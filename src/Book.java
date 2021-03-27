import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book extends Consumable{
	


	public Book(String name, Date startingDate, Date endingDate, double rating )
	{
		super(name,startingDate,endingDate, rating);
	}

	public Book()
	{
		super();
		
	}
	
	public Book(String name, double day, double rating )
	{
		super(name,day, rating);
	}
	public Book(String name, int hour, double rating)
	{
		super(name,hour, rating);
		
	}

}
