import java.util.ArrayList;
import java.util.List;

public class Exercicio7 {
    static class Pais {
        String nome; long populacao; double dimensao;
        Pais(String nome,long populacao,double dimensao){this.nome=nome;this.populacao=populacao;this.dimensao=dimensao;}
        @Override public String toString(){return nome;}
    }
    static class Continente {
        private String nome;
        private final List<Pais> paises=new ArrayList<>();
        public Continente(String nome){this.nome=nome;}
        public void adicionarPais(Pais p){if(p!=null&&paises.size()<48)paises.add(p);}
        public double dimensaoTotal(){double total=0;for(Pais p:paises)total+=p.dimensao;return total;}
        public long populacaoTotal(){long total=0;for(Pais p:paises)total+=p.populacao;return total;}
        public double densidade(){return dimensaoTotal()==0?0:populacaoTotal()/dimensaoTotal();}
        private Pais extremo(java.util.function.ToLongFunction<Pais> f,boolean maior){
            if(paises.isEmpty())return null; Pais escolhido=paises.get(0);
            for(Pais p:paises)if(maior?f.applyAsLong(p)>f.applyAsLong(escolhido):f.applyAsLong(p)<f.applyAsLong(escolhido))escolhido=p;
            return escolhido;
        }
        public Pais maiorPopulacao(){return extremo(p->p.populacao,true);}
        public Pais menorPopulacao(){return extremo(p->p.populacao,false);}
        public Pais maiorDimensao(){if(paises.isEmpty())return null;Pais r=paises.get(0);for(Pais p:paises)if(p.dimensao>r.dimensao)r=p;return r;}
        public Pais menorDimensao(){if(paises.isEmpty())return null;Pais r=paises.get(0);for(Pais p:paises)if(p.dimensao<r.dimensao)r=p;return r;}
        public double razaoTerritorial(){Pais maior=maiorDimensao(),menor=menorDimensao();return menor==null||menor.dimensao==0?0:maior.dimensao/menor.dimensao;}
        @Override public String toString(){return nome;}
    }
    public static void main(String[] args){
        Continente c=new Continente("América do Sul");
        c.adicionarPais(new Pais("Brasil",203000000,8515767));
        c.adicionarPais(new Pais("Argentina",46000000,2780400));
        System.out.println(c+" - população: "+c.populacaoTotal()+" - área: "+c.dimensaoTotal());
        System.out.println("Maior população: "+c.maiorPopulacao());
    }
}
