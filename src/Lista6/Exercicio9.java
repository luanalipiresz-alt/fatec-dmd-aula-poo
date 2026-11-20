import java.util.ArrayList;
import java.util.List;

public class Exercicio9 {
    static class Conjunto {
        private final List<String> elementos=new ArrayList<>();
        public boolean adicionar(String e){if(e==null||elementos.contains(e))return false;return elementos.add(e);}
        public boolean pertence(String e){return elementos.contains(e);}
        public Conjunto uniao(Conjunto outro){Conjunto r=new Conjunto();for(String e:elementos)r.adicionar(e);for(String e:outro.elementos)r.adicionar(e);return r;}
        public Conjunto inter(Conjunto outro){Conjunto r=new Conjunto();for(String e:elementos)if(outro.pertence(e))r.adicionar(e);return r;}
        public Conjunto menos(Conjunto outro){Conjunto r=new Conjunto();for(String e:elementos)if(!outro.pertence(e))r.adicionar(e);return r;}
        @Override public String toString(){return elementos.toString();}
    }
    public static void main(String[] args){
        Conjunto a=new Conjunto(),b=new Conjunto();
        a.adicionar("azul");a.adicionar("verde");b.adicionar("verde");b.adicionar("amarelo");
        System.out.println("União: "+a.uniao(b));
        System.out.println("Interseção: "+a.inter(b));
        System.out.println("Diferença: "+a.menos(b));
    }
}
