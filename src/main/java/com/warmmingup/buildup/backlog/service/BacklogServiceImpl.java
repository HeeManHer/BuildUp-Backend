package com.warmmingup.buildup.backlog.service;

import com.warmmingup.buildup.backlog.dao.BacklogMapper;
import com.warmmingup.buildup.backlog.dto.BacklogAuthorityDTO;
import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("backlogService")
public class BacklogServiceImpl implements  BacklogService {




    private final BacklogMapper backlogMapper;


    @Autowired
    public BacklogServiceImpl(BacklogMapper backlogMapper) {this.backlogMapper = backlogMapper;}

    @Override
    public void updateBacklogs(int projectNo,BacklogDTO updateBacklog) {
        backlogMapper.updateBacklogs(updateBacklog);
    }

    @Override
    public int registBacklog(int projectNo ,BacklogDTO newBacklog) {
        int result= backlogMapper.addBacklogs(newBacklog);
        int backlogNo = 0;
        if (result > 0) {
            backlogNo = backlogMapper.findBacklogsByNo(newBacklog);
        }
        return backlogNo;
    }




    @Override
    public void deleteBacklog(int removeBacklog) {

        backlogMapper.deleteBacklog(removeBacklog);
    }

    @Override
    public int selectBacklogTotal(Map<String, Object> backlogConnect) {
        return backlogMapper.selectBacklogTotal(backlogConnect);
    }

    @Override
    public List<BacklogDTO> selectBacklogListWithPaging(Map<String, Object> backlogConnect) {
        return backlogMapper.selectBacklogListWithPaging(backlogConnect);
    }

    @Override
    public List<BacklogAuthorityDTO> authority(Map<String, Object> authority) {
        return backlogMapper.authority(authority);
    }




}



