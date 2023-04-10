package com.warmmingup.buildup.backlog.service;

import com.warmmingup.buildup.backlog.dao.BacklogMapper;
import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("backlogService")
public class BacklogServiceImpl implements  BacklogService {


    private final BacklogMapper backlogMapper;

    @Autowired
    public BacklogServiceImpl(BacklogMapper backlogMapper) {this.backlogMapper = backlogMapper;}


    @Override
    public List<BacklogDTO> findAllBacklogs() {

        return backlogMapper.findAllBacklog();
    }
}

