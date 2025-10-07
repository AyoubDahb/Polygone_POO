package td2;

public class Main {
    public static void main(String[] args) throws Exception {

        // === Test de Point ===
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(0, 0);

        System.out.println("=== Test Point ===");
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("Distance p1-p2: " + p1.distance(p2));
        System.out.println("p1.equals(p3): " + p1.equals(p3));
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("Point.memeReel(3.0, 3.0000000001): " + Point.memeReel(3.0, 3.0000000001));
        System.out.println("Point.memeReel(1.0, 2.0): " + Point.memeReel(1.0, 2.0));


        // === Test de Triangle ===
        System.out.println("\n=== Test Triangle ===");

        Triangle t1 = new Triangle(
                new Point(0, 0),
                new Point(3, 0),
                new Point(0, 4)
        );

        System.out.println("Triangle t1: " + t1);
        System.out.println("Périmètre: " + t1.perimetre());
        System.out.println("Surface: " + t1.surface());
        System.out.println("Nombre de sommets: " + t1.getSommets().length);

        Triangle t2 = new Triangle(
                new Point(1, 1),
                new Point(4, 1),
                new Point(2, 3)
        );

        System.out.println("\nTriangle t2: " + t2);
        System.out.println("Périmètre: " + t2.perimetre());
        System.out.println("Surface: " + t2.surface());

        // Test equals
        Triangle t3 = new Triangle(
                new Point(0, 0),
                new Point(3, 0),
                new Point(0, 4)
        );

        System.out.println("\nt1.equals(t3): " + t1.equals(t3));
        System.out.println("t1.equals(t2): " + t1.equals(t2));


        // === Test des exceptions ===
        System.out.println("\n=== Test des exceptions ===");

        try {
            // Test avec un des sommets null
            Triangle triAvecNull = new Triangle(new Point(0, 0), null, new Point(1, 1));
        } catch (PolygoneException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Test distance avec point null
            Point pNull = null;
            double dist = p1.distance(pNull);
        } catch (NullException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Test d’un tableau de sommets null (si ton Triangle gère ce cas)
            Point[] sommetsNull = null;
            Triangle triNull = new Triangle(sommetsNull[0], sommetsNull[1], sommetsNull[2]);
        } catch (PolygoneException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }
    }
}
