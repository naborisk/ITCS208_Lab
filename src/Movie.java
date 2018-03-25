import java.util.HashSet;
import java.util.Set;

public class Movie {
	public int mid;
	public String title;
	public Set<String> tags;

	public Movie(int _mid, String _title)
	{
		mid = _mid;
		title = _title;
		tags = new HashSet<String>();
	}
	
	public void addTag(String tag){
		if(tag != null) tags.add(tag);
	}

	public String toString()
	{
		return "[mid: "+mid+":"+title+" "+tags+"]";
	}
	
}
