package client.utility;
public class Time
{
  private int hour;
  private int minute;
  private int second;

  public Time(int h, int m, int s)
  {
    this.hour = h;
    this.minute = m;
    this.second = s;
  }
  public Time(int h, int m)
  {
    this.hour = h;
    this.minute = m;
  }
  public Time(int totalTimeInSeconds)
  {
    if (totalTimeInSeconds < 0)
    {
      totalTimeInSeconds = 0;
    }
    this.hour = totalTimeInSeconds / 3600;
    this.minute = (totalTimeInSeconds % 3600) / 60;
    this.second = (totalTimeInSeconds % 3600) % 60;
  }
  public void tic()
  {
    int a = convertToSeconds();
    a++;
    this.hour = a / 3600;
    this.minute = (a % 3600) / 60;
    this.second = (a % 3600) % 60;
  }
  public void tic(int seconds)
  {
    int a = convertToSeconds();
    a +=seconds;
    this.hour = a / 3600;
    this.minute = (a % 3600) / 60;
    this.second = (a % 3600) % 60;
  }
  public int convertToSeconds()
  {
    return (hour*60*60) + (minute*60) + second;
  }
  public boolean isBefore(Time time2)
  {
    return convertToSeconds()<time2.convertToSeconds();
  }
  public Time timeTo(Time time2)
  {
    int timeInSeconds = time2.convertToSeconds() - ((hour*3600) + (minute * 60) + second);
    Time time = new Time(timeInSeconds);
    return time;
  }
  public Time copy()
  {
    Time time = new Time(hour, minute, second);
    return time;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Time))
    {
      return false;
    }
    Time other = (Time)obj;
    return this.hour == other.hour && this.minute == other.minute && this.second == other.second;
  }

  @Override public String toString()
  {
    return this.hour + ":" + this.minute + ":" + this.second;
  }
}
