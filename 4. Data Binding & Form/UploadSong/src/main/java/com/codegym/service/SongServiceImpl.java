package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SongServiceImpl implements ISongService{

@Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);

    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void update(int id, Song song) {
        songRepository.update(id,song);
    }

    @Override
    public void delete(int id) {
        songRepository.delete(id);
    }

}
