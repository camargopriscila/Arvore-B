package arvore;

import java.util.Scanner;

public class TesteArvore {
        
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		Arvore raiz = new Arvore();
	
		int op, numero;
		
		do{
			System.out.println();
			System.out.println("== MENU DE OPCOES ==");
			System.out.println("1 - Inserir na Arvore");
			System.out.println("2 - Imprimir em Pre Ordem");
			System.out.println("3 - Imprimir em Em Ordem");
			System.out.println("4 - Imprimir em Pos Ordem");
			System.out.println("5 - Excluir nó da Arvore");
			System.out.println("6 - Excluir a Arvore");
			System.out.println("7 - Verficar se a arvore "
                                + "é estritamente binaria");
			System.out.println("8 - Verficar se a arvore é uma ABB");
			System.out.println("9 - Printar copia em ordem"); //utiliza um metodo para copiar a arvore.
			System.out.println("10 - Sair");
			System.out.println("== DIGITE UMA OPCAO ==\n");
                        
			op = entrada.nextInt();
                        
                        
			if (op < 1 || op > 10){
				System.out.println("OPCAO INVALIDA");
			}
                        
			if (op == 1){
                                
                                System.out.println("-=-=-=-=-=-=-=-=-=-=-");
				System.out.println("Digite um numero\n");
				numero = entrada.nextInt();
				System.out.println("-=-=-=-=-=-=-=-=-=-=-");
				raiz.inserir(numero);
                                
			}
			
			if (op == 2){
                            System.out.println("==SAIDA==");
                            raiz.preOrdem();
                            System.out.println("=========");
			}

                        if (op == 3){
                            System.out.println("==SAIDA==");
                            raiz.emOrdem();
                            System.out.println("=========");

			}
                        
                        if (op == 4){
                            System.out.println("==SAIDA==");
                            raiz.posOrdem();
                            System.out.println("=========");
			}
                        
                        if (op == 5){
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-");
                            System.out.println("Entre com o valor\n");
                            int chave = entrada.nextInt();
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-");
                            raiz.deleteNode(chave);
			}
                        
                        if (op == 7){
                            System.out.println("==SAIDA==");
                            raiz.verBinaria();
                            System.out.println("=========");
			}
                        
                        if (op == 8){
                            System.out.println("==SAIDA==");
                            raiz.verAbb();
                            System.out.println("=========");
			}
                        
                        if (op == 9){
                            System.out.println("==SAIDA==");
                            raiz.copiaArvore();
                            System.out.println("=========");
			}
			
		}
                
		while( op != 10);
		
	}
}