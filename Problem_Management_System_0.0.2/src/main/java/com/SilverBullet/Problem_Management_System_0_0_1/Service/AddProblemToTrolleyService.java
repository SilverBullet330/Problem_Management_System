package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.TrolleyPicking;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 22823 on 2016/12/6.
 */
@Service
public class AddProblemToTrolleyService {
    @Autowired
    mapper mp;
    public int trolleyAdd(TrolleyPicking tp) {
        try {
            if (mp.trolleyProblemExist(tp) != null)
                return -1;
            if(mp.problemIdSelect(tp.getPid()) != null) {
                if(mp.trolleyInsert(tp) == 1) {
                    return 1;
                }
                else {
                    return 0;
                }
            } else {
                return -1;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
