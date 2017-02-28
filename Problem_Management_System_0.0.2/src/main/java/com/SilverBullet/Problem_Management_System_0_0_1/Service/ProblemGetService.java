package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.ProblemCondition;
import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.ProblemInfo;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 22823 on 2016/11/28.
 */

@Service
public class ProblemGetService {
    @Autowired
    private mapper mp;
    public List<ProblemInfo> getProblemListByCondition(ProblemCondition pc) {
        try {
            pc.handleString();
            pc.setSubject(mp.cnameGetByCid(pc.getC().getCid()));
            if(pc.getPageP().getCurrentPage() == -1 && pc.getPageP().getAllPages() == -1) {
                int sum = mp.problemListSumGet(pc);
                if(sum%9 > 0 || sum == 0)
                    pc.getPageP().setAllPages(sum/9+1);
                else
                    pc.getPageP().setAllPages(sum/9);
                pc.getPageP().setCurrentPage(1);
                return mp.problemListSelectByProblemCondition(pc, new RowBounds((pc.getPageP().getCurrentPage() - 1)*9, 9));
            } else {

                return mp.problemListSelectByProblemCondition(pc, new RowBounds((pc.getPageP().getCurrentPage() - 1)*9, 9));
            }

        } catch (Exception ex) {
            throw ex;
        }
    }
}
