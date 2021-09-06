package Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetPrincipaisMetodos {

	public static void main(String[] args) {

		//Não possui indice e não armazena elementos duplicados
		
		
		//Criando um Set e adicionando notas na sua criação
		//Set notas = new HashSet(); //Antes do java 5
		//HashSet<Double> notas = new HashSet<>(); //Não é legal pois não utiliza a de maneira Correta o POO
		//Set<Double> notas = new HashSet<>();//Boa maneira de se iniciar uma lista vazia
		
		Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		//Não mantem a ordem e não guarda valores repetidos
		System.out.println(notas.toString());
		
		//Como não possui indice não tem o metodo indexof e nem posição
		
		//Conferir se o conteudo existe
		System.out.println("Conferir se a nota 5.0 esta na Lista: " + notas.contains(5d));
		
		//Min igual ao List não tem a implementação nativa, utiliza se a collections
		System.out.println("Exiba a menor nota é : " + Collections.min(notas));
		
		//Max
		System.out.println("Exiba a maior nota é: " + Collections.max(notas));
		
		//Soma tem que fazer uma interação
		Iterator<Double> iterator = notas.iterator();
		Double soma = 0.0;
		while(iterator.hasNext()) {
			Double next =  iterator.next();
			soma+= next;
		}
		
		System.out.printf("A soma dos valores foi: %.2f\n", soma);
		
		//Media
		System.out.printf("A média dos valores é: %.2f\n", soma/notas.size());
		
		//Removendo um valor especifico
		System.out.println("Remova a nota 0.0");
		notas.remove(0d);		
		System.out.println(notas.toString());
		
		//Removendo as notas menores que 7
		System.out.println("Remova as notas menores que 7.0 e apresente a Lista");
		Iterator<Double> iterator2 = notas.iterator();
		
		while(iterator2.hasNext()) {
			Double next = iterator2.next();
			if(next < 7) iterator2.remove();
		}
		System.out.println(notas);
		
		//Para exibir as notas da maneira que foram inseridas será necessario utilizar o linkdList
		//Tambem não aceita valores repetidos
		System.out.println("Exiba todas as notas na ordem que foram inseridas");
		Set<Double> notas2 = new LinkedHashSet<>();
		notas2.add(7d);
		notas2.add(8.5);
		notas2.add(9.3);
		notas2.add(5d);
		notas2.add(7d);//Não vai adicionar por ser repetido
		notas2.add(0d);
		notas2.add(3.6);
		System.out.println(notas2);
		
		//PAra fazer isso utilizaremos o treeSet pois ele já exibe no seu default
		System.out.println("Exiba todas as notas em ordem crescente");
		Set<Double> notas3 = new TreeSet<>(notas2);
		System.out.println(notas3);
		
		//Apagando todo o conjunto
		System.out.println("Apague todo o conjunto");
		notas.clear();
		
		//Confira se o conjunto esta vazio
		System.out.println("O conjunto esta vazio? " + notas.isEmpty());
		
	}
}


