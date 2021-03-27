import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class main {
	
	static Scanner scan = new Scanner(System.in);	
	static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	static Date startingDate, endingDate;
	static int hour;
	static double day, Rating;
	static String timeInput,name;
	static int typeInput,consumableType;
	
	static HashMap<String, Consumable> map = new HashMap<String, Consumable>();
	
	static void init() throws ParseException {
		Consumable b1,b2,b3,b4,m1,m2,m3,s1,s2,s3;
		b1=new Book("Algo",format.parse("2021-02-11"),format.parse("2021-02-12"),7.6);
		b2=new Book("Head",format.parse("2021-01-11"),format.parse("2021-01-15"),8.8);
		b3=new Book("Database",format.parse("2021-02-11"),format.parse("2021-02-12"),6.5);
		b4=new Book("Data Structure",format.parse("2021-02-11"),format.parse("2021-02-12"),7.6);
		m1=new Movie("Jaws",format.parse("2021-02-11"),format.parse("2021-02-12"),3.5);
		m2=new Movie("Play",format.parse("2021-03-21"),format.parse("2021-04-25"),7.6);
		m3=new Movie("Hugo",format.parse("2021-02-11"),format.parse("2021-02-12"),4.8);
		s1=new Series("Argo",format.parse("2021-02-15"),format.parse("2021-02-17"),5.6);
		s2=new Series("1984",format.parse("2021-02-15"),format.parse("2021-02-16"),7.7);
		s3=new Series("Vikings",format.parse("2021-02-11"),format.parse("2021-02-12"),9.6);
		
		map.put("Algo", b1);
		map.put("HeadFirst", b2);
		map.put("Database", b3);
		map.put("Data Structure", b4);
		map.put("Shadow", m1);
		map.put("Play", m2);
		map.put("Game", m3);
		map.put("Breathe", s1);
		map.put("Game of Thrones", s2);
		map.put("Vikings", s3);
		
	}
	static Date dateInput() {

		Date date = null;
		while (date == null) {

			String line = scan.next();
			try {
				date = format.parse(line);
			} catch (java.text.ParseException e) {
				System.out.println("Sorry, that's not valid. Please try again.");
			}

		}
		return date;
	}
	
	static void addConsume(Consumable obj1)

	{	
		
		if(Rating != 0)
		{
			obj1.setPersonalRating(Rating);
		}
		obj1.setRating(Rating);
		System.out.println("Consumable succesfully added");
		
		map.put(name, obj1);
		//		con.add(obj1);
	}
	static void addConsumeWithDay(Consumable obj1)
	{
		if(Rating != 0)
		{
			obj1.setPersonalRating(Rating);
		}
		
		System.out.println("Consumable succesfully added");
		map.put(name, obj1);

	}
	static void addConsumeWithHour(Consumable obj1)
	{
	
		if(Rating != 0)
		{
			obj1.setPersonalRating(Rating);
		}
//		obj1.setRating(Rating);
//		obj1.setTotalHour(hour);
		

		System.out.println("Consumable succesfully added");
		map.put(name, obj1);
	}
	public static void main(String[] args) throws ParseException {
		String permission, importType;	
		boolean shouldContinue = true;		
		init();
		System.out.println();
		while(shouldContinue) { // input loop
			System.out.println("Enter 1 to Add a consumable");
			System.out.println("Enter 2 to Update a consumable");
			System.out.println("Enter 3 to Delete a consumable");
			System.out.println("Enter 4 to See the list of consumables and individually");
			System.out.println("Enter 5 to See overall info ");
			System.out.println("Enter 6 to cancel operation");

			typeInput = scan.nextInt();
			scan.nextLine(); 

			if(typeInput == 1)
			{
				System.out.println("Enter 0 to choose Type movies");
				System.out.println("Enter 1 to choose Type books");
				System.out.println("Enter 2 to choose Type series");
				consumableType = scan.nextInt();
				scan.nextLine();
				if(consumableType == 0)
				{
					importType = "movie"; 
				}
				else if(consumableType == 1)
				{
					importType = "books"; 
				}
				else
				{
					importType = "series"; 
				}
				System.out.println("Enter name of the " +importType);
				name = scan.nextLine();

				System.out.println("Do you want to give rating now? if No, then enter 0 else give your rating ");
				Rating = scan.nextDouble();


				System.out.println("Do you want to add starting and eding date? yes/no");		
				permission = scan.next();

				if(permission.equals("yes"))
				{

					System.out.println("Enter Starting date in the format yyyy-MM-dd");
					startingDate = dateInput();
					System.out.println("Enter Ending date in the format yyyy-MM-dd");
					endingDate = dateInput();
					System.out.println(format.format(startingDate));
					System.out.println(format.format(endingDate));
				}
				else
				{
					System.out.println("How do you want to store consumption? day/hour");
					timeInput = scan.next();
					if(timeInput.equals("day"))
					{
						System.out.println("Enter the consumption amount in day");
						day = scan.nextInt();
					}
					else if(timeInput.equals("hour"))
					{
						System.out.println("Enter the consumption amount in hour");
						hour = scan.nextInt();
					}					

				}
				// -------------------- finished taking general inputs ----------------


				if(consumableType == 0) // movie input
				{
					if(permission.equals("yes")) {

						Consumable obj1 = new Movie(name, startingDate, endingDate, Rating);
						addConsume(obj1);
						System.out.println(" map " + map.get(name).getTotalHour());
					}
					else
					{
						if(timeInput.equals("day"))
						{
							Consumable obj1 = new Movie(name, day, Rating);
							addConsumeWithDay(obj1);
						}
						else
						{
							Consumable obj1 = new Movie(name,hour,Rating);
							addConsumeWithHour(obj1);					

						}

					}
				}
				else if(consumableType == 1) // book input
				{
					if(permission.equals("yes")) {
						Consumable obj1 = new Book(name, startingDate, endingDate, Rating);
						addConsume(obj1);
					}
					else
					{
						if(timeInput.equals("day"))
						{
							Consumable obj1 = new Book(name, day, Rating);
							addConsumeWithDay(obj1);
						}
						else
						{
							Consumable obj1 = new Book(name,hour,Rating);
							addConsumeWithHour(obj1);
						}

					}

				}
				else if(consumableType == 2) // series input
				{
					if(permission.equals("yes")) {
						Consumable obj1 = new Series(name, startingDate, endingDate, Rating);
						addConsume(obj1);

					}
					else
					{
						if(timeInput.equals("day"))
						{
							Consumable obj1 = new Series(name, day,Rating);
							addConsumeWithDay(obj1);
						}
						else
						{
							Consumable obj1 = new Series(name,hour,Rating);
							addConsumeWithHour(obj1);
						}

					}
				}



			}
			else if(typeInput == 2) //update consumables
			{

				System.out.println("Enter 0 to update Movie consumable");
				System.out.println("Enter 1 to update Book consumable");
				System.out.println("Enter 2 to update series consumable");
				int itemType = scan.nextInt();
				scan.nextLine();

				if(itemType == 0) // movie update
				{
					System.out.println("Enter 1 to add hour to total consumption time");
					System.out.println("Enter 2 to add day to day time");
					System.out.println("Enter 3 to Change rating");
					System.out.println("Enter 4 to add ending date");

					int choice = scan.nextInt();
					scan.nextLine();

					if(choice == 1)
					{

						System.out.println("Enter the name of the movie");
						String updatedMovie = scan.nextLine();
						if(!map.containsKey(updatedMovie))
						{
							System.out.println("No such record exist!!");
						}


						System.out.println("Enter the hour to add to the total Hour Consumption");
						double updatedHour = scan.nextDouble();
						scan.nextLine();

						map.get(updatedMovie).setTotalHour(updatedHour);
						System.out.println(map.get(updatedMovie).getTotalHour());
						System.out.println("Total Hour Updated");


					}
					else if(choice == 2)
					{
						System.out.println("Enter the name of the movie");
						String updatedMovie = scan.nextLine();
						if(!map.containsKey(updatedMovie))
						{
							System.out.println("No such record exist!!");
						}
						System.out.println("Enter the amount of day to add to the day consumption ");
						double updatedDay = scan.nextDouble();
						scan.nextLine();
						
			map.get(updatedMovie).setDay(updatedDay);
						System.out.println("Day consumption Updated");
						
						

					}
					else if(choice == 3)
					{
						System.out.println("Enter the name of the movie");
						String updatedMovie = scan.nextLine();
						if(!map.containsKey(updatedMovie))
						{
							System.out.println("No such records exist!!");
						}
						System.out.println("Enter new ratings out of 10");
						double updatedRating = scan.nextDouble();
						scan.nextLine();

						map.get(updatedMovie).setRating(updatedRating);
						System.out.println("Rating Updated");
					}
					else if(choice == 4)
					{
						System.out.println("Enter the name of the movie");
						String updatedMovie = scan.nextLine();
						if(!map.containsKey(updatedMovie))
						{
							System.out.println("No such records exist!!");
						}
						System.out.println("Enter the ending Date");
						Date updatedDate = dateInput();
						map.get(updatedMovie).setEndingDate(updatedDate);
						System.out.println("Ending date Updated"); 
					}
				}
				else if(itemType == 1) // book update
				{
					System.out.println("Enter 1 to add hour to total consumption time");
					System.out.println("Enter 2 to add day to day time");
					System.out.println("Enter 3 to Change rating");
					System.out.println("Enter 4 to add ending date");

					int choice = scan.nextInt();
					scan.nextLine();

					if(choice == 1)
					{

						System.out.println("Enter the name of the book");
						String updatedBook = scan.nextLine();
						if(!map.containsKey(updatedBook))
						{
							System.out.println("No such records exist!!");
						}


						System.out.println("Enter the hour to add to the total Hour Consumption");
						double updatedHour = scan.nextDouble();
						scan.nextLine();

						map.get(updatedBook).setTotalHour(updatedHour);
						System.out.println("Total Hour Updated");
						System.out.println(map.get(updatedBook));

					}
					else if(choice == 2)
					{
						System.out.println("Enter the name of the Book");
						String updatedBook = scan.nextLine();
						if(!map.containsKey(updatedBook))
						{
							System.out.println("No such records exist!!");
						}
						System.out.println("Enter the amount of day to add to the day consumption ");
						double updatedDay = scan.nextDouble();
						scan.nextLine();
						
						map.get(updatedBook).setDay(updatedDay);
						System.out.println("Day consumption Updated");	
					}
					else if(choice == 3)
					{
						System.out.println("Enter the name of the movie");
						String updatedBook = scan.nextLine();
						if(!map.containsKey(updatedBook))
						{
							System.out.println("No such records exist!!");
						}
						System.out.println("Enter new ratings out of 10");
						double updatedRating = scan.nextDouble();
						scan.nextLine();

						map.get(updatedBook).setRating(updatedRating);
						System.out.println("Rating Updated");
					}
					else if(choice == 4)
					{
						System.out.println("Enter the name of the book");
						String updatedBook = scan.nextLine();
						if(!map.containsKey(updatedBook))
						{
							System.out.println("No such records exist!!");
						}
						System.out.println("Enter the ending Date");
						Date updatedDate = dateInput();
						map.get(updatedBook).setEndingDate(updatedDate);
						System.out.println("Ending date Updated"); 
					}

				}
				else if(itemType == 2) // series update
				{
					System.out.println("Enter 1 to add hour to total consumption time");
					System.out.println("Enter 2 to add day to day time");
					System.out.println("Enter 3 to Change rating");
					System.out.println("Enter 4 to add ending date");

					int choice = scan.nextInt();
					scan.nextLine();

					if(choice == 1)
					{

						System.out.println("Enter the name of the series");
						String updatedSeries = scan.nextLine();
						if(!map.containsKey(updatedSeries))
						{
							System.out.println("No such records exist!!");
						}

						System.out.println("Enter the hour to add to the total Hour Consumption");
						double updatedHour = scan.nextDouble();
						scan.nextLine();

						map.get(updatedSeries).setTotalHour(updatedHour);
						System.out.println("Total Hour Updated");
						System.out.println(map.get(updatedSeries));

					}
					else if(choice == 2)
					{
						System.out.println("Enter the name of the movie");
						String updatedSeries = scan.nextLine();
						if(!map.containsKey(updatedSeries))
						{
							System.out.println("No such records exist!!");
						}
						System.out.println("Enter the amount of day to add to the day consumption ");
						double updatedDay = scan.nextDouble();
						scan.nextLine();
						
						map.get(updatedSeries).setDay(updatedDay);
						System.out.println("Day consumption Updated");
					}
					else if(choice == 3)
					{
						System.out.println("Enter the name of the series");
						String updatedSeries = scan.nextLine();
						if(!map.containsKey(updatedSeries))
						{
							System.out.println("No such records exist!!");
						}
						System.out.println("Enter new ratings out of 10");
						double updatedRating = scan.nextDouble();
						scan.nextLine();

						map.get(updatedSeries).setRating(updatedRating);
						System.out.println("Rating Updated");
					}
					else if(choice == 4)
					{
						System.out.println("Enter the name of the series");
						String updatedSeries = scan.nextLine();
						if(!map.containsKey(updatedSeries))
						{
							System.out.println("No such records exist!!");
						}
						System.out.println("Enter the ending Date");
						Date updatedDate = dateInput();
						map.get(updatedSeries).setEndingDate(updatedDate);
						System.out.println("Ending date Updated"); 
					}
				}


			}
			else if(typeInput == 3) //delete consumption
			{
					System.out.println("Enter 0 to delete a cosumable from movie");
					System.out.println("Enter 1 to delete a cosumable from book");
					System.out.println("Enter 2 to delete a cosumable from series");
					
					int choice = scan.nextInt();
					scan.nextLine();
					
					if(choice == 0 )
					{
						System.out.println("Enter the movie name you wanna delete");
						String deletedMovie = scan.nextLine();
						
						map.remove(deletedMovie);
						System.out.println("deleted successfully");
					}
					else if(choice == 1)
					{
						System.out.println("Enter the movie name you wanna delete");
						String deletedBook = scan.nextLine();
						
						map.remove(deletedBook);
					}
					else
					{
						System.out.println("Enter the movie name you wanna delete");
						String deletedSeries = scan.nextLine();
						
						map.remove(deletedSeries);
					}
					
					
					
			}
			else if(typeInput == 4)
			{
				
				System.out.println("Enter a specific type to see its details like Movie,Book or Series");
				String detailsType = scan.nextLine();
					double totalTypeRating=0.0,count=0;
					System.out.println("---------------------------------------------------");
					System.out.println("Name -----total Day ---- total Hrs --- rating ");
					for (String i : map.keySet()) {
						//System.out.println(map.get(i).getType());
						if(map.get(i).getType().equals(detailsType)) {
							totalTypeRating += map.get(i).getRating();
							count++;
						  System.out.println(map.get(i).getName() + "      " +map.get(i).getTotalDays()+ "            " +map.get(i).getTotalHour()+ "            " +map.get(i).getRating());
						  //System.out.println("hello");
						}
						}
					System.out.println("Average rating of "+detailsType+" is "+totalTypeRating/(double)count);
					System.out.println("-----------------------------------------------------");				
			}
			else if(typeInput == 5)
			{
				double totalDay=0, totalhr=0, totalRating=0;
				System.out.println("---------------------------------------------------");
				System.out.println("Name -----Day ---- Hrs --- rating ");
				for (String i : map.keySet()) {
					
					totalDay += map.get(i).getTotalDays();
					totalhr += map.get(i).getTotalHour();
					totalRating += map.get(i).getRating();
					  System.out.println(map.get(i).getName() + "      " +map.get(i).getTotalDays()+ "            " +map.get(i).getTotalHour()+ "            " +map.get(i).getRating());
					}
				System.out.println("Total day of consumption is "+totalDay );
				System.out.println("Total hour of consumption is "+totalhr);
				System.out.println("Average rating is "+totalRating/(double)map.size() );
				System.out.println("-----------------------------------------------------");
				
			}
			else if(typeInput == 6)
			{
				shouldContinue = false;
				System.out.println("Exiting");
				scan.close();
			}

		}

	}

}
