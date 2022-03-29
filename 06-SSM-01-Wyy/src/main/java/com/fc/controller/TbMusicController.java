package com.fc.controller;

import com.fc.service.TbMusicService;
import com.fc.entity.TbMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("music")
public class TbMusicController {
    @Autowired
    private TbMusicService tbMusicService;
    @RequestMapping("findAll")
    public List<TbMusic> finAll(){
        return tbMusicService.findAll();
    }
}
