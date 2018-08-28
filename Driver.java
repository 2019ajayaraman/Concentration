import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Driver  
{
   public static void main(String[] args)
   {
   
   
      JFrame o = new JFrame("Welcome");
      JFrame frame1 = new JFrame("Concentration");
      JFrame frame2 = new JFrame("High Scores");
   
      Option op = new Option();
      o.setSize(600 , 350);
      o.setLocation(200, 100);
      o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      o.setContentPane(op);
      o.setVisible(true);
       
      int level = op.getLevel();
      String n = "";
      while (level == 0)
      {
         level = op.getLevel();
      }
      n = op.getName();    
      o.setVisible(false);
   
      
      
      Panel p = new Panel(n, level);
      frame1.setSize(500, 500);
      frame1.setLocation(200, 100);
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.setContentPane(p);
      frame1.setVisible(true);
            
      String per = p.getPerson();
      while (per == null)
      {
         per = p.getPerson();
      }
    
      frame1.setVisible(false);
      
      
      
      Testing scores = new Testing(new Player(per), level);
      scores.update();
      Scoreboard s = new Scoreboard(scores.getSorted(), scores.getNum(), n);
      frame2.setSize(325, 500);
      frame2.setLocation(200, 100);
      frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame2.setContentPane(s);
      frame2.setVisible(true);
   }
}