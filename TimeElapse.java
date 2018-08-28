import javax.swing.*;
import java.awt.*;
public class TimeElapse extends JPanel
{
   private JLabel tLabel;
   private JLabel label;
   int sec;
   public TimeElapse ()
   {
      setLayout(new GridLayout(1, 2));
      sec = 0;
   
      label = new JLabel("Time:", SwingConstants.LEFT);
      label.setFont(new Font("Serif", Font.BOLD, 20));
      label.setForeground(Color.blue);
      add(label);
          
      tLabel = new JLabel("0:00", SwingConstants.RIGHT);
      tLabel.setFont(new Font("Serif", Font.BOLD, 20)); 
      tLabel.setForeground(Color.blue);
      add(tLabel);
   }
   
   public void increment()
   {
      sec++;
      display();
   }
   
   private void display()
   {
      int m = sec/60;
      int s = sec%60;
      String sTime = ""+s;
      if (s < 10)
      {
         sTime = "0"+s;
      }
      tLabel.setText(m+":"+sTime);
   }
   
   public void reset()
   {
      sec = -1;
   }
   
   public int getMin()
   {
      return sec/60;
   }
   public int getSec()
   {
      return sec%60;
   }

}