import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Consumable {
	public static List<Consumable>consumables = new ArrayList<Consumable>();
	private String name;
	private Date startingDate;
	private Date endingDate;
	private double totalConsumptionHour=0;
	private double personalRating;
	private double totalConsumptionDays=0;
	private String type;
	private int movieTime = 0, bookTime=0, seriesTime=0;
	
	private double day ;
	private double hour;
	private double rating;
	
	public Consumable() {
		this.day = 0;
		this.hour = 0;
	}
	public Consumable(String name, Date startingDate, Date endingDate, double rating )
	{
		this.name = name;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.rating = rating;
		this.calculateTotalConsumptionHourFromDate(endingDate,startingDate);
		this.setRating(rating);
		addPerTime(this);
		consumables.add(this);

	}
	
	public Consumable(String name, double day, double rating)
	{
		this.name =name;
		this.day = day;
		this.rating = rating;
		this.calculateTotalConsumptionDayFromDay(day);
		addPerTime(this);
		consumables.add(this);
		
	}
	public Consumable(String name, int hour, double rating)
	{
		this.name =name;
		this.hour= hour;
		this.rating = rating;
		this.calculateTotalConsumtionHourFromHour(hour);
		addPerTime(this);
		consumables.add(this);
		
	}
	
	double addPerTime(Consumable obj1)
	{
		
		if(obj1.getClass().getName().equals("Movie"))
		 {
			
			 movieTime += obj1.getHour();
			 obj1.setType("Movie");
			 return movieTime;
		 }	
		else if(obj1.getClass().getName().equals("Book"))
		{
			bookTime += obj1.getHour();
			obj1.setType("Book");
			return bookTime;
		}
		else
		{
			seriesTime += obj1.getHour();
			obj1.setType("Series");
			return seriesTime;
		}
		
	}
	public void setDay(double day)
	{
		this.day += day;
	}
	
	double getDay()
	{
		return this.day;
	}
	
	void setHour(double hour)
	{
		this.hour += hour;
	}
	
	double getHour()
	{
		
		return this.hour;
	}
	// set and get method for name
	void setName(String name)
	{
		this.name = name;
	}
	
	String getName()
	{
		return this.name;
	}
	//set and get method for starting date
	void setStartingDate(Date startingDate)
	{
		this.startingDate = startingDate;
	}
	
	public Date getStartingDate()
	{
		return this.startingDate;
	}
	void setType(String type)
	{
		this.type = type;	
	}
	String getType()
	{
		//System.out.println("hello");
		return this.type;	
	}	

	void setEndingDate(Date endingDate)
	{
		this.endingDate = endingDate;
	}
	
	Date getEndingDate()
	{
		return this.endingDate;
	}
	
	
	// set and get method for personal rating
	void setPersonalRating(double Rating)
	{
		this.personalRating += Rating;
	}
	
	double getPersonalRating()
	{
		return this.personalRating;
	}
	
	//set and get method for totalHour
	void setTotalHour(double totalConsumptionHour)
	{
		this.totalConsumptionHour += totalConsumptionHour;		
	}
	
	double getTotalHour()
	{
		return this.totalConsumptionHour;
	}
	//set and get method for totalDay
	
	void setTotalDays(double totalConsumptionDays)
	{
		this.totalConsumptionDays += totalConsumptionDays;
	}
	
	
	double getTotalDays()
	{
		return this.totalConsumptionDays;
	}
	
	 void setRating(double rating )
	 {
		 this.rating = rating;
	 }
	 double getRating()
	 {
		 return this.rating;
	 }
	
	
	public void calculateTotalConsumptionHourFromDate(Date date1, Date date2) {
		// TODO Auto-generated method stub
		final int MILLI_TO_HOUR = 1000 * 60 * 60;
		double hourFromDate = (double) (date1.getTime() - date2.getTime()) / MILLI_TO_HOUR ;
		double calday = hourFromDate /24;
		this.setTotalDays(calday);
		this.setTotalHour(hourFromDate);
		this.setDay(calday);
		this.setHour(hourFromDate);
		
	}
	
	public void calculateTotalConsumtionHourFromHour(double hour) {
		// TODO Auto-generated method stub
		this.setTotalHour(hour);
		double totDay = this.getTotalHour();
		totDay = totDay / 24;
		this.setTotalDays(totDay);
		this.setHour(hour);
		this.setDay(totDay);
		
	}

	public void calculateTotalConsumptionDayFromDay(double day) {
		// TODO Auto-generated method stub
		this.setTotalDays(day);
		double hr = day * 24;
		this.setTotalHour(hr);
		this.setDay(day);
		this.setHour(hr);
		
	}
	
	

}
