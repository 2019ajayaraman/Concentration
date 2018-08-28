
import java.io.*;      //the File class
import java.util.*;    //the Scanner class
import javax.swing.JOptionPane;
import java.util.Comparator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class Scoreboard extends JPanel
{
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private boolean re;
   private Player [] array;
   private int numitems;
   public Scoreboard(Player [] p, int num, String name)
   {
         
      re = false;
      array = p;
      setLayout(new BorderLayout());
      
      int temp = num;
      if (num>10)
      {
         temp = 10;
      }
      JPanel subpanel = new JPanel();
      subpanel.setLayout(new GridLayout(temp, 2));
      
      JLabel title = new JLabel("", SwingConstants.LEFT);
      title.setIcon(new ImageIcon("HighScoresButton.png"));
      add(title, BorderLayout.NORTH);
      
      for (int i = 0; i<temp; i++)
      {
         subpanel.add(new JLabel((i+1)+".   "+array[i].getName(), SwingConstants.LEFT));
         String s = array[i].getSeconds()+"";
         if (array[i].getSeconds()<10)
         {
            s="0"+s;
         }
         
         subpanel.add(new JLabel(array[i].getMinutes()+":"+s, SwingConstants.RIGHT));
      }
      add(subpanel, BorderLayout.CENTER);
      
      JPanel jp = new JPanel();
      jp.setLayout(new GridLayout(1,   1));
      
      JButton b = new JButton("Quit");
      b.addActionListener( new Quit() );
      b.setEnabled(true);
      jp.add (b);
      
      // JButton pa = new JButton("Play Again");
   //       pa.addActionListener( new Reset() );
   //       pa.setEnabled(true);
   //       jp.add (pa);
      
      add (jp, BorderLayout.SOUTH);
      
      setBackground(new Color (102, 255, 255));
      subpanel.setBackground(new Color (102, 255, 255));
      
      int pos = linear(array, name);
      pos++;
      int t = pos%10;
      while (t%10 >= 10)
      {
         t = pos%10;
      }
      
      String suffix = "";
      if (t > 10 && t <20)
      {
         suffix = "th";
      }
      else if (t == 1)
      {
         suffix = "st";
      }
      else if (t == 2)
      {
         suffix = "nd";
      }
      else if (t == 3)
      {
         suffix = "rd";
      }
      else
      { suffix = "th";
      
      }
      
      
      JOptionPane.showMessageDialog(null,"Your rank is "+pos+suffix);
      
      
      
      
         /*
      label1= new JLabel(array[0].toString(), SwingConstants.LEFT);
      label1.setFont(new Font("Serif", Font.BOLD, 20)); //edit for asthetics
      label1.setForeground(Color.blue); //edit for asthetics
      add(label1);
          
      label2= new JLabel(array[1].toString(), SwingConstants.LEFT);
      label2.setFont(new Font("Serif", Font.BOLD, 20)); //edit for asthetics
      label2.setForeground(Color.blue); //edit for asthetics
      add(label2);
      
      label3= new JLabel(array[2].toString(), SwingConstants.LEFT);
      label3.setFont(new Font("Serif", Font.BOLD, 20)); //edit for asthetics
      label3.setForeground(Color.blue); //edit for asthetics
      add(label3);
      */
   }
   
   public static int linear(Player [] array, String target)
   {
       
      for (int i = 0; i<array.length; i++)
      {
         if (array[i].getName().equals(target))
         {
            return i;
         }
      }
      return -1;
   }
   private class Quit implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
       
      }
   }
   
 // // /*    private class Reset implements ActionListener
// //    {
// //       public void actionPerformed(ActionEvent e)
// //       {
// //          re = true;
// //        
// //       }
// //    } */
   
   public boolean reset()
   {
      return re;
   }

   
}




