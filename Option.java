import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Option extends JPanel
{
   private JLabel label;
   private double total;
   private JPanel subpanel;
   private JButton level1, level2, level3, quit, instruct;
   private Testing scores;
   private Display display;
   private TimeElapse time;
   private Timer timer;
   private String name, p;
   private JTextField box;
   private JFrame frame;
   private int level;
   public Option()
   {
      level = 0; 
      subpanel = new JPanel();
      frame = new JFrame("Instructions");
      
      subpanel.setLayout(new GridLayout (4, 1));
      setLayout(new BorderLayout());      
      
      level1 = new JButton("");
      level1.addActionListener( new Level1() );
      level1.setEnabled(true);
      level1.setBackground(Color.WHITE);
      level1.setIcon(new ImageIcon("level1button.png"));
      subpanel.add(level1);
      
      level2 = new JButton("");
      level2.addActionListener( new Level2() );
      level2.setEnabled(true);
      level2.setBackground(Color.WHITE);
      level2.setIcon(new ImageIcon("level2button.png"));
      subpanel.add(level2);
   
   
      level3 = new JButton("");
      level3.addActionListener( new Level3() );
      level3.setEnabled(true);
      level3.setBackground(Color.WHITE);
      level3.setIcon(new ImageIcon("level3button.png"));
      subpanel.add(level3);
      
      quit = new JButton("Quit");
      quit.addActionListener( new Quit() );
      quit.setEnabled(true);
      subpanel.add(quit);
      
      add(subpanel, BorderLayout.WEST);
      add(new JLabel("Concentration", SwingConstants.CENTER), BorderLayout.NORTH);
      
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      
      panel.add(new JLabel("\n\n\n\n\nPlease Enter your Username and then Choose a Level on the Left\n\n\n", SwingConstants.CENTER));
      
      box = new JTextField("Enter your name", 30);
      panel.add(box);
      
      instruct = new JButton("Instructions");
      instruct.addActionListener( new Instr());
      panel.add(instruct);
      
      JLabel logo = new JLabel();
      logo.setIcon(new ImageIcon("logo.png"));
      panel.add(logo);
      
      add(panel, BorderLayout.CENTER);
      
      setBackground(new Color (153, 255, 153));
      panel.setBackground(new Color (153, 255, 153));
      subpanel.setBackground(new Color (153, 255, 153));
   }
   

   private class Quit implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
       
      }
   }
   
   private class Level1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (!test())
         {
            error(getName());
         }
         else
         {
            level = 1;
         }
      }
   }
   
   private class Level2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (!test())
         {
            error(getName());
         }
         else
         {
            level = 2;
         }
      }
   }
   
   private class Level3 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         if (!test())
         {
            error(getName());
         }
         else
         {
            level = 3;
         }
       
      }
   }
   
    
   private class Instr implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JPanel jp = new JPanel();
         JPanel sp = new JPanel();
         sp.setLayout(new GridLayout(4, 1));
         jp.setLayout(new BorderLayout());
         jp.add(new JLabel("Instructions", SwingConstants.CENTER), BorderLayout.NORTH);
         sp.add(new JLabel("Objective: Match all the cards as quickly as you can."), BorderLayout.CENTER);
         sp.add(new JLabel("To Play: To match a card, click it to flip it over, and then click a second card."), BorderLayout.CENTER);
         sp.add(new JLabel("                  If you correctly guessed, your cards will remain flipped."), BorderLayout.CENTER);
         sp.add(new JLabel("                  Otherwise, the cards will flip back over."), BorderLayout.CENTER);
      
         jp.add(sp, BorderLayout.CENTER);
         
         
         JButton b = new JButton ("OK. Got it!");
         b.addActionListener(new Leave());
         jp.add(b, BorderLayout.SOUTH);
         
         frame.setSize(500, 200);
         frame.setLocation(200, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(jp);
         frame.setVisible(true);
      
       
      }
   }
   
   private class Leave implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         frame.setVisible(false);
      }
   }
   
   
   public boolean test()
   {
      if (getName().indexOf(' ') == -1)
      {
         return true;
      }
      return false;
   }
   
   public void error(String n)
   {
      JOptionPane.showMessageDialog(null,"Sorry, "+n+" is not an available username. Please enter a new username.");
   }
   
     
   public int getLevel()
   {
      return level;
   }
   public String getName()
   {
      return box.getText();
   }


}