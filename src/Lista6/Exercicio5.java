public class Exercicio5 {
    static class Circulo {
        private double raio;
        private Ponto2D centro;
        static class Ponto2D {
            double x,y;
            Ponto2D(double x,double y){this.x=x;this.y=y;}
            @Override public String toString(){return "("+x+", "+y+")";}
        }
        public Circulo(double raio, Ponto2D centro) { if(raio<0) throw new IllegalArgumentException("Raio inválido"); this.raio=raio; this.centro=new Ponto2D(centro.x,centro.y); }
        public Circulo(double raio) { this(raio,new Ponto2D(0,0)); }
        public double getRaio(){return raio;}
        public void setRaio(double raio){if(raio<0) throw new IllegalArgumentException("Raio inválido");this.raio=raio;}
        public void inflar(double v){if(v<0)throw new IllegalArgumentException();raio+=v;}
        public void desinflar(double v){if(v<0||v>raio)throw new IllegalArgumentException("Valor inválido");raio-=v;}
        public void inflar(){inflar(1);}
        public void desinflar(){desinflar(1);}
        public void mover(){centro=new Ponto2D(0,0);}
        public void mover(double x,double y){centro=new Ponto2D(x,y);}
        public void mover(Ponto2D p){mover(p.x,p.y);}
        public double area(){return Math.PI*raio*raio;}
        @Override public String toString(){return "Centro "+centro+", raio "+raio;}
    }
    public static void main(String[] args){Circulo c=new Circulo(5);System.out.println(c);System.out.println("Área: "+c.area());}
}
