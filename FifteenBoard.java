
package fifteenproject;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JPanel;

public class FifteenBoard extends JPanel implements MouseListener
{
    //size is length and width of board
    private static final int size = 4;
    //2d int array of square values(0-15)
    private int[][] board;
    //Emptyx and y are indicies of the empty square
    private int numMoves, emptyX, emptyY;
    
    private boolean won;
    
    
    public FifteenBoard()
    {
        emptyX = emptyY = 3;
        won = false;
        board = new int[size][size];
        numMoves = 0;
        addMouseListener(this);
        
        //this is the winning order but newgame shuffles this.
        int i = 1;
        for(int y = 0; y < size; y++)
        {
            for(int x = 0; x < size; x++)
            {
                board[x][y] = i;
                i++;
                
            }
            
        }
        board[emptyX][emptyY] = 0;
        
        
        //comment newGame out to check if the game wins
        
        newGame();
        checkWin();
    }
    
    public void newGame()
    {
        //reset variables
        numMoves = 0;
        won = false;
        
        //shuffles the game
        
       int rx, ry, temp = 0;
       Random r = new Random();
       
       for(int x = 0; x < size;x++)
        {
            for(int y = 0; y < size; y++)
            {
                rx = r.nextInt(size);
                ry = r.nextInt(size);

                //swap x,y with random indicies of board[][]
                temp = board[x][y];
                board[x][y] = board[rx][ry];
                board[rx][ry] = temp;
                
            }
        }
       
       
       for(int x = 0; x < size; x++)
       {
           for(int y = 0; y < size;y++)
           {
               if(board[x][y] == 0)
               {
                   emptyX = x;
                   emptyY = y;
                   break;
               }
           }
       }
       repaint();
       
    }
    
    //swaps elements and indexs, assuming the move is legal.
    public void swapSquares(int x,int y)
    {
        board[emptyX][emptyY] =board[x][y];
        board[x][y] = 0;
        
        //set empty square indexs
        emptyY = y;
        emptyX = x;
        
        
    }
    

    //moves the square if it is legal
    public void moveSquare(int x, int y)
    {
        
        //compares the empty square index and the picked one
        //the abs shortens the if making -1 included for the x and y
        
        
       if(((Math.abs(x - emptyX) == 1) || (Math.abs(y - emptyY) == 1))&&
               ((x - emptyX == 0) || (y - emptyY == 0)))
        {
            numMoves++;
            swapSquares(x, y);
            
        }
            
    }
    
    public void checkWin()
    {
        if (board[3][3] == 0)
        {
            // y & x are flipped because it goes left to right like a book
            int i = 1;
            for (int y = 0; y < size; y++)
            {
                for (int x = 0; x < size; x++)
                {
                    if(board[x][y] != i)
                    {
                        if(board[x][y] == 0)
                            won = true;
                        return;
                    }
                    else
                        i++;

                }
            }
            
        }
        
    }
    
    
    public int getNumClicks()
    {
        return numMoves;
    }

    public boolean getWin()
    {
        return won;
    }
    
    
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //Overriden Methods
    
    
    @Override
    public void mouseClicked(MouseEvent e)
    {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        
        if(!won)
        {
            int x, y;
            x = (e.getX()-3)/100;
            y = (e.getY()-3)/100;
            
            if((x >= 0)&&(x <= 3)&&(y>=0)&&(y<=3))
            {
                moveSquare(x, y);
            }
            checkWin();
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {}

    @Override
    public void mouseEntered(MouseEvent e)
    {}

    @Override
    public void mouseExited(MouseEvent e)
    {}
    
    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        FontMetrics fm = g.getFontMetrics();
        String s;
        Color c = new Color(0, 0, 0);
        
        if(won)
            c = Color.GREEN;
        else
            c = Color.BLUE;
        
        for(int x = 0; x < size;x++)
        {
            for(int y = 0; y < size; y++)
            {
                if(board[x][y] > board[emptyX][emptyY])
                    g.setColor(c);
                else
                    g.setColor(Color.WHITE);
                s = Integer.toString(board[x][y]);
                
                g.fillRect(3+(x*100), 3+(y*100), 97, 97);
                g.setColor(Color.WHITE);
                fm.stringWidth(s);
                
                g.drawString(s, ((fm.stringWidth(s)/s.length())+(25/s.length())+(x * 100)), 
                        ((fm.getHeight())+25+(y * 100)));
                    
            }
        }
        
    }
}
