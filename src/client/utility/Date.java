package client.utility;
import java.time.LocalDate;

public class Date
{
  private int day;
  private int month;
  private int year;
  public Date(int day, int month, int year)
  {
    set(day, month, year);
  }
  public Date(int day, String monthName, int year)
  {
    this.day = day;
    this.month = convertToMonthNumber(monthName);
    this.year = year;
  }
  public Date()
  {
    LocalDate today = LocalDate.now();
    this.day = today.getDayOfMonth();
    this.month = today.getMonthValue();
    this.year = today.getYear();
  }
  public void set(int day, int month, int year)
  {
    if(year < 0)
    {
      year = -year;
    }
    if(month < 1)
    {
      month = 1;
    }
    else if(month > 12)
    {
      month = 12;
    }
    this.year = year;
    this.month = month;
    if(day < 1)
    {
      day = 1;
    }
    else if(day > numberOfDaysInMonth())
    {
      day = numberOfDaysInMonth();
    }
    this.day = day;
  }
  public int getDay()
  {
    return day;
  }
  public int getMonth()
  {
    return month;
  }
  public int getYear()
  {
    return year;
  }
  public boolean isLeapYear()
  {
    if(year % 4 == 0 && ((year % 100 != 0) || year % 400 == 0))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public void stepForward(int days)
  {
    for(int i = 0; i < days; i++)
    {
      stepForwardOneDay();
    }
  }
  public String getMonthName()
  {
    if(month == 1)
    {
      return "January";
    }
    else if(month == 2)
    {
      return "February";
    }
    else if(month == 3)
    {
      return "March";
    }
    else if (month == 4)
    {
      return "April";
    }
    else if (month == 5)
    {
      return "May";
    }
    else if(month == 6)
    {
      return "June";
    }
    else if(month == 7)
    {
      return "July";
    }
    else if(month == 8)
    {
      return "August";
    }
    else if(month == 9)
    {
      return "September";
    }
    else if(month == 10)
    {
      return "October";
    }
    else if(month == 11)
    {
      return "November";
    }
    else if(month == 12)
    {
      return "December";
    }
    return "Error";
  }
  public void stepForwardOneDay()
  {
    day++;
    if(day>numberOfDaysInMonth())
    {
      month++;
      day=1;
    }
    if (month > 12)
    {
      month=1;
      year++;
    }
  }
  public int numberOfDaysInMonth()
  {
    if(month == 2 && isLeapYear() == true)
    {
      return 29;
    }
    if(month == 2 && isLeapYear() == false)
    {
      return 28;
    }
    if(month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
    {
      return 31;
    }
    return 0;
  }
  public boolean isBefore(Date other)
  {
    int dummyDaysOfThis = year * 400 + month * 31 + day;
    int dummyDaysOfOther = other.year * 400 + other.month * 31 + other.day;
    return dummyDaysOfThis<dummyDaysOfOther;
  }
  public int yearsBetween(Date other)
  {
    int years = 0;
    if (isBefore(other))
    {
      years = other.year - this.year;
      if (this.month > other.month || (this.month == other.month && this.day > other.day))
      {
        years--;
      }
    }
    else
    {
      years = this.year - other.year;
      if(other.month > this.month || (other.month == this.month && other.day > this.day))
      {
        years--;
      }
    }
    return years;
  }
  public String dayOfWeek()
  {
    double answer1;
    answer1 = ((13 *(month +1)) / 5);
    answer1 = answer1 + day;
    answer1 = answer1 + (year%100);
    answer1 = answer1 + ((year % 100)/4);
    answer1 = answer1 + ((year/100)/4);
    answer1 = answer1 + (5*(year/100));
    answer1 = answer1 % 7;
    switch ((int) answer1)
    {
      case 0: return "Saturday";
      case 1: return "Sunday";
      case 2: return "Monday";
      case 3: return "Tuesday";
      case 4: return "Wednesday";
      case 5: return "Thursday";
      case 6: return "Friday";
      default: return "Error";
    }
  }

  @Override public String toString()
  {
    if (day < 10 && month >= 10)
    {
      return "0" + day + "/" + month + "/" + year;
    }
    if (day < 10 && month < 10)
    {
      return "0" + day + "/" + "0" + month + "/" + year;
    }
    if (day > 10 && month < 10)
    {
      return day + "/" + "0" + month + "/" + year;
    }
    else
    {
      return day + "/" + month + "/" + year;
    }
  }
  public static int convertToMonthNumber(String monthName)
  {
    switch (monthName)
    {
      case "January": return 1;
      case "February": return  2;
      case "March":  return 3;
      case "April": return  4;
      case "May": return 5;
      case "June": return 6;
      case "July": return 7;
      case "August": return 8;
      case "September": return 9;
      case "October": return 10;
      case "November": return 11;
      case "December": return 12;
    }
    return 0;
  }
  public Date copy()
  {
    Date other = new Date(day, month, year);
    return other;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Date))
    {
      return false;
    }
    Date other = (Date)obj;
    return this.day == other.day && this.month == other.month && this.year == other.year;
  }
}
