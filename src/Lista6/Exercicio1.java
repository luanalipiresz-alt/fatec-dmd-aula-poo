public class Exercicio1 {
    static class Contador {
        private int valor;
        public void zerar() { valor = 0; }
        public void incrementar() { valor++; }
        public int getValor() { return valor; }
    }
    public static void main(String[] args) {
        Contador c = new Contador();
        c.incrementar();
        c.incrementar();
        System.out.println("Valor do contador: " + c.getValor());
        c.zerar();
        System.out.println("Após zerar: " + c.getValor());
    }
}
