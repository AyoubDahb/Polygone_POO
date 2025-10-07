package td2;

public class Point {


    // Constante

    public static final double epsilon = 0.0000000001;

    // Attributs privés
    private double x;
    private double y;

    // Constructeur
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Accesseurs (getters)
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Méthode distance
    // Méthode distance - vérifier que le point n'est pas null
    public double distance(Point p)throws NullException,PolygoneException{
        if (p == null) {
            throw new NullException("Le point ne peut pas être null");
        }
        double distx = x - p.x;
        double disty = y - p.y;
        double distxcarre = distx * distx;
        double distycarre = disty * disty;
        double d = Math.sqrt(distycarre + distxcarre);
        return d;
    }



    // Méthode statique memeReel
    public static boolean memeReel(double a, double b) {
        if (Math.abs(a-b) > epsilon){
            return false;
        } else {
            return true;
        }

    }

    // Redéfinition de equals
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Point)) return false;

        Point p = (Point) obj;
        return memeReel(this.x, p.x) && memeReel(this.y, p.y);
    }

    // Redéfinition de toString
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
