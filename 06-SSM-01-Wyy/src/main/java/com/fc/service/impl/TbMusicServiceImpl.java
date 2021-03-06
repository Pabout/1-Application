package com.fc.service.impl;

import com.fc.service.TbMusicService;
import com.fc.dao.TbMusicMapper;
import com.fc.entity.TbMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbMusicServiceImpl implements TbMusicService {
    @Autowired
    private TbMusicMapper tbMusicMapper;

    @Override
    public List<TbMusic> findAll() {
        //无条件查询全部
        return tbMusicMapper.selectByExample(null);
    }
}
