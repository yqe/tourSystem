package com.nju.tourSystem.controller;

import com.nju.tourSystem.entity.Activity;
import com.nju.tourSystem.entity.JsonResponse;
import com.nju.tourSystem.entity.Participant;
import com.nju.tourSystem.service.ActivityService;
import com.nju.tourSystem.service.ParticipantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api("活动信息管理")
@RestController
@RequestMapping("/activity/*")
public class ActivityController {
    @Autowired
    ActivityService activityService;
    @Autowired
    ParticipantService participantService;
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    /**
     *
     * @author yqe
     */
    @ApiOperation("根据ID获取出游信息")
    @RequestMapping(value = "activityInfo/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> getActivity(@PathVariable int id) {
        JsonResponse r = new JsonResponse();
        try {
            Activity activity = activityService.getActivityById(id);
            r.setData(activity);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     *
     * @author yqe
     */
    @ApiOperation("获取出游信息列表")
    @RequestMapping(value = "/activityList", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> getActivityList() {
        JsonResponse r = new JsonResponse();
        try {
            List<Activity> activityList = activityService.getAllActivity();
            r.setData(activityList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     *
     * @author yqe
     */
    @ApiOperation("添加出游")
    @RequestMapping(value = "/addActivity", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> addActivity(@RequestBody Activity activity) {
        JsonResponse r = new JsonResponse();
        try {
            Boolean state = activityService.addAcitvity(activity);
            r.setData(state);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     *
     * @author yqe
     */
    @ApiOperation("更新出游信息")
    @RequestMapping(value = "/updateActivity", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> updateActivity(@RequestBody Activity activity) {
        JsonResponse r = new JsonResponse();
        try {
            Boolean state = activityService.updateAcitvity(activity);
            r.setData(state);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     *
     * @author yqe
     */
    @ApiOperation("搜寻出游活动")
    @RequestMapping(value = "/searchActivity/{keyword}", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> searchActivity(@PathVariable("keyword")String keyword) {
        JsonResponse r = new JsonResponse();
        try {
            List<Activity> activityList = activityService.searchActivity(keyword);
            r.setData(activityList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     *
     * @author yqe
     */
    @ApiOperation("参加出游")
    @RequestMapping(value = "/joinActivity/{uid},{aid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> joinActivity(@PathVariable("uid") int uid,@PathVariable("aid") int aid) {
        JsonResponse r = new JsonResponse();
        try {
            Participant participant = new Participant();
            participant.setUid(uid);
            participant.setAid(aid);
            participant.setAgree(false);
            Boolean state = participantService.addParticipant(participant);
            r.setData(state);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     *
     * @author yqe
     */
    @ApiOperation("同意出游申请")
    @RequestMapping(value = "/applicationAgreement/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> applicationAgreement(@PathVariable("id") int id) {
        JsonResponse r = new JsonResponse();
        try {
            Participant participant = participantService.getParticipantById(id);
            participant.setAgree(true);
            Boolean state = participantService.updateParticipant(participant);
            r.setData(state);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     *
     * @author yqe
     */
    @ApiOperation("获取参加的出游列表")
    @RequestMapping(value = "/myActivityList/{uid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> myActivityList(@PathVariable("uid") int uid) {
        JsonResponse r = new JsonResponse();
        try {
            List<Participant> participantList = participantService.getActivityListByUid(uid);
            List<Activity> activityList = new ArrayList<>();
            if(participantList.size() > 0){
                for(Participant participant:participantList)
                    activityList.add(activityService.getActivityById(participant.getAid()));
            }
            r.setData(activityList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     *
     * @author yqe
     */
    @ApiOperation("获取申请阶段的出游列表")
    @RequestMapping(value = "/myapplicationList/{uid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> myapplicationList(@PathVariable("uid") int uid) {
        JsonResponse r = new JsonResponse();
        try {
            List<Participant> participantList = participantService.getApplicationListByUid(uid);
            r.setData(participantList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

}
