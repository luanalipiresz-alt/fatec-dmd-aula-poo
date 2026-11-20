public class Exercicio10 {
    static class Matriz {
        private final int linhas,colunas; private final double[][] dados;
        public Matriz(int linhas,int colunas){if(linhas<=0||colunas<=0)throw new IllegalArgumentException("Dimensões inválidas");this.linhas=linhas;this.colunas=colunas;dados=new double[linhas][colunas];}
        public int getLinhas(){return linhas;} public int getColunas(){return colunas;}
        public double get(int i,int j){return dados[i][j];} public void set(int i,int j,double v){dados[i][j]=v;}
        public Matriz transposta(){Matriz r=new Matriz(colunas,linhas);for(int i=0;i<linhas;i++)for(int j=0;j<colunas;j++)r.dados[j][i]=dados[i][j];return r;}
        public Matriz oposta(){Matriz r=copiar();for(int i=0;i<linhas;i++)for(int j=0;j<colunas;j++)r.dados[i][j]*=-1;return r;}
        public Matriz nula(){return new Matriz(linhas,colunas);}
        public boolean identidade(){if(linhas!=colunas)return false;for(int i=0;i<linhas;i++)for(int j=0;j<colunas;j++)if(dados[i][j]!=(i==j?1:0))return false;return true;}
        public boolean diagonal(){if(linhas!=colunas)return false;for(int i=0;i<linhas;i++)for(int j=0;j<colunas;j++)if(i!=j&&dados[i][j]!=0)return false;return true;}
        public boolean singular(){if(!diagonal())return false;for(int i=1;i<linhas;i++)if(dados[i][i]!=dados[0][0])return false;return true;}
        public boolean simetrica(){return linhas==colunas&&equals(transposta());}
        public boolean antiSimetrica(){return linhas==colunas&&oposta().equals(transposta());}
        public void adicionar(Matriz m){validarDimensoes(m);for(int i=0;i<linhas;i++)for(int j=0;j<colunas;j++)dados[i][j]+=m.dados[i][j];}
        public void subtrair(Matriz m){validarDimensoes(m);for(int i=0;i<linhas;i++)for(int j=0;j<colunas;j++)dados[i][j]-=m.dados[i][j];}
        public void multiplicar(Matriz m){if(colunas!=m.linhas)throw new IllegalArgumentException("Dimensões incompatíveis");double[][] r=new double[linhas][m.colunas];for(int i=0;i<linhas;i++)for(int j=0;j<m.colunas;j++)for(int k=0;k<colunas;k++)r[i][j]+=dados[i][k]*m.dados[k][j];}
        private void validarDimensoes(Matriz m){if(linhas!=m.linhas||colunas!=m.colunas)throw new IllegalArgumentException("Dimensões incompatíveis");}
        public Matriz copiar(){Matriz r=new Matriz(linhas,colunas);for(int i=0;i<linhas;i++)System.arraycopy(dados[i],0,r.dados[i],0,colunas);return r;}
        @Override public boolean equals(Object o){if(!(o instanceof Matriz))return false;Matriz m=(Matriz)o;if(linhas!=m.linhas||colunas!=m.colunas)return false;for(int i=0;i<linhas;i++)for(int j=0;j<colunas;j++)if(Double.compare(dados[i][j],m.dados[i][j])!=0)return false;return true;}
        @Override public int hashCode(){return java.util.Arrays.deepHashCode(dados);}
        @Override public String toString(){StringBuilder s=new StringBuilder();for(double[] linha:dados)s.append(java.util.Arrays.toString(linha)).append("\\n");return s.toString();}
    }
    public static void main(String[] args){Matriz m=new Matriz(2,2);m.set(0,0,1);m.set(1,1,1);System.out.println(m);System.out.println("É identidade? "+m.identidade());}
}
