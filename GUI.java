//Name: Isfandyar Virani  &  Riyanson Alfred
//ID: 7751854 & 7810835  
//Course: ITI 1121 Section A
//Assignment: 1

import java.awt.*;

import javax.swing.*;
public class GUI 
{
 public static int size ;
 public static Color color1 = (new Color(255,242,193)); // VERY light brown
 public static Color color2 = (new Color (188,82,20)); // Dark BROWN
 public static Color color3 = Color.BLACK;
// public static Color col4 = Color.WHITE;
 public GUI(int size)
 {
  this.size = size;
 }
 
 public void Graphics (Individual marcel)
 {
   int[] marcelArray = new int [size];
   for(int x = 0 ; x < size ; x++)
   {
    marcelArray[x] = marcel.getAttribute(x);  
   }
   
   JFrame Board = new JFrame();
  Board.setSize(600, 600);
  Board.setTitle("Assignment 1");
  Container pane = Board.getContentPane();
Container pane2 = Board.getContentPane(); // 
  pane.setLayout(new GridLayout(size, size));
 pane2.setLayout(new GridLayout(size,size)); // 
  Color temp;
  for (int i = 0; i < size; i++)
  {
   if (i%2 == 0)
   {
     temp = color1;
   }
   else
   {
    temp = color2;
   }
   for (int j = 0; j < size; j++)
   {
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel(); //
    JLabel Q = new JLabel ("QUEEEN");
//    Q.setFont(new Font("Q", Font.PLAIN, size*2));
    panel.setBackground(temp);
    if (temp.equals(color1))
    {
     temp = color2;
    }
    else
    {
     temp = color1;
    }
    pane.add(panel);
   
    
    
    
    if( i == marcelArray[j])
    {
       
     panel.setBackground(color3);
      pane2.add(panel);
      panel.add(Q);
    }
    
   }
  }
  
  for(int m = 0 ; m < size ; m++)
  {
    
    
  }
  Board.setVisible(true); 
 }
 


}
