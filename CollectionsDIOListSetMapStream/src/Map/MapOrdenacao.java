package Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapOrdenacao {

	public static void main(String[] args) {

		//Ordenar por ordem aleatorio que é o HashMap
		System.out.println("--\tApresente em ordem aleatoria\t--");
		Map<String, Livro> meusLivros = new HashMap<>() {{
			put("Hawking, Stephen", new Livro ("Uma breve historia do tempo", 455));
			put("Duhing, Charles", new Livro ("O Poder do Habito", 408));
			put("Harari, Yuval noah", new Livro ("21 liçoes do seculo 21", 432));			
		}};
				
		for (Map.Entry<String, Livro> livro : meusLivros.entrySet()){
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		}
		
		//Ordenar por ordem de inserção que é o LinkedHashMap
				System.out.println("\n--\tApresente em ordem de inserção\t--");
				Map<String, Livro> meusLivros2 = new LinkedHashMap<>() {{
					put("Hawking, Stephen", new Livro ("Uma breve historia do tempo", 455));
					put("Duhing, Charles", new Livro ("O Poder do Habito", 408));
					put("Harari, Yuval noah", new Livro ("21 liçoes do seculo 21", 432));			
				}};
						
				for (Map.Entry<String, Livro> livro : meusLivros2.entrySet()){
					System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
				}
		
		//Ordem alfabetica dos autores
				System.out.println("\n--\tApresente em ordem Alfabetica de Autores\t--");
				Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2); 		
				
				for (Map.Entry<String, Livro> livro : meusLivros3.entrySet()){
					System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
				}
				
				
		//Ordenar por ordem alfabetica dos Livros, vai ser usado o TreeSet mas criando um comparator,
		//fazendo uma nova classe
				System.out.println("\n--\tApresente em ordem Alfabetica dos Livros\t--");
				Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());	
				meusLivros4.addAll(meusLivros.entrySet());
				for (Map.Entry<String, Livro> livro : meusLivros4){
					System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
				}
		
	//fim	
	}
}


class Livro {
	
	private String nome;
	private Integer paginas;
	public Livro(String nome, Integer paginas) {
		super();
		this.nome = nome;
		this.paginas = paginas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPaginas() {
		return paginas;
	}
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (paginas == null) {
			if (other.paginas != null)
				return false;
		} else if (!paginas.equals(other.paginas))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Livros [nome=" + nome + ", paginas=" + paginas + "]";
	}	
	
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{
	@Override
	public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
		return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
		
	}

}
