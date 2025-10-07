package td2;

public class Rectangle extends Polygone {
    private Point sg; //supérieur gauche
    private Point id; //supérieur droit
    private Point sd; //supérieur droit
    private Point ig; // inférieur gauche

    // Constructeur
    public Rectangle(Point sg, Point id) {
        this.sg = sg;
        this.id = id;
        //Ensuite on calcul automatiquement les 2 autres sommets
        this.sd = new Point(id.getX(), sg.getY());
        this.ig = new Point(sg.getX(), id.getY());
    }

    public double surface() {
        double largeur = Math.abs(id.getX() - sg.getX());
        double hauteur = Math.abs(id.getY() - sg.getY());
        return 2 * (largeur + hauteur);
    }

    public double perimetre() {
        double largeur = Math.abs(id.getX() - sg.getX());
        double hauteur = Math.abs(sg.getY() - id.getY());
        return 2 * (largeur + hauteur);
    }

    public String toString() {
        return "rectangle à plat avec sommets"
                + sg +"," + sd + "," + id +"," + ig;

    }

}
