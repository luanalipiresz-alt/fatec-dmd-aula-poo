public class Exercicio3 {
    static class NumeroComplexo {
        private double real, imaginaria;
        public NumeroComplexo(double real, double imaginaria) { this.real = real; this.imaginaria = imaginaria; }
        public double getReal() { return real; }
        public void setReal(double real) { this.real = real; }
        public double getImaginaria() { return imaginaria; }
        public void setImaginaria(double imaginaria) { this.imaginaria = imaginaria; }
        public void somar(NumeroComplexo n) { real += n.real; imaginaria += n.imaginaria; }
        public void subtrair(NumeroComplexo n) { real -= n.real; imaginaria -= n.imaginaria; }
        public void multiplicar(NumeroComplexo n) {
            double r = real*n.real - imaginaria*n.imaginaria;
            double i = real*n.imaginaria + imaginaria*n.real;
            real = r; imaginaria = i;
        }
        public void dividir(NumeroComplexo n) {
            double d = n.real*n.real + n.imaginaria*n.imaginaria;
            if (d == 0) throw new ArithmeticException("Divisão por zero.");
            double r = (real*n.real + imaginaria*n.imaginaria)/d;
            double i = (imaginaria*n.real - real*n.imaginaria)/d;
            real = r; imaginaria = i;
        }
        public double modulo() { return Math.hypot(real, imaginaria); }
        @Override public boolean equals(Object o) {
            if (!(o instanceof NumeroComplexo)) return false;
            NumeroComplexo n = (NumeroComplexo)o;
            return Double.compare(real,n.real)==0 && Double.compare(imaginaria,n.imaginaria)==0;
        }
        @Override public int hashCode() { return java.util.Objects.hash(real, imaginaria); }
        @Override public String toString() { return real + (imaginaria < 0 ? " - " + (-imaginaria) : " + " + imaginaria) + "i"; }
    }
    public static void main(String[] args) {
        NumeroComplexo z = new NumeroComplexo(3, 4);
        System.out.println("Número: " + z);
        System.out.println("Módulo: " + z.modulo());
    }
}
