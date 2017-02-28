package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.TrolleyPicking;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 22823 on 2016/12/6.
 */
@Service
public class DeleteProblemFromTrolleyService {
    @Autowired
    mapper mp;
    public int trolleyDelete(TrolleyPicking tp) {
        try {
            if(tp.equals(mp.trolleyProblemExist(tp))) {
                if(mp.trolleyDelete(tp) == 1) {
                    return 1;
                } else {
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
