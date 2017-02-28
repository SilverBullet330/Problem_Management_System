package com.SilverBullet.Problem_Management_System_0_0_1.Controller;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.*;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import com.SilverBullet.Problem_Management_System_0_0_1.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 22823 on 2016/10/14.
 */
@RestController

public class UserController {
    @Autowired
    private UserRegisterService urs;
    @Autowired
    private UserInfoUpdateService uius;
    @Autowired
    private UserService us;
    @Autowired
    private AllUserInfoService auis;
    @Autowired
    private UserDeleteService uds;
    @Autowired
    private UserRecoverService urs_;
    @Autowired
    private AllDeletedUserInfoService aduis;
    @Autowired
    private UserLogoutService uls;

    public UserController() {
    }

    @RequestMapping(value = "/login/error", produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpJsonResponse loginFailure() throws Exception {
        try {
            return new HttpJsonResponse("1", "id or password incorrect!");
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/login/success", produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpJsonResponse loginSuccess() throws Exception {
        try {
            return new HttpJsonResponse("0", "success");
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpJsonResponse userRegister(@ModelAttribute("ur")UserRegister ur) throws Exception {
        try {
            int result = urs.register(ur);
            if(result == -1)
                return new HttpJsonResponse("-1", "user exist");
            else if (result == 1)
                return new HttpJsonResponse("1", "success");
            else
                return new HttpJsonResponse("0", "error");
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/userLogout", method = RequestMethod.POST)
    public HttpJsonResponse userLogOut(String id) {
        try {
            uls.userLogout(id);
            return new HttpJsonResponse("1", "success");
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/userInfoUpdate", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpJsonResponse userUpdate(@ModelAttribute("up")UserUpdate up) throws Exception {
        try {
            if(uius.update(up)) {
                return new HttpJsonResponse("0","success");
            }
            else {
                return new HttpJsonResponse("1","error");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpJsonResponse getInfo(String id) throws Exception{
        try {
            User u = us.getUserInfo(id);
            if(u == null)
                return new HttpJsonResponse("0", null);
            else
                return new HttpJsonResponse("1", u);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/allUserInfo", produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpJsonResponse getAllUserInfo(@ModelAttribute("p")Page p) throws Exception{
        try {
            CurrentPageUserList currentPageUserList = auis.getAllUserInfo(p);
            if(currentPageUserList.getUserInfoList() == null || currentPageUserList.getUserInfoList().size() == 0)
                return new HttpJsonResponse("1", null);
            else
                return new HttpJsonResponse("0", currentPageUserList);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/userDelete", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public HttpJsonResponse deleteUser(@ModelAttribute("ud")UserDelete ud) throws Exception{
        try {
            if(uds.UserDelete(ud)) {
                return new HttpJsonResponse("0", "success");
            } else {
                return new HttpJsonResponse("1", "userId is not exist");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/allDeletedUserInfo", produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpJsonResponse getAllDeletedUserInfo() throws Exception{
        try {
            CurrentPageDeletedUserList currentPageDeletedUserList = aduis.getAllDeletedUserInfo();
            if(currentPageDeletedUserList.getUserDeletedList() == null || currentPageDeletedUserList.getUserDeletedList().size() == 0)
                return new HttpJsonResponse("1", null);
            else
                return new HttpJsonResponse("0", currentPageDeletedUserList);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/userRecover", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public HttpJsonResponse deleteUser(@ModelAttribute("ur")UserRecover ur) throws Exception{
        try {
            if(urs_.UserRecover(ur)) {
                return new HttpJsonResponse("0", "success");
            } else {
                return new HttpJsonResponse("1", "user was never deleted or user was recovered");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
























    /*@RequestMapping(value = "/a", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ProblemInfo a(@ModelAttribute("problemInfoList") ProblemInfo problemInfoList) {
        return problemInfoList;
    }

    @RequestMapping(value = "/b", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProblemInfo> b(@ModelAttribute("problemInfoList") List<ProblemInfo> problemInfoList) {
        return problemInfoList;
    }*/

}
