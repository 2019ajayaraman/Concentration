import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class Panel extends JPanel
{
   private JLabel label;
   private double total;
   private JPanel subpanel;
   private JButton reset, quit;
   private Testing scores;
   private Display display;
   private TimeElapse time;
   private Timer timer;
   private String name, p;
   private int threshold;
   public Panel(String n, int level)
   {
      setLayout(new BorderLayout());
      p = null;     
      name = n;
      display = new Display(level);
      threshold = 0;
      switch (level)
      {
         case 1: threshold = 8;
            break;
         case 2: threshold = 18;
            break;
         case 3: threshold = 32;
            break;
      }
      
      time = new TimeElapse();
      
      add(time, BorderLayout.NORTH);
      add(display, BorderLayout.CENTER);
      
      subpanel = new JPanel ();
      subpanel.setLayout (new GridLayout (1, 2));
      
      reset = new JButton("Reset");
      reset.addActionListener( new Reset() );
      reset.setEnabled(true);
      subpanel.add(reset);
      
      quit = new JButton("Quit");
      quit.addActionListener( new Quit() );
      quit.setEnabled(true);
      subpanel.add(quit);
      
      add (subpanel, BorderLayout.SOUTH);
      setBackground(Color.GREEN.brighter());
      
      timer = new Timer(1000, new Update());
      timer.setInitialDelay(1000);
      timer.start(); 
      
   }
   
   private class Reset implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         timer.stop();
         display.reset();
         time.reset();
         timer.start();
       
      }
   }
   
   private class Quit implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
       
      }
   }
   
   private class Update implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         time.increment(); 
         if (display.getCount() == threshold)
         {
            timer.stop();
            p = create(time.getMin(), time.getSec());
            
         }      
      }
   }
   
   public String create (int min, int sec)
   {
      return name+" "+min+":"+sec;
   }
   
   public String getPerson()
   {
      return p;
   }
}