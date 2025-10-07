package td2;

public class Carre extends Rectangle {

    private Point sg; // sommet sup gauche
    private double cote; //longueur d'un côté

    // Constructeur

    public Carre(Point sg, double cote) {
        // pour appeler le constructeur du rect on calcule le point inférieur droit à partir de sg et cote
        super(sg, new Point(sg.getX()+cote, sg.getY()+cote));
        this.sg = sg;
        this.cote = cote;
    }

    // Redefinition de surface
    public double surface() {
        return cote * cote;
    }

    //Redefinition de toString
    public String toString() {

    }
}
