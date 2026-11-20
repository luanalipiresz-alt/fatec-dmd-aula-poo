public class Exercicio2 {
    static class Ponto2D implements Cloneable {
        private double x, y;
        public Ponto2D() { this(0, 0); }
        public Ponto2D(double x, double y) { this.x = x; this.y = y; }
        public Ponto2D(Ponto2D p) { this(p.x, p.y); }
        public double getX() { return x; }
        public void setX(double x) { this.x = x; }
        public double getY() { return y; }
        public void setY(double y) { this.y = y; }
        public void mover() { x = 0; y = 0; }
        public void mover(double x, double y) { this.x = x; this.y = y; }
        public void mover(Ponto2D p) { mover(p.x, p.y); }
        public double distancia(Ponto2D p) { return Math.hypot(x - p.x, y - p.y); }
        @Override public boolean equals(Object o) {
            if (!(o instanceof Ponto2D)) return false;
            Ponto2D p = (Ponto2D)o;
            return Double.compare(x, p.x) == 0 && Double.compare(y, p.y) == 0;
        }
        @Override public int hashCode() { return java.util.Objects.hash(x, y); }
        @Override public String toString() { return "(" + x + ", " + y + ")"; }
        @Override public Ponto2D clone() { return new Ponto2D(this); }
    }
    public static void main(String[] args) {
        Ponto2D p1 = new Ponto2D(3, 4), p2 = new Ponto2D();
        System.out.println("Ponto: " + p1);
        System.out.println("Distância até a origem: " + p1.distancia(p2));
        System.out.println("Cópia: " + p1.clone());
    }
}
