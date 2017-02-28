package com.SilverBullet.Problem_Management_System_0_0_1.Controller;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.*;
import com.SilverBullet.Problem_Management_System_0_0_1.Service.AddProblemToTrolleyService;
import com.SilverBullet.Problem_Management_System_0_0_1.Service.DeleteProblemFromTrolleyService;
import com.SilverBullet.Problem_Management_System_0_0_1.Service.GetPersonalTrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 22823 on 2016/12/6.
 */
@RestController
public class TrolleyController {
    @Autowired
    AddProblemToTrolleyService aptts;
    @Autowired
    DeleteProblemFromTrolleyService dpfts;
    @Autowired
    GetPersonalTrolleyService gpts;

    @RequestMapping(value = "/trolley/addProblem", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    public HttpJsonResponse addProblemToTrolley(@ModelAttribute("t")TrolleyPicking tp) {
        try {
            int result = aptts.trolleyAdd(tp);
            if(result == 1)
                return new HttpJsonResponse("1", "success");
            else if(result == -1)
                return new HttpJsonResponse("-1", "problem is not exist in problem bank or your trolley has added this problem");
            else
                return new HttpJsonResponse("0", "failed");
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/trolley/personal", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    public HttpJsonResponse getPersonalTrolley(@ModelAttribute("pt")PersonalTrolley pt) {
        try {
            CurrentPageProblemListInTrolley currentPageProblemListInTrolley = gpts.getProblemListInTrolley(pt);
            if(currentPageProblemListInTrolley.getProblemInfoList() == null || currentPageProblemListInTrolley.getProblemInfoList().size() == 0)
                return new HttpJsonResponse("0", null);
            else
                return new HttpJsonResponse("1", currentPageProblemListInTrolley);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(value = "/trolley/deleteProblem", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    public HttpJsonResponse deleteProblemFromTrolley(@ModelAttribute("tp")TrolleyPicking tp) {
        try {
            int result = dpfts.trolleyDelete(tp);
            if (result == 1)
                return new HttpJsonResponse("1", "success");
            else if (result == -1)
                return new HttpJsonResponse("-1", "data is not exist");
            else
                return new HttpJsonResponse("0", "failed");
        } catch (Exception ex) {
            throw ex;
        }
    }
}
