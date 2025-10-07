package td2;

public abstract class Polygone {

    // Attribut privé
    private Point[] sommets;

    // Constructeur acceptant un tableau de Point
    public Polygone(Point... sommets) throws PolygoneException {
        if (sommets == null) {
            throw new PolygoneException("Le tableau de sommets ne peut pas être null");
        }
        if (sommets.length < 3) {
            throw new PolygoneException("Un polygone doit avoir au moins 3 sommets");
        }

        // Vérifier qu'aucun sommet n'est null
        for (int i = 0; i < sommets.length; i++) {
            if (sommets[i] == null) {
                throw new PolygoneException("Le sommet " + i + " ne peut pas être null");
            }
        }

        this.sommets = sommets;
    }

    // Accesseur getSommets
    public Point[] getSommets() {
        return sommets;
    }

    // Méthode périmètre
    public double perimetre() throws PolygoneException, NullException {
        double perimetre = 0.0;

        // Distance entre chaque sommet consécutif
        for (int i = 0; i < sommets.length - 1; i++) {
            perimetre += sommets[i].distance(sommets[i + 1]);
        }

        // Distance entre le dernier et le premier sommet pour fermer
        perimetre += sommets[sommets.length - 1].distance(sommets[0]);

        return perimetre;
    }

    // Méthode surface (abstraite, à redéfinir dans les sous-classes)
    public abstract double surface() throws PolygoneException, NullException;

    // Méthode pour obtenir le texte des sommets
    public String texteSommets() {
        String texte = "";
        for (int i = 0; i < sommets.length; i++) {
            texte += sommets[i].toString();
            if (i < sommets.length - 1) {
                texte += ", ";
            }
        }
        return texte;
    }

    // Redéfinition de equals pour comparer deux polygones
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Polygone)) return false;

        Polygone p = (Polygone) obj;
        if (this.sommets.length != p.sommets.length) return false;

        int n = sommets.length;

        for (int offset = 0; offset < n; offset++) {
            boolean match = true;
            for (int i = 0; i < n; i++) {
                if (!this.sommets[i].equals(p.sommets[(i + offset) % n])) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
        }

        return false;
    }


    // Redéfinition de toString
    @Override
    public String toString() {
        return "Polygone à " + sommets.length + " sommets : " + texteSommets();
    }
}
