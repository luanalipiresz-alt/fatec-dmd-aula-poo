import java.util.ArrayList;
import java.util.List;

public class Exercicio6 {
    static class Pais {
        private String codigoISO, nome;
        private long populacao;
        private double dimensao;
        private final List<Pais> fronteiras = new ArrayList<>();
        public Pais(String codigoISO,String nome,double dimensao){this.codigoISO=codigoISO;this.nome=nome;this.dimensao=dimensao;}
        public String getCodigoISO(){return codigoISO;} public void setCodigoISO(String v){codigoISO=v;}
        public String getNome(){return nome;} public void setNome(String v){nome=v;}
        public long getPopulacao(){return populacao;} public void setPopulacao(long v){populacao=v;}
        public double getDimensao(){return dimensao;} public void setDimensao(double v){dimensao=v;}
        public void adicionarFronteira(Pais p){if(p!=null&&!equals(p)&&!fronteiras.contains(p)&&fronteiras.size()<40)fronteiras.add(p);}
        public boolean ehLimitrofe(Pais p){return fronteiras.contains(p);}
        public double densidade(){return dimensao==0?0:populacao/dimensao;}
        public Pais[] vizinhosComuns(Pais p){
            List<Pais> comuns=new ArrayList<>();
            for(Pais vizinho:fronteiras) if(p.fronteiras.contains(vizinho)) comuns.add(vizinho);
            return comuns.toArray(new Pais[0]);
        }
        @Override public boolean equals(Object o){return o instanceof Pais && codigoISO.equals(((Pais)o).codigoISO);}
        @Override public int hashCode(){return codigoISO.hashCode();}
        @Override public String toString(){return nome+" ("+codigoISO+")";}
    }
    public static void main(String[] args){
        Pais brasil=new Pais("BRA","Brasil",8515767), argentina=new Pais("ARG","Argentina",2780400);
        brasil.setPopulacao(203000000); brasil.adicionarFronteira(argentina);
        System.out.println(brasil+"; densidade: "+brasil.densidade());
        System.out.println("Argentina é limítrofe? "+brasil.ehLimitrofe(argentina));
    }
}
