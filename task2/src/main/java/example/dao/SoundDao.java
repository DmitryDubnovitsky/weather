package example.dao;

import example.domain.Sounds;

import java.util.Collection;


public interface SoundDao {

    void add(Sounds sound);

    void remove(Integer soundId);

    Collection<Sounds> getAllSounds();
}
