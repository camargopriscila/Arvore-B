package arvore;

public class No {

	int valor, fb;
	No Esq, Dir;
              
	public No(){
		this.Esq = null;
		this.Dir = null;
		this.valor = 0;
		this.fb = 0;
	}
	
	public No(int v){
		this.Esq = null;
		this.Dir = null;
		this.valor = v;
		this.fb = 0;
	}
	
	public void setEsq(No n){
		this.Esq = n;
	}
	
	public void setDir(No n){
		this.Dir = n;
	}
	
	public void setValor(int v){
		this.valor = v;
	}
	
	public No getEsq(){
            
		return Esq;
	}
	
	public No getDir(){
		return Dir;
	}
	
	public int getValor(){
		return valor;
	}
	
}