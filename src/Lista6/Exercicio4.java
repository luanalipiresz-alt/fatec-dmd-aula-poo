public class Exercicio4 {
    static class Ponto {
        double x, y;
        Ponto(double x, double y) { this.x=x; this.y=y; }
        @Override public String toString() { return "(" + x + ", " + y + ")"; }
    }
    static class Reta {
        private double a, b;
        public Reta(double a, double b) { this.a=a; this.b=b; }
        public Reta(Ponto p1, Ponto p2) {
            if (Double.compare(p1.x,p2.x)==0) throw new IllegalArgumentException("Reta vertical não pode ser representada por y=ax+b.");
            a=(p2.y-p1.y)/(p2.x-p1.x); b=p1.y-a*p1.x;
        }
        public double getA() { return a; }
        public void setA(double a) { this.a=a; }
        public double getB() { return b; }
        public void setB(double b) { this.b=b; }
        public boolean contem(Ponto p) { return Math.abs(p.y-(a*p.x+b)) < 1e-9; }
        public Ponto intersecao(Reta r) {
            if (Math.abs(a-r.a)<1e-9) return null;
            double x=(r.b-b)/(a-r.a); return new Ponto(x,a*x+b);
        }
        @Override public String toString() { return a + "x + " + b; }
    }
    public static void main(String[] args) {
        Reta r1=new Reta(2,1), r2=new Reta(1,3);
        System.out.println("Reta: y = " + r1);
        System.out.println("Interseção: " + r1.intersecao(r2));
    }
}
