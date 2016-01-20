package example.service;


import example.domain.Sounds;

import java.util.Collection;

/**
 * Created by ִלטענטי on 1/16/2016.
 */
public interface SoundService {

    void add(Sounds sound);

    void remove(Integer soundId);

    Collection<Sounds> getAllSounds();
}
