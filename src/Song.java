public class Song {
    String title;
    double duration;


    public Song(String title, double duration){
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public int getDurationSec() {
        int minute = (int) duration;
        double seconds = Math.round((duration - minute)*100) ;
        return (int) seconds + (minute * 60);
    }

    @Override
    public String toString() {
        return title + ", " + duration + " minutes (" + getDurationSec() + " seconds)";
    }
}
