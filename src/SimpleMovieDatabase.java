import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class SimpleMovieDatabase {
	public Map<Integer, Movie> movies = null;
	
	public void importMovies(String movieFilename)
	{	//YOUR CODE GOES HERE
		movies = new HashMap<>();

		String line;
		try{
			BufferedReader br = new BufferedReader(new FileReader("lab11_movies.txt"));
			Pattern p = Pattern.compile("([0-9]+),(.*),(.*)");
			Matcher m;

			while((line = br.readLine()) != null){
				m = p.matcher(line);

				if(m.matches() && !m.group(2).equals(" ")) {
					int mid = Integer.parseInt(m.group(1));
					movies.put(mid, new Movie(mid, m.group(2)));
					String[] tags = m.group(3).split("\\|");

					for (String tag: tags){
						movies.get(mid).addTag(tag);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//-------------------BONUS----------------------
	public List<Movie> searchMovies(String query)
	{
		//YOUR BONUS CODE GOES HERE
		ArrayList<Movie> searchedMovies = new ArrayList<>();
		for(Integer key: movies.keySet()){
			if(movies.get(key).title.toLowerCase().contains(query.toLowerCase())) searchedMovies.add(movies.get(key));
		}

		return searchedMovies;
	}
	
	public List<Movie> getMoviesByTag(String tag)
	{
		//YOUR BONUS CODE GOES HERE
		ArrayList<Movie> searchedMovies = new ArrayList<>();
		for(Integer key: movies.keySet()){
			if(movies.get(key).tags.contains(tag)) searchedMovies.add(movies.get(key));
		}

		return searchedMovies;
	}
	
	
	public static void main(String[] args)
	{
		SimpleMovieDatabase mdb = new SimpleMovieDatabase();
		mdb.importMovies("lab11_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305};
		for(int mid: mids)
		{
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}
		
		//Uncomment for bonus
		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		String[] queries = new String[]{"america", "thai", "thailand"};
		for(String query: queries)
		{
			System.out.println("Results for movies that match: "+query);
			for(Movie m: mdb.searchMovies(query))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		String[] tags = new String[]{"Musical", "Action", "Thriller"};
		for(String tag: tags)
		{
			System.out.println("Results for movies in category: "+tag);
			for(Movie m: mdb.getMoviesByTag(tag))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
	}
}
