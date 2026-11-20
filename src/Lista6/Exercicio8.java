public class Exercicio8 {
    static class Pessoa {
        private String nome; private Pessoa pai, mae;
        public Pessoa(String nome){this(nome,null,null);}
        public Pessoa(String nome,Pessoa pai,Pessoa mae){this.nome=nome;this.pai=pai;this.mae=mae;}
        public boolean ehIrma(Pessoa p){return p!=null&&this!=p&&pai!=null&&mae!=null&&pai.equals(p.pai)&&mae.equals(p.mae);}
        public boolean ehAntecessora(Pessoa pessoa){
            if(pessoa==null)return false;
            if(pessoa.pai!=null&&(equals(pessoa.pai)||ehAntecessora(pessoa.pai)))return true;
            return pessoa.mae!=null&&(equals(pessoa.mae)||ehAntecessora(pessoa.mae));
        }
        @Override public boolean equals(Object o){if(!(o instanceof Pessoa))return false;Pessoa p=(Pessoa)o;return java.util.Objects.equals(nome,p.nome)&&java.util.Objects.equals(mae,p.mae);}
        @Override public int hashCode(){return java.util.Objects.hash(nome,mae);}
        @Override public String toString(){return nome;}
    }
    public static void main(String[] args){
        Pessoa pai=new Pessoa("Carlos"),mae=new Pessoa("Ana");
        Pessoa filha=new Pessoa("Luiza",pai,mae);
        System.out.println("Pessoa: "+filha);
        System.out.println("Pai é antecessor? "+pai.ehAntecessora(filha));
    }
}
