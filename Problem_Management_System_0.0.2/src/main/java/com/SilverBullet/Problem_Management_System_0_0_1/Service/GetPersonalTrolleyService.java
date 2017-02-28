package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.CurrentPageProblemListInTrolley;
import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.PersonalTrolley;
import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.ProblemInfo;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 22823 on 2016/12/6.
 */
@Service
public class GetPersonalTrolleyService {
    @Autowired
    mapper mp;
    public CurrentPageProblemListInTrolley getProblemListInTrolley(PersonalTrolley pt) {
        try {
            CurrentPageProblemListInTrolley currentPageProblemListInTrolley = new CurrentPageProblemListInTrolley();
            if (pt.getCurrentPage() == -1 && pt.getAllPages() == -1) {
                int sum = mp.trolleyProblemListSumGet(pt);
                if (sum % 9 > 0 || sum == 0)
                    currentPageProblemListInTrolley.setAllPages(sum / 9 + 1);
                else
                    currentPageProblemListInTrolley.setAllPages(sum / 9);
                currentPageProblemListInTrolley.setCurrentPage(1);
            } else {
                currentPageProblemListInTrolley.setCurrentPage(pt.getCurrentPage());
                currentPageProblemListInTrolley.setAllPages(pt.getAllPages());
            }
                List<String> sl = mp.trolleyProblemListSelect(pt, new RowBounds((currentPageProblemListInTrolley.getCurrentPage() - 1) * 9, 9));
                if (sl == null || sl.size() == 0)
                    currentPageProblemListInTrolley.setProblemInfoList(null);
                else {
                    currentPageProblemListInTrolley.setProblemInfoList(mp.problemListSelectByPidList(sl));
                }
                return currentPageProblemListInTrolley;
            } catch (Exception ex) {
            throw ex;
        }
    }
}
