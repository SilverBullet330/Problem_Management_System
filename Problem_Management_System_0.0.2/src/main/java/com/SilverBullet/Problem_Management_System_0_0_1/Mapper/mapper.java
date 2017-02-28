package com.SilverBullet.Problem_Management_System_0_0_1.Mapper;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by 22823 on 2016/10/14.
 */
public interface mapper {
    UserLogin sqlById(String id);
    String userExist(String id);
    int userRegister(UserRegister ur);



    void userUpdate(UserUpdate up);
    int userOnlineNum();
    void userOnline(String id);
    void userLogout(String id);
    User userInfo(String id);
    int userListSumGet();
    List<UserInfo> userListSelect(RowBounds rowBounds);
    void userDelete(String id);

    int deletedUserListSumGet();
    List<UserDeleted> deletedUserListSelect();

    void deletedUserInsert(UserDelete ud);
    UserDelete userDeletedSelect(String id);
    void userDeletedDelete(UserRecover ur);
    void userRecover(UserDelete ud);

    int problemListSumGet(ProblemCondition pc);
    List<ProblemInfo> problemListSelectByProblemCondition(ProblemCondition pc, RowBounds rowBounds);
    List<ProblemInfo> problemListSelectByPidList(List<String> sl);
    void problemInsert(int pid, String cid, String chapter, String difficulty);
    void problemListInsert(List<ProblemInfo> problemInfoList);
    void problemDelete(int pid);
    void problemListDelete(List<String> problemList);
    void problemUpdate(int pid, String cid, String chapter, String difficulty);
    String problemIdSelect(String pid);

    int trolleyInsert(TrolleyPicking tp);
    TrolleyPicking trolleyProblemExist(TrolleyPicking tp);
    int trolleyDelete(TrolleyPicking tp);
    int trolleyProblemListSumGet(PersonalTrolley pt);
    List<String> trolleyProblemListSelect(PersonalTrolley pt, RowBounds rowBounds);

    String cnameGetByCid(String cid);

}
