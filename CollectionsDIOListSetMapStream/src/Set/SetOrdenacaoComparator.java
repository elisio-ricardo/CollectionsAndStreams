package Set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetOrdenacaoComparator {

	public static void main(String[] args) {

		//Iniciando o Set
		System.out.println("Ordem Aleatoria");
		Set<Serie> minhasSeries = new HashSet<>() {{
			add(new Serie("GOT", "Fantasia", 60));
			add(new Serie("Dark", "Drama", 60));
			add(new Serie("That '70s Show", "Comedia", 25));			
		}};
		//System.out.println(minhasSeries.toString());
		for (Serie serie : minhasSeries) {
		System.out.println(serie.getNome()+" - "+ serie.getGenero()+" - "+ serie.getTempoEpisodio());	
		}
		
		//Apresentar por ordem de inserção tem que usar o linkedHashSet
		System.out.println("\nOrdem de inserção");
		Set<Serie> minhasSeries2 = new LinkedHashSet<>() {{
			add(new Serie("GOT", "Fantasia", 60));
			add(new Serie("Dark", "Drama", 60));
			add(new Serie("That '70s Show", "Comedia", 25));			
		}};
		//System.out.println(minhasSeries.toString());
		for (Serie serie : minhasSeries2) {
		System.out.println(serie.getNome()+" - "+ serie.getGenero()+" - "+ serie.getTempoEpisodio());	
		}
	
		//Apresentando pela ordem natural, como será comparado Objetos e queremos pelo tempo
		//será necessario implementar o comparable, se não vai dar erro
		
		System.out.println("\nOrdem Natural(Pelo tempo de episodio");
		Set<Serie>  minhasSeries3 = new TreeSet<>(minhasSeries2);
		//System.out.println(minhasSeries3);
		for (Serie serie : minhasSeries3) {
			//como o tempo é igual só vai aparecer um, tem que ter um criterio de desempate
			System.out.println(serie.getNome()+" - "+ serie.getGenero()+" - "+ serie.getTempoEpisodio());	
			}
		
		//Dessa maneira será necessario iniciar a lista instanciando o comparator
		System.out.println("\nOrdem Nome/Genero/TempoEpisodio");
		Set<Serie>  minhasSeries4 = new TreeSet<>(new ComparatoNomeGeneroTempoEpisodio());
		//System.out.println(minhasSeries3);
		minhasSeries4.addAll(minhasSeries); //Dessa maneira inseri uma lista inteira
		for (Serie serie : minhasSeries4) {
			//como o tempo é igual só vai aparecer um, tem que ter um criterio de desempate
			System.out.println(serie.getNome()+" - "+ serie.getGenero()+" - "+ serie.getTempoEpisodio());	
			}
		
		
		
	}
}

//Sempre que for usar alguma collections que usa a palavra Hash é necessario
//Implementar os metos equals e hash
//Implementar o comparable para usar a ordem natural com o TreeSet
class Serie implements Comparable<Serie>{
	private String nome;
	private String genero;
	private int tempoEpisodio;
	
	public Serie(String nome, String genero, int tempoEpisodio) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.tempoEpisodio = tempoEpisodio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getTempoEpisodio() {
		return tempoEpisodio;
	}

	public void setTempoEpisodio(int tempoEpisodio) {
		this.tempoEpisodio = tempoEpisodio;
	}

	@Override
	public String toString() {
		return "[nome: " + nome + ", genero: " + genero + ", tempoEpisodio: " + tempoEpisodio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + tempoEpisodio;
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
		Serie other = (Serie) obj;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tempoEpisodio != other.tempoEpisodio)
			return false;
		return true;
	}

	//como o tempo é igual só vai aparecer um, tem que ter um criterio de desempate
	@Override
	public int compareTo(Serie serie) {
		int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
		if(tempoEpisodio != 0) return tempoEpisodio;
		
		return this.genero.compareTo(serie.getGenero());		
	}
	
}

class ComparatoNomeGeneroTempoEpisodio implements Comparator<Serie>{

	@Override
	public int compare(Serie s1, Serie s2) {
		int nome = s1.getNome().compareTo(s2.getNome());
		if(nome != 0) return nome;
		
		int genero = s1.getGenero().compareTo(s2.getGenero());
		if(genero != 0) return genero;		
		
		return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());	
		
		
		
		
	}

}
