import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Display extends JPanel
{
   private JButton[][] board;
   private int[][] matrix;
   private int hits;
   private JButton reset;
   private int x, y, level;
   private int count;
   private ImageIcon icon;
   private String tag;
   public Display(int l) 
   {
      setLayout(new BorderLayout());
      hits = 0;
      icon = new ImageIcon("Card.png");
      level = l;
      tag = "";    
      int width = 0; 
      
      switch(level)
      {
         case 1: tag = "dog";
            width = 4;
            break;
         case 2: tag = "food";
            width = 6;
            break;
         case 3: tag = "sport";
            width = 8;
            break;
      }
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(width,width));
      add(center, BorderLayout.CENTER);
      
      board = new JButton[width][width];
      matrix = new int[width][width];
      int count = 0;
      int temp = 0;
      for(int r = 0; r < board.length; r++)
         for(int c = 0; c < board[0].length; c++)
         {
            board[r][c] = new JButton();
            board[r][c].setBackground(Color.WHITE);
            board[r][c].setIcon(icon);
            board[r][c].addActionListener( new Play(r, c) );
            center.add(board[r][c]);
            matrix[r][c] = count;
            
            temp++;
            if (temp%2 == 0)
            {
               count++;
            }
         }
         
      scramble();
      /*
        
      for(int r = 0; r < board.length; r++)
      {
         for(int c = 0; c < board[0].length; c++)
         {
            System.out.print (matrix[r][c]);
            
         }
         System.out.println();
      }
      System.out.println();
      */
                      
   }
   private  void scramble() 
   {
      for(int y = 0; y < 100; y++)
      {
         int a = (int)(Math.random() * matrix.length);
         int b = (int)(Math.random() * matrix[0].length);
         int c = (int)(Math.random() * matrix.length);
         int d = (int)(Math.random() * matrix[0].length);
            
         swap(a, b, c, d);
      }      
   
   }
   private void swap(int a, int b, int c, int d)
   {
      int temp = matrix[a][b];
      matrix[a][b] = matrix[c][d];
      matrix[c][d] = temp;
      
      
      
   }


   public boolean match(int b, int j)
   {
      return (b == j);
   }
   public void setIcon(int a, int b, int c)
   {
      a++;
      board[b][c].setBackground(Color.WHITE);
      board[b][c].setIcon(new ImageIcon(tag+a+".png"));
      board[b][c].setDisabledIcon(new ImageIcon(tag+a+".png"));
      
   }
   
   
   private class Play implements ActionListener 
   {
      private int row, col;
      
      
      public Play(int r, int c)
      {
         row = r;
         col = c;
      }
      public void actionPerformed(ActionEvent e)
      {
         hits++;

         if(hits == 1)
         {
            x = row;
            y = col;
            
            board[x][y].setEnabled(false);
            setIcon(matrix[x][y],x,y);
         }
         
         if (hits%2 == 1)
         {
            System.out.println (matrix[x][y]);
         }
         else
         {
            System.out.println (matrix[row][col]);
         }
                  
         if (hits > 1)
         {
            
            board[row][col].setEnabled(false);
            setIcon(matrix[row][col],row,col);
         
               new SwingWorker<Void,Void>() {
                  @Override
                  protected Void doInBackground() throws Exception {
                     Thread.sleep(250);
                     return null;
                  }
                  @Override
                  protected void done() {
                     if(!match(matrix[row][col], matrix[x][y]))
                     {                     
                        board[row][col].setIcon(icon);
                        board[x][y].setIcon(icon);
                        board[row][col].setEnabled(true);
                        board[x][y].setEnabled(true);
                     }
                     else
                     {
                        count++;
                     }
                  }
               }.execute();
         
            hits = 0;
         }
      }
   }
        
   
   
   public void reset()
   {
      hits = 0;
      for(int r = 0; r < board.length; r++)
         for(int c = 0; c < board[0].length; c++)
         {
            board[r][c].setEnabled(true);
            board[r][c].setIcon(icon);
            scramble();
         }
   
   }
   public int getCount ()
   {
      return count;
   }
  }




