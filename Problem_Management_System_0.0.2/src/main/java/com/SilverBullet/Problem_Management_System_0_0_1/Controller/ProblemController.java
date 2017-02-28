package com.SilverBullet.Problem_Management_System_0_0_1.Controller;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.*;
import com.SilverBullet.Problem_Management_System_0_0_1.Service.ProblemGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 22823 on 2016/11/28.
 */

@RestController

public class ProblemController {
    @Autowired
    ProblemGetService pgf;

    @RequestMapping(value = "/problem/get", produces = {MediaType.APPLICATION_JSON_VALUE},method = RequestMethod.POST)
    public HttpJsonResponse problemGet(@ModelAttribute("pc")ProblemCondition pc) throws Exception {
        try {
            List<ProblemInfo> problemList = pgf.getProblemListByCondition(pc);
            if(problemList == null || problemList.size() == 0)
                return new HttpJsonResponse("0"+pc.getP(), null);
            else
                return new HttpJsonResponse(Integer.toString(problemList.size()) + pc.getP(), problemList);
        } catch (Exception ex) {
            throw ex;
        }
    }


}
