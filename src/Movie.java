import java.util.Date;

public class Movie extends Consumable{
	public Movie(String name, Date startingDate, Date endingDate, double rating )
	{
		super(name,startingDate,endingDate, rating);
	}
	
	public Movie()
	{
		
		super();
	}
	
	public Movie(String name, double day, double rating )
	{
		super(name,day, rating);
	}
	public Movie(String name, int hour, double rating )
	{
		super(name,hour, rating);
	}

}
