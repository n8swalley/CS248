//**************************************************
// 
// Author: N8 Swalley
// Date: Tuesday, 29-January 2020
//
// 
//**************************************************

public class MyDate implements DateInterface
{	
	String month_name [] = {"January","February","March","April","May","June","July","August","September", "October","November","December"};
	String wk_day_name [] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	int month, day, year, wk_day;
	
	
	public void set(int m, int d, int y, int dow) 
	{
		month = m; day = d; year = y; wk_day = dow;
	}
	
	public int getDay() 
	{
		return day;
	} 
		
	public int getDow()
	{
		return wk_day;
	}
		

	public int getMonth()
	{
		return month;
	}
		
	public int getYear()
	{
		return year;
	}




	public void tomorrow() // Changes the date forward by one day and makes changes to weekday, month, & year
	{
		wk_day = (wk_day+1) % 7;
		
		if (month == 9 || month == 4 || month == 6 || month == 11)
		{
			day = (day%30)+1;
		}
		
		else if (month == 2) //February and Leap Year stuff
		{
			if ((year % 4 != 0) || (year % 4 == 0 && year % 100 == 0 && year % 400 != 0))
			{
				day = (day%28)+1;
			}
			else if ((year % 100 !=0 && year % 4 == 0) || (year % 400 == 0))
			{
				day = (day%29)+1;
			}
		}
		
		else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			day = (day%31)+1;
		}
		if (day == 1)
		{
			month = (month%12)+1;
		}
		if (month == 1 && day == 1)
		{
			year = year + 1;
		}
		
	}
	
	public String toString()
	{
		return wk_day_name [wk_day]+ ", "+month_name [month-1]+ " " +day+ ", " +year;
	}
	
	public void today()
	{

	}

	public void yesterday()
	{
		if (wk_day == 0)
		{
			wk_day = 6;
		}
		
		else
		{
			wk_day--;
		}
		
		if (day == 1)
		{
			if (month == 1)
			{
				year--;
				month = 12;
				day = 31;
			}
			else if (month == 3)
			{
				if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))
				{
					month = 2;
					day = 29;
				}
				else if ((year % 100 == 0 && year % 400 != 0 && year % 4 == 0)|| (year % 4 != 0))
				{
					month = 2;
					day = 28;
				}
			}
			else if (month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11)
			{
				month--;
				day = 31;
			}
			else if (month == 5 || month == 7 || month == 10 || month == 12)
			{
				month--;
				day = 30;		
			}
		} 
		
		else 
		{
			day--;
		}
	}
}