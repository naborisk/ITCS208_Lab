import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private String name;
    private ArrayList<Song> list;
    private int totalDuration;


    public Playlist (String name){
        this.name = name;
        list = new ArrayList<Song>();

    }

    public void addSong(Song song){
        list.add(song);
    }

    public void addSongAtIndex(Song song, int index){
        try {
            list.add(index, song);
        }catch (Exception e){
            System.out.println("Error: Couldn't add song index " + index);
        }
    }

    public void removeSongByIndex(int index){
        try{
            list.remove(index);
        }catch (Exception e){
            System.out.println("Error: The index is invalid");
        }
    }

    public void removeSongByTitle(String title){

        boolean isRemoved = false;

        try{
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getTitle().equals(title)){
                    list.remove(list.get(i));
                    isRemoved = true;
                }
            }

            //Throws ConcurrentModificationException
//            for(Song song : list){
//                if(song.getTitle().equals(title)){
//                    list.remove(song);
//                    isRemoved = true;
//                }
//            }
        }catch (Exception e){
            System.out.println("Error: The title is not found");
        }finally {
            if (!isRemoved) System.out.println("Error: The title is not found");
        }

    }

    public void moveUp(int position){
        Collections.swap(list, position, position-1);
    }

    public void moveDown(int position){
        Collections.swap(list, position, position+1);
    }

    public void showPlaylist(){
        totalDuration = 0;
        for(int i = 0; i < list.size(); i++){
            totalDuration += list.get(i).getDurationSec();
        }

        double totalDurationMinutes = (totalDuration/60);
        totalDurationMinutes += (totalDuration%60)/100.00;


        System.out.println(name);

        for(int i = 0; i < list.size(); i++){
            System.out.println("[" + i + "] " + list.get(i) );
        }

        System.out.println("Total duration is " + totalDurationMinutes + " minutes" );
    }

}
