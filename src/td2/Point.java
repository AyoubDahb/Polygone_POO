package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Point {

    //attributs

    private double x;
    private double y;

    public Point(double x, double y){

        this.x=x;
        this.y=y;

    }


    /// getter

    public double getX(){return x; }
    public double getY(){return y;}

    public double Distance(Point p){
            double distx = x-p.x;
            double disty = y-p.y; 
            double distxcarre = distx * distx;
            double distycarre = disty*disty;
            double d = Math.sqrt(distycarre + distxcarre);
            return Math.abs(d);
    }

    public boolean memeReel(double a, double b){
        if (Math.abs(a-b)>0.0000000001){
            return false;
        }else{
            return true;
        }

    }

     public boolean equals(double a, double b){
      return memeReel(a,b);



    }

    public  tostring(){
        return (x,y);
    }

}

