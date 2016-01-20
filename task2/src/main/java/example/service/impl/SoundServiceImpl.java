package example.service.impl;

import example.dao.SoundDao;
import example.domain.Sounds;
import example.service.SoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by ִלטענטי on 1/16/2016.
 */
@Transactional
@Service
public class SoundServiceImpl implements SoundService {

    @Autowired
    private SoundDao soundDao;

    @Override
    public void add(Sounds sound) {
        soundDao.add(sound);
    }

    @Override
    public Collection<Sounds> getAllSounds() {
        return soundDao.getAllSounds();
    }

    @Override
    public void remove(Integer soundId) {soundDao.remove(soundId);}


}
