package com.warmmingup.buildup.backlog.service;

import com.warmmingup.buildup.backlog.dao.BacklogMapper;
import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("backlogService")
public class BacklogServiceImpl implements  BacklogService {




    private final BacklogMapper backlogMapper;


    @Autowired
    public BacklogServiceImpl(BacklogMapper backlogMapper) {this.backlogMapper = backlogMapper;}

    @Override
    public void updateBacklogs(BacklogDTO updateBacklog) {
        backlogMapper.updateBacklogs(updateBacklog);
    }

    @Override
    public int registBacklog(BacklogDTO newBacklog) {
        int result= backlogMapper.addBacklogs(newBacklog);
        int backlogNo = 0;
        if (result > 0) {
            backlogNo = backlogMapper.findBacklogsByNo(newBacklog);
        }
        return backlogNo;
    }

    @Override
    public List<BacklogDTO> findAllBacklogs() {

        return backlogMapper.findAllBacklogs();
    }

    @Override
    public void deleteBacklog(int removeBacklog) {

        backlogMapper.deleteBacklog(removeBacklog);
    }

    @Override
    public List<BacklogDTO> searchBacklogs(Map<String, Object> searchbacklog) {
        return  backlogMapper.searchbacklog(searchbacklog);
    }


}

