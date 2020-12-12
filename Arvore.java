package arvore;


public class Arvore {

    private No raiz;
    public static final String blue = "\u001B[34m"; //estetica

    public Arvore() {
        raiz = null;
    }

    void attAltura(No n) {
        n.fb = 1 + Math.max(altura(n.Esq), altura(n.Dir));
    }

    int altura(No n) {
        return n == null ? -1 : n.fb;
    }

    int getBalanceamento(No n) {
        return (n == null) ? 0 : altura(n.Dir) - altura(n.Esq);
    }

    public No girarEsq(No y) {
        No x = y.Dir;
        No z = x.Esq;
        x.Esq = y;
        y.Dir = z;
        attAltura(y);
        attAltura(x);
        return x;
    }

    public No girarDir(No y) {
        No x = y.Esq;
        No z = x.Dir;
        x.Dir = y;
        y.Esq = z;
        attAltura(y);
        attAltura(x);
        return x;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public No rebalanceamento(No z) {
        attAltura(z);
        int balance = getBalanceamento(z);
        if (balance > 1) {
            if (altura(z.Dir.Dir) > altura(z.Dir.Esq)) {
                z = girarEsq(z);
            } else {
                z.Dir = girarDir(z.Dir);
                z = girarEsq(z);
            }
        } else if (balance < -1) {
            if (altura(z.Esq.Esq) > altura(z.Esq.Dir)) {
                z = girarDir(z);
            } else {
                z.Esq = girarEsq(z.Esq);
                z = girarDir(z);
            }
        }
        return z;
    }
    
    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    public No inserir(No no, int valor) {

        if (no == null) {
            no = new No(valor);
        } else {
            if (valor < no.getValor()) {
                if (no.getEsq() != null) {
                    inserir(no.getEsq(), valor);
                } else {
                    System.out.println("\nInserindo esquerda");
                    no.Esq = new No(valor);
                }
            } else if (valor > no.getValor()) {
                if (no.getDir() != null) {
                    inserir(no.getDir(), valor);
                } else {
                    System.out.println("\nInserindo direita");
                    no.Dir = new No(valor);
                }
            }
        }

        return rebalanceamento(no);

    }

    public void verBinaria() {

        if (verBinaria(raiz)) {
            System.out.println("É estritamente binaria");
        } else {
            System.out.println("Não é estritamente binaria");
        }

    }

    public boolean verBinaria(No n) {

        if (n == null) {
            return true;
        }

        if (n.getEsq() == null && n.getDir() == null) {
            return true;
        }

        if ((n.getEsq() != null) && (n.getDir() != null)) {
            return (verBinaria(n.getEsq()) && verBinaria(n.getDir()));
        }

        return false;

    }

    public boolean verAbb(No n, Integer menor, Integer maior) {

        if (n == null) {
            return true;
        }

        int val = n.getValor();

        //verificações
        if (menor != null && val <= menor) {
            return false;
        }

        if (maior != null && val >= maior) {
            return false;
        }

        //recursão
        if (!verAbb(n.getDir(), val, maior)) {
            return false;
        }

        if (!verAbb(n.getEsq(), menor, val)) {
            return false;
        }

        return true;

    }

    public boolean verAbb(No n) {
        return verAbb(n, null, null);
    }

    public void verAbb() {

        if (verAbb(raiz)) {
            System.out.println("É uma arvore binaria de busca");
        } else {
            System.out.println("Não é uma arvore binaria de busca");
        }

    }

    public void copiaArvore() {
        posOrdem(copiaArvore(raiz));
    }

    public No copiaArvore(No n) {

        if (n != null) {

            No raiz2 = new No();
            raiz2.valor = n.getValor();
            raiz2.Esq = copiaArvore(n.getEsq());
            raiz2.Dir = copiaArvore(n.getDir());
            return raiz2;

        } else {
            return null;
        }

    }

    public No deletaNo(No n, int val) {
        if (n == null) {
            return n;
        }
        if (val < n.getValor()) {
            n.Esq = deletaNo(n.Esq, val);
        } else if (val > n.getValor()) {
            n.Dir = deletaNo(n.Dir, val);
        } else {

            if (n.Esq == null) {
                return n.Dir;
            }
            if (n.Dir == null) {
                return n.Esq;
            }

            No minNo = achaMin(n.Dir);
            n.valor = minNo.getValor();
            n.Dir = deletaNo(n.Dir, minNo.getValor());
        }
        return rebalanceamento(n);
    }

    public No achaMin(No n) {
        while (n.getEsq() != null) {
            n = n.getEsq();
        }
        return n;
    }

    public void deleteNode(int val) {
        deletaNo(raiz, val);
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    public void emOrdem(No n) {
        if (n != null) {
            emOrdem(n.getEsq());
            System.out.println(blue + n.getValor() + " |");
            emOrdem(n.getDir());
        }
    }

    public void preOrdem(No n) {
        if (n != null) {
            System.out.println(blue + n.getValor() + " |");
            preOrdem(n.getEsq());
            preOrdem(n.getDir());
        }
    }

    public void posOrdem(No n) {
        if (n != null) {
            posOrdem(n.getEsq());
            posOrdem(n.getDir());
            System.out.println(blue + n.getValor() + " |");
        }
    }

}
