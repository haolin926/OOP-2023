package ie.tudublin;

import java.util.Random;

import processing.core.PApplet;

public class lifeBoard {
    boolean[][] borad;
    boolean[][] next;
    private int size;
    PApplet p;
    float cellwidth;

    public lifeBoard()
    {

    }
    public lifeBoard(int size,PApplet p)
    {
        this.size=size;
        this.p = p;
        borad = new boolean[size][size];
        next = new boolean[size][size];
        cellwidth = p.width / (float)size;
    }

    public void randomise()
    {
        for(int row =0;row<size;row++)
        {
            for(int col = 0;col<size;col++)
            {
                float dice = p.random(0,1);
                borad[row][col] = (dice < 0.5f);
            }
        }
    }
    public void clear()
    {
        for(int row = 0;row<size;row++)
        {
            for(int col = 0;col<size;col++)
            {
                borad[row][col] = false;
            }
        }
    }
    public void cross()
    {
        for(int row = 0;row<size;row++)
        {
            for(int col = 0;col<size;col++)
            {
                // if(row == p.height / 2 || col == p.width / 2)
                // {
                //     borad[row][col] = true;
                // }
                borad[row][col] = false;
            }
        }
        for(int row = 0;row<size;row++)
        {
            borad[row][row] = true;
            borad[row][size - row - 1] = true;
        }
    }

    public void render()
    {
        float c;
        for(int row = 0; row <size; row++)
        {
            for(int col = 0;col<size;col++)
            {
                if(borad[row][col])
                {
                    c = p.map(row,0,size/4,0,255);
                    c %= 255;
                    p.fill(c,255,255);
                }
                else
                {
                    p.noFill();
                }
                p.rect(col*cellwidth, row*cellwidth, cellwidth, cellwidth);
            }
        }
    }
    public void applyrules()
    {
        boolean[][] tmp;
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                // n<2 die
                // n>3 die
                // n =2||3 live

                //n = 3 die -> live
                int count;
                count = countCells(row, col);
                //live
                if(borad[row][col])
                {
                    if(count == 2 || count == 3)
                    {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
                    }

                }
                //dead
                else if(borad[row][col] == false)
                {
                    if(count == 3)
                    {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
                    }
                }

            }
        }
        tmp = borad;
        borad = next;
        next = tmp;
        
        
    }
    public boolean getcell(int row,int col)
    {
        if(row >= 0 && row <this.size && col >= 0 && col < size)
        {
            return borad[row][col];
        }
        else
        {
            return false;
        }
    }
    public int countCells(int row,int col)
    {
        int count =0;
        for(int i = -1; i <= 1 ; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                if(!(i ==0 && j == 0))
                {
                    if(getcell(row+i, col+j))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}
