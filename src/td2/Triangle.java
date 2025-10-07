package td2;

public class Triangle extends Polygone {

    public Triangle(Point p1, Point p2, Point p3) throws PolygoneException {
        super(p1, p2, p3); // passer les points au constructeur Polygone
    }

    @Override
    public double surface() throws PolygoneException, NullException {
        Point[] s = getSommets();
        double a = s[0].distance(s[1]);
        double b = s[1].distance(s[2]);
        double c = s[2].distance(s[0]);
        double demiPerimetre = (a + b + c) / 2;
        return Math.sqrt(demiPerimetre * (demiPerimetre - a) * (demiPerimetre - b) * (demiPerimetre - c));
    }

    @Override
    public String toString() {
        try {
            Point[] s = getSommets();
            double ab = s[0].distance(s[1]);
            double bc = s[1].distance(s[2]);
            double ca = s[2].distance(s[0]);

            String type;
            if (Point.memeReel(ab, bc) && Point.memeReel(bc, ca)) {
                type = "équilatéral";
            } else if (Point.memeReel(ab, bc) || Point.memeReel(bc, ca) || Point.memeReel(ca, ab)) {
                type = "isocèle";
            } else {
                type = "scalène";
            }

            return "Triangle " + type + " : " + super.texteSommets();

        } catch (PolygoneException | NullException e) {
            return "Triangle invalide (exception levée : " + e.getMessage() + ")";
        }
    }

}
