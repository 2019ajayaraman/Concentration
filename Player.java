/**
 *  A Player is a class that implements Comparable and can compare its information with 
 *  another Player's information. It maintains information about its name, minutes, and seconds. 
 *  A Player knows how to return its name, minutes, and seconds, set its name, minutes, and seconds, and 
 *  calculate and return its name, minutes, and seconds.
 **/

public class Player implements Comparable<Player>
{
   private String myName;
   private int myMinutes, mySeconds;
   
   /** Default constructor. Sets myMinutes and mySeconds to 0. Constructs a Player with time of 0:00.
   **/
   public Player()
   {
      myMinutes = mySeconds = 0;
   }
   
   /** 
   *Constructor with one argument. The method parses a String input and gives myName, myMinutes, and mySeconds.
   *  Sets myName to the substring before the first ' ', myMinutes to the substring before the first ':', and   
   *  mySeconds to the remaining substring. Constructs a Player with the name myName, minutes myMinutes, and 
   *  seconds mySeconds. 
   *  @param s unparsed String
   **/
   public Player(String s)
   {
      myName = s.substring(0, s.indexOf(' '));
      s = s.substring(s.indexOf(' ')+1);
      myMinutes = Integer.parseInt(s.substring(0, s.indexOf(':')));
      s = s.substring(s.indexOf(':')+1);
      mySeconds = Integer.parseInt(s);
   }

/** Returns the name of the String.
   *  @return  name
   **/
   public String getName()
   {
      return myName;
   }
   
/** Returns the number of minutes of the String.
   *  @return  minutes
   **/
   public int getMinutes()
   {
      return myMinutes;
   }
   
/** Returns the number of seconds of the String.
   *  @return  seconds
   **/
   public int getSeconds()
   {
      return mySeconds;
   }
   
   /** Sets the name to s.
   *  @param s  Assigns s to myName
   **/	
   public void setName(String s)
   {
      myName = s;
   }
   
   /** Sets the number of minutes to a.
   *  @param a  Assigns a to myMinutes
   **/
   public void setMinutes(int a)
   {
      myMinutes = a;
   }
   
   /** Sets the number of seconds to b.
   *  @param b  Assigns b to mySeconds
   **/
   public void setSeconds(int b)
   {
      mySeconds = b;
   }
   
   /** Calculates the number of seconds in the two Players. Returns the difference.
   *  @return difference
   *  @param p  player to compare to
   **/
   public int compareTo(Player p)
   {
      int mTotal = (myMinutes*60) + mySeconds;
      int pTotal = (p.getMinutes()*60) + p.getSeconds();
      return mTotal - pTotal;
   }
   
   /** Determines whether or not two Players are equal. Calls the compareTo() method and
   *  tests if difference is equal to zero. Returns true or false.
   *  @return true or false
   * @param p player to compare to
   **/
   public boolean equalsTo(Player p)
   {
      return compareTo(p) == 0;
   }
   
   /** Combines and returns the name, minutes, and seconds of the Player in a String of the 
   *  format "name minutes:seconds".
   *  @return String
   **/
   public String toString()
   {
    String s = mySeconds+"";
    if (mySeconds < 10)
    {
     s = "0"+mySeconds;
    }
      return myName+" "+myMinutes+":"+s;
   }

}





