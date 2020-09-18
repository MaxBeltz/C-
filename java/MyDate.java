import java.io.*;
import java.util.*;

class MyDate implements DateInterface
{
	int Day;
	int Dow;
	int Month;
	int Year;
	Scanner scan = new Scanner(System.in);
	
	public MyDate()
	{
		Month = 0;
		Day = 0;
		Year = 0;
		Dow = 0;
	}
	
	public MyDate(int M, int D, int Y, int W)
	{
		Month = M;
		Day = D;
		Year = Y;
		Dow = W;
	}
	
	public int getDay()
	{
		return Day;
	}
	
	public int getDow()
	{
		return Dow;
	}
	
	public int getMonth()
	{
		return Month;
	}
	
	public int getYear()
	{
		return Year;
	}
	
	public void set(int m, int d, int y, int dow)
	{
		Month = m;
		Day = d;
		Year = y;
		Dow = dow;
	}
	
	public boolean LeapYear()
	{
		if (Year % 4 == 0)
		{
			if (Year % 100 == 0)
			{
				if (Year % 400 == 0)
					return true;
				else
					return false;
			}
			else
				return true;
		}
		else
			return false;
	}
	
	public int CheckMonth()
	{
		if (Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10)
			return 31;
		else if (Month == 4 || Month == 6 || Month == 9 ||Month == 11)
			return 30;
		else if (Month == 2)
		{
			if (LeapYear() == true)
				return 29;
			else
				return 28;
		}
		else
		{
			if (Day == 31)
				return -1;
			else
				return 31;
		}
	}
	
	public int DowInc()
	{
		if (Dow == 6)
		{
			Dow = 0;
			return Dow;
		}
		else
			return Dow++;
	}
	
	public void tomorrow()
	{
		if (Day == CheckMonth())
		{
			Month++;
			Day = 1;
			DowInc();
		}
		else if (CheckMonth() == -1)
		{
			Month = 1;
			Day = 1;
			Year++;
			DowInc();
		}
		else
		{
			Day++;
			DowInc();
		}
	}

	public String DowPretty()
	{
		if(Dow == 0)
			return "Sunday";
		else if(Dow == 1)
			return "Monday";
		else if(Dow == 2)
			return "Tuesday";
		else if(Dow == 3)
			return "Wednesday";
		else if(Dow == 4)
			return "Thursday";
		else if(Dow == 5)
			return "Friday";
		else if(Dow == 6)
			return "Saturday";
		else
			return "Error";
	}
	
	public String MonthPretty()
	{
		if(Month == 1)
			return "Janurary";
		else if(Month == 2)
			return "February";
		else if(Month == 3)
			return "March";
		else if(Month == 4)
			return "April";
		else if(Month == 5)
			return "May";
		else if(Month == 6)
			return "June";
		else if(Month == 7)
			return "July";
		else if(Month == 8)
			return "August";
		else if(Month == 9)
			return "September";
		else if(Month == 10)
			return "October";
		else if(Month == 11)
			return "November";
		else if(Month == 12)
			return "Decemer";
		else
			return "Error";
	}
	
	public String toString()
	{
		return DowPretty() + ", " + MonthPretty() + " " + Day + ", " + Year;
	}

	public void today()
	{
	}
	  
	public void yesterday()
	{
	}
}
