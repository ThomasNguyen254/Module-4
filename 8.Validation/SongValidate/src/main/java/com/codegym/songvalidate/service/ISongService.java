package com.codegym.songvalidate.service;

import com.codegym.songvalidate.dto.SongDto;
import com.codegym.songvalidate.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    boolean save(Song song);

   Song findById(int id);
}
