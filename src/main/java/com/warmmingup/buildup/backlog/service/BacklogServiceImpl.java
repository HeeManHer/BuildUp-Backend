package com.warmmingup.buildup.backlog.service;

import com.warmmingup.buildup.backlog.dao.BacklogMapper;
import com.warmmingup.buildup.backlog.dto.BacklogAuthorityDTO;
import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("backlogService")
public class BacklogServiceImpl implements BacklogService {

    private final BacklogMapper backlogMapper;

    @Autowired
    public BacklogServiceImpl(BacklogMapper backlogMapper) {
        this.backlogMapper = backlogMapper;
    }

    @Override
    public int selectBacklogTotalCount(Map<String, Object> backlogConnect) {
        return backlogMapper.selectBacklogTotalCount(backlogConnect);
    }

    @Override
    public List<BacklogDTO> selectAllBacklogs(Map<String, Object> backlogConnect) {
        return backlogMapper.selectAllBacklogs(backlogConnect);
    }

    @Override
    @Transactional
    public int insertBacklog(int projectNo, BacklogDTO newBacklog) {
        backlogMapper.insertBacklog(newBacklog);

        int backlogNo = backlogMapper.selectBacklogsNo(newBacklog);

        return backlogNo;
    }

    @Override
    @Transactional
    public void updateBacklogs(int projectNo, BacklogDTO updateBacklog) {

        backlogMapper.updateBacklogs(updateBacklog);
    }


    @Override
    @Transactional
    public void deleteBacklog(int removeBacklog) {

        backlogMapper.deleteBacklog(removeBacklog);
    }

    @Override
    public List<BacklogAuthorityDTO> authority(Map<String, Object> authority) {
        return backlogMapper.authority(authority);
    }


}



