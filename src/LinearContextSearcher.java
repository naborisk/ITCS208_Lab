public class LinearContextSearcher extends ContextSearcher {
    LinearContextSearcher(String filename) {
        super(filename);
    }

    @Override
    public String find(Word query, int window) {
        for(Word w: super.sortedWords){
            if (w.equals(query)) return getSnippet(w, window);
        }

        return null;
    }
}
