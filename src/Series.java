import java.util.Date;

public class Series extends Consumable{

	public Series()
	{
		super();
	}


	public Series(String name, Date startingDate, Date endingDate, double rating )
	{
		super(name,startingDate,endingDate, rating);
		
	}
	
	public Series(String name, double day, double rating )
	{
		super(name,day, rating);
	}
	
	public Series(String name, int hour, double rating )
	{
		super(name,hour, rating);
	}
	


}
