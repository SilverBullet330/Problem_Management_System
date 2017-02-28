package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.ProblemInfo;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 22823 on 2016/11/9.
 */
/*@Service
public class ProblemInsertService {
    @Autowired
    private mapper mp;

    public Boolean problemInsert(ProblemInfo p) throws Exception {
        try{
            if(mp.problemIdSelect(p.getPid()) == p.getPid()) {
                return false;
            } else {
                mp.problemInsert(p.getPid(), p.getCid(), p.getChapter(), p.getDifficulty());
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    /*public List<Boolean> problemListInsert(List<String> lst) throws Exception {
        try {
            List l=new ArrayList();
            Iterator it=lst.iterator();
            while(it.hasNext()){
                l.add(ProblemInfo.convertFromString((String)it.next()));
            }

        }
    }*/

