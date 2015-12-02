package empresa;

public class Produto {
	private int codigo;
	private String descricao;
	private int est_min;
	private int est_atual;
	private double custo;
	private int pct_lucro;
	
	public Produto(int cod, String des, int estmin, int estatual, double cst, int pcl){
		this.codigo = cod;
		this.descricao = des;
		this.est_min = estmin;
		this.est_atual = estatual;
		this.custo = cst;
		this.pct_lucro = pcl;
	}
	public void aumentaEstoque(int quantComprada){
		this.est_atual = this.est_atual + quantComprada;
	}
	
	public void diminuiEstoque(int quantVendida){
		this.est_atual = this.est_atual - quantVendida;
	}
	
	public double calculaPreco(){
		return (this.custo * (1.0 + ((float)this.pct_lucro/100)));
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEst_min() {
		return est_min;
	}

	public void setEst_min(int est_min) {
		this.est_min = est_min;
	}

	public int getEst_atual() {
		return est_atual;
	}

	public void setEst_atual(int est_atual) {
		this.est_atual = est_atual;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public int getPct_lucro() {
		return pct_lucro;
	}

	public void setPct_lucro(int pct_lucro) {
		this.pct_lucro = pct_lucro;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", est_min=" + est_min + ", est_atual="
				+ est_atual + ", custo=" + custo + ", pct_lucro=" + pct_lucro + "]";
	}
	

}
