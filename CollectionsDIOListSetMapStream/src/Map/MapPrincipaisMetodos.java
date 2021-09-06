package Map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapPrincipaisMetodos {

	public static void main(String[] args) {


		// Iniciando um Map
		System.out.println("Crie um dicionario que relacione os modelos e seu consumo");
		Map<String, Double> carrosPopulares = new HashMap<>() {
			{
				// Não existe o metodo add em Map e sim o put
				put("Gol", 14.4);
				put("Uno", 15.6);
				put("Mobi", 16.1);
				put("Hb20", 14.5);
				put("Kwid", 15.6);
			}
		};
		System.out.println(carrosPopulares.toString());

		// Adicione outra item Gol
		// Como não é possivel ter duas chaves iguais, vai sobescrever pelo ultimo
		System.out.println("\nSubstitua o consumo do Gol por 15.2 Km/l: ");
		carrosPopulares.put("Gol", 16.1);
		System.out.println(carrosPopulares.toString());

		// Pegando a chave
		System.out.println("\nConfira se o modelo Tucson esta no dicionario: " + carrosPopulares.containsKey("Tucson"));

		// Pegando o valor
		System.out.println("\nExiba o consumo do Uno: " + carrosPopulares.get("Uno"));

		// Exiba o terceiro metodo, não tem um metodo para isso
		System.out.println("\nExiba o terceiro item: não existe metodo para isso");

		// Exiba apenas os modelos do dicioario, o metodo KeySet retorna um set
		System.out.println("\nExiba os modelos dos carros");
		Set<String> modelos = carrosPopulares.keySet();
		System.out.println(modelos.toString());

		// Exibir os consumos, este metodo retorna uma collections
		System.out.println("\nExiba o consumo dos carros");
		Collection<Double> consumo = carrosPopulares.values();
		System.out.println(consumo.toString());

		// Exibindo o modelo com o menor do consumo (maior km/l), para isso pegaremos o
		// metodo acima para
		// pegar o valor
		// Depois outro metodo para unir a chave e o valor
		System.out.println("\nExiba o modelo mais economico e seu consumo");
		Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
		Set<Entry<String, Double>> entrySet = carrosPopulares.entrySet();

		String modeloMaisEficiente = "";
		for (Entry<String, Double> entry : entrySet) {
			if (entry.getValue().equals(consumoMaisEficiente)) {
				modeloMaisEficiente = entry.getKey();
				// Deixando dentro aparce todos que tiverem o mennor consumo
				System.out.println(modeloMaisEficiente + " - " + consumoMaisEficiente);
			}
		}

		// Exiba o modelo menos economico(meno valor por km/l)
		System.out.println("\nExiba o modelo menos economico e seu consumo");
		Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
		String modeloMenosEficiente = "";
		for (Entry<String, Double> entry : entrySet) {
			if (entry.getValue().equals(consumoMenosEficiente)) {
				modeloMenosEficiente = entry.getKey();
				// Deixando dentro aparce todos que tiverem o mennor consumo
				System.out.println(modeloMenosEficiente + " - " + consumoMenosEficiente);
			}
		}

		
		//Exibir a soma dos consumos
		System.out.println("\nExiba a soma dos consumos");
		Iterator<Double> iterator = carrosPopulares.values().iterator();
		Double soma = 0d;
		while(iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println(soma);
		
		//Media do consumo dos veiculos
		System.out.println("\nExiba a media dos consumos dos veiculos");
		System.out.printf("%.2f\n",soma/carrosPopulares.size());
		
		
		//Removendo um valor igual a 15.6
		System.out.println("\nRemova o veiculo que tenha o consumo igual a 15.6");
		Iterator<Double> iterator1 = carrosPopulares.values().iterator();
		while(iterator1.hasNext()) {
			if(iterator1.next().equals(15.6)) iterator1.remove();		
		}
		System.out.println(carrosPopulares.toString());
		
		//Imprimar a lista na ordem de inserção, usaremos o linkedHashMap para isso.
		System.out.println("\nImprima o conteudo na forma que foram inseridos");
		Map<String, Double> carrosPopulares2 = new LinkedHashMap<>() {
			{
				// Não existe o metodo add em Map e sim o put
				put("Gol", 14.4);
				put("Uno", 15.6);
				put("Mobi", 16.1);
				put("Hb20", 14.5);
				put("Kwid", 15.6);
			}
		};
		System.out.println(carrosPopulares.toString());

		//Exiba o dicionario ordenado pelo modelo, para isso utilizaremos o TreeMap que já faz isso automaticamente
		//Ordem alfabetica
		System.out.println("\nExiba o dicionario ordenado pelo modelo");
		Map<String, Double> carrosPopulares3 = new TreeMap<>(carrosPopulares2);
		System.out.println(carrosPopulares3);
		
		//Apague o dicionario
		System.out.println("\nApague todo o dicionario ");
		carrosPopulares.clear();
		
		
		//Confira se o dicionario esta vazio
		System.out.println("\nConfira se o dicionario esta vazio: " + carrosPopulares.isEmpty());
		
		
		
//fim main
		
		
		
	}

}
