package example.controller;


import example.domain.Sounds;
import example.service.SoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("sound")
public class SoundController {

    @Autowired
    private SoundService soundService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Sounds> getAllSounds() {return soundService.getAllSounds();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Collection<Sounds> addSounds(@RequestBody Sounds sound){
        soundService.add(sound);
        return getAllSounds();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Collection<Sounds> removeSounds(@RequestParam Integer soundId) {
        soundService.remove(soundId);
        return getAllSounds();
    }


}
