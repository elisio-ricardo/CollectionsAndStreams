package Lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListaPrincipaisMetodos {

	public static void main(String[] args) {


		
		//op��o de inciar um array com elementos
		//List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6 ));
		
		//Tbm pode ser assim mas a lista fica imutavel, n�o adiciona e nem remove
		//List<Double> notas2 = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6 );
		
		
		//Iniciando um array vazio
		List<Double> notas = new ArrayList<>();
		notas.add(7d);
		notas.add(8.5);
		notas.add(9.3);
		notas.add(5d);
		notas.add(7d);
		notas.add(0d);
		notas.add(3.6);
		
		System.out.println(notas.toString());

		
		//Adicione um elemento na posi��o 4
		notas.add(4, 8.0);
		
		//Exiba a posi��o da nota 5
	    System.out.println("Posi�o da nota 5 �: " + notas.indexOf(5d));
			
		//Substitua a nota 5.0 pela nota 6.0(5d = elemento a ser substituido)
		notas.set(notas.indexOf(0d), 6.4);
		
		//Confira se a nota 5.0 esta na lista (Retorna um boolean)
		System.out.println(notas.contains(5d));	
		
		System.out.println(notas.toString());
		
		//Imprima os valores pela ordem de inser��o
		for (Double nota : notas) System.out.print(nota + " - ");
		
		//Exiba a 3� nota adicionada (0, 1, 2)
		System.out.println(notas.get(2));
		
		//Exiba a menor nota (n�o existe metodo nativo, tem que chamar a classe m�e collections)
		System.out.println("Menor nota: " + Collections.min(notas));
		
		//Exiba a maior nota
		System.out.println("Maior nota: " + Collections.max(notas));
		
		//Exiba a soma dos valores(N�o tem o metodo sum, � necessario fazer uma intera��o)
		Iterator<Double> iterator = notas.iterator();
		Double soma = 0d;
		while(iterator.hasNext()) {
			Double next = iterator.next();
			soma += next;
		}
		
		System.out.println("A soma das notas �: "+ soma);
		
		//Exiba a media das somas
		System.out.println("A media dos valores �: " + (soma/notas.size()));
		
		//Remover um valor(passa o valor que deseja remover, se n�o colocar o 'd' ele remove na posi�ao 5)
		System.out.println("Removendo o valor 5.0: " + notas.remove(5d));
		
		
		//Remove os valores menores que 7
		Iterator<Double> iterator1 = notas.iterator();
		while(iterator1.hasNext()) {
			Double next1 = iterator1.next();
			if(next1 < 7) iterator1.remove();
		}
		System.out.println("Valores menores que 7 removidos: "+notas);
		
		//Apagando a lista toda	
		System.out.println("Apagando a Lista " );
		notas.clear();
		
		
		
		
		
	}

}
