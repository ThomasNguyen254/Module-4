package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> showAll();

    Song findById(int id);

    Song findByName(String name);

    boolean save(Song song);

    boolean delete(int id);

    boolean update(int id,Song song);

}
