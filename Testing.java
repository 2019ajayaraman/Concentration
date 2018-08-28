
import java.io.*;      //the File class
import java.util.*;    //the Scanner class
import javax.swing.JOptionPane;
import java.util.Comparator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class Testing extends JPanel
{
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private Player [] array, temp;
   private Player p;
   private int numitems;
   private String text;
   public Testing(Player z, int level)
   {
      text = "scoresLevel"+level+".txt";
      p = z;
   
   }
   public Player [] getSorted()
   {
      return array;
   }
   public int getNum()
   {
      return array.length;
   }
   public void update()
   {
      temp = input(text);
      array = add(p, temp);
      sort(array);
      sortAlpha(array);
      save(array, text);
   }
   public Player[] input(String filename)
   {
      
      Scanner infile = null;
      try{
         infile = new Scanner(new File(filename));
      }
      catch(FileNotFoundException e)
      {
         JOptionPane.showMessageDialog(null,"The file could not be found.");
         System.exit(0);
      }
      numitems = Integer.parseInt(infile.nextLine());
      Player[]temp = new Player[numitems];
      for(int k = 0; k < numitems; k++)
      {
         temp [k] = new Player (infile.nextLine());
      }
      infile.close();
      return temp;
   
   }
   
   public Player [] add(Player p, Player [] temp)
   {
      Player [] t = new  Player[numitems+1];
      for (int i = 0; i<t.length-1; i++)
      {
         t[i] = temp[i];
      }
      t[t.length-1]= p;
      return t;
   }
   
   public static void sortAlpha (Player [] array)
   {
      int diff;
      for (int k = 0; k < array.length; k++)
      {
         for (int i = array.length-1; i>0; i--)
         {
            if (array[i].compareTo(array[i-1])==0)
            {
               if ((array[i].getName()).compareTo(array[i-1].getName())<0)
               {
                  Player temp = array[i];
                  array[i] = array[i-1];
                  array[i-1] = temp;
               }
            }
         }
      }
   }
   
   public static void sort(Comparable[] array)
   {
      int minPos;
      for(int k = 0; k < array.length; k++)
      {
         minPos = findMin(array, array.length - k-1);
         swap(array, minPos, array.length - k - 1);
      }
   }

   public static int findMin(Comparable[] array, int upper)
   {
      int index = 0;
      for (int i = 1; i<= upper; i++)
      {
         if(array[index].compareTo(array[i]) < 0)
         {
            index = i;
         }
      } 	
      return index;
   }
   public static void swap(Comparable[] array, int a, int b)
   {
      Comparable temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   
   public static void save(Player[] array, String filename)
   {
      PrintStream outfile = null;
      try{
         outfile = new PrintStream(new FileOutputStream(filename));
      }
      catch(FileNotFoundException e)
      {
         JOptionPane.showMessageDialog(null,"The file could not be created.");
      }
      System.setOut(outfile);
      System.out.println(array.length);
      for(int k = 0; k < array.length; k++)
      {
         System.out.println(array[k].toString());
      }
      outfile.close();
   }
}