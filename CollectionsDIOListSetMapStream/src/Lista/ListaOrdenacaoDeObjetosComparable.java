package Lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListaOrdenacaoDeObjetosComparable {

	public static void main(String[] args) {


		//Iniciando uma lista de gatos, adicionando 3 objetos no argumento inicial da lista.		
		List<Gato> meusGatos = new ArrayList<>() {{
			add(new Gato("Jon", 18, "Preto"));
			add(new Gato("Nick", 5, "Tigrado"));
			add(new Gato("Mel", 4, "Branca"));
			add(new Gato("Mel", 10, "Branca"));
		}};
		
		
		List<Gato> gatinhos = new ArrayList<>();
		
		Gato cat = new Gato();
		
		Scanner tec = new Scanner(System.in); 
		System.out.println("Digite o nome do gatinho: ");
		String nome = tec.next();
		cat.setNome(nome);
		System.out.println("Digite a cor do gatinho: ");
		String cor = tec.next();
		cat.setCor(cor);
		System.out.println("Digite a Idade do gatinho: ");
		int idade = tec.nextInt();
		cat.setIdade(idade);
		
		gatinhos.add(cat);
		
		System.out.println("Testando a Lista usando o Set: " + gatinhos);
			
		//Pela ordem de Inserção
		System.out.println("      Ordem de inserção");
		System.out.println(meusGatos);
			
		//Ordem Aleatoria (Não tem nativa, é preciso usar da Collections)
		Collections.shuffle(meusGatos);
		System.out.println("      Ordem Aleatoria " );
		System.out.println( meusGatos);
			
		//Ordem Natural tera que implementar a interface comparable e sobescrever o metodo comparable
	   //A lits usa o sort mas precisa de um "COMPARATOR" porem nos implementamso o comparable, então temos que usar a collections 	
		System.out.println("      Ordenção alfabetica pelos nomes " );
		Collections.sort(meusGatos);
		System.out.println(meusGatos);
		
		
		//Ordenar por idade, como o "COMPARABLE" já foi utilizado para ordenar pelo nome
		//Se quisermos ordenar por outro atributo teriamos que altarar o metodo e isso não seria o ideal
		//Vamos criar uma nova classe e implementar o "COMPARATOR"
		System.out.println("      Ordenação Por idade " );
		
		//ooção 1 usando o sort da collections
			//Collections.sort(meusGatos, new comparatorIdade());
		//opção 2 instanciando a classe e usando o sort da List
			meusGatos.sort(new comparatorIdade());
		
		System.out.println(meusGatos);
		
		//Mesma maneira que a idade mas criando uma nova classe
	    System.out.println("      Ordenação Por Cor " );
		
		//opção 1 usando o sort da collections
			Collections.sort(meusGatos, new comparatorCor());
		//opção 2 instanciando a classe e usando o sort da List
			//meusGatos.sort(new comparatorCor());
		
		System.out.println(meusGatos);
		
		
		//Ordenando pelos 3 atibutos nome/cor/idade
		System.out.println("      Ordenação Por Nome/Cor/Idade " );
		//opção 1 usando o sort da collections
				Collections.sort(meusGatos, new comparatorNomeCorIdade());
		//opção 2 instanciando a classe e usando o sort da List
				//meusGatos.sort(new comparatorNomeCorIdade());		
		System.out.println(meusGatos);
		
		}
	}


	class Gato implements Comparable<Gato> {
		private String nome;
		private int idade;
		private String cor;
		
		public Gato(String nome, int idade, String cor) {
			super();
			this.nome = nome;
			this.idade = idade;
			this.cor = cor;
		}
		
		
		
		public Gato() {	}



		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCor() {
			return cor;
		}
		public void setCor(String cor) {
			this.cor = cor;
		}
		public int getIdade() {
			return idade;
		}
		public void setIdade(int idade) {
			this.idade = idade;
		}

		@Override
		public String toString() {
			return "[nome: " + nome + ", idade: " + idade + ", cor:" + cor +"]";
		}

		//Ordenar pelos nomes, só pode trer um compareTo na classe
		@Override
		public int compareTo(Gato gato) {
			//usa o 'this' pq esta dentro da classe gato
			return this.getNome().compareToIgnoreCase(gato.getNome());
		}	

	}

	//É necessario criar uma classe para cada tipo de comparação
	class comparatorIdade implements Comparator<Gato>{
		@Override
		public int compare(Gato g1, Gato g2) {
			return Integer.compare(g1.getIdade(), g2.getIdade());
		}	
	}


	class comparatorCor implements Comparator<Gato>{
		@Override
		public int compare(Gato g1, Gato g2) {
			return g1.getCor().compareToIgnoreCase(g2.getCor());
		}	
	}


	class comparatorNomeCorIdade implements Comparator<Gato>{
		@Override
		public int compare(Gato g1, Gato g2) {
			int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
			if(nome != 0) return nome;
			
			int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
			if(cor != 0) return cor;
			
			return Integer.compare(g1.getIdade(), g2.getIdade());
		
		
		
	}

}
