package com.codegym.repository;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class SongRepositoryImpl implements ISongRepository{

    private static List<Song> songList = new ArrayList<>();
    static {
        songList.add(new Song(1,"My Love","Westlife",new String[]{"Bard","Pop"},"https://www.youtube.com/watch?v=ulOb9gIGGd0"));
        songList.add(new Song(2,"I Lay My Love on You","Westlife",new String[]{"Bard","Pop"},"https://www.youtube.com/watch?v=ZnOAK04tJhc"));
        songList.add(new Song(3,"The day you went away","M2M",new String[]{"Bard","Pop"},"https://www.youtube.com/watch?v=pPIC7gJIW8I"));
    }

    @Override
    public List<Song> findAll() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);

    }

    @Override
    public Song findById(int id) {
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getId() == id) {
                return songList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(int id, Song song) {
        for(Song s : songList) {
            if (s.getId() == id) {
                s = song;
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(id).getId() == id) {
                songList.remove(i);
                break;
            }

        }

    }
}
