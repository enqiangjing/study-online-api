package com.so.studyonline.service;

import com.alibaba.fastjson.JSONObject;
import com.so.studyonline.config.ErrorCode;
import com.so.studyonline.enhance.ResMessage;
import com.so.studyonline.entity.SoMenulist;
import com.so.studyonline.exception.ExUserException;
import com.so.studyonline.mapper.SoMenulistMapper;
import com.so.studyonline.mapper.SoUserMapper;
import com.so.studyonline.entity.SoUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SoUserService {
    private SoUserMapper soUserMapper;

    @Autowired
    public void setSoUserMapper(SoUserMapper soUserMapper) {
        this.soUserMapper = soUserMapper;
    }

    private SoMenulistMapper soMenulistMapper;

    @Autowired
    public void setSoMenuistMapper(SoMenulistMapper soMenulistMapper) {
        this.soMenulistMapper = soMenulistMapper;
    }


    /**
     * 单个用户查询，limit 1
     *
     * @param user 查询条件
     * @return 结果
     */
    public SoUser findByUserInfo(SoUser user) {
        try {
            log.info("查询用户信息：{}", JSONObject.toJSONString(user));
            return soUserMapper.findByUserInfo(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return 结果
     */
    public SoUser addUser(SoUser user) {
        try {
            soUserMapper.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     */
    public boolean updateOneUser(SoUser user) {
        try {
            soUserMapper.updateOneUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExUserException(ErrorCode.USER_UPDATE_ERROR);
        }
        return true;
    }

    /**
     * 查询用户菜单列表
     *
     * @param user 用户信息
     * @return 菜单列表
     */
    public List<Map<String, Object>> getMenuList(SoUser user) {
        SoUser soUser = findByUserInfo(user);
        ResMessage resMessage = new ResMessage();
        SoMenulist soMenulist = new SoMenulist();
        soMenulist.setUserRole(soUser.getUserRole());
        List<SoMenulist> soMenuLists = soMenulistMapper.getUserMenu(soMenulist);
        List<SoMenulist> soMenuListsTwo = new ArrayList<>();  // 二级菜单
        for (int i = 0, length = soMenuLists.size(); i < length; i++) {
            SoMenulist soMenuList1 = soMenuLists.get(i);
            if (soMenuList1.getMenuLevel() == 2) {
                soMenuListsTwo.add(soMenuList1);
                soMenuLists.remove(soMenuList1);
                length--;
                i--;
            }
        }
        List<Map<String, Object>> resLists = new ArrayList<>();
        for (SoMenulist menulist : soMenuLists) {
            Map<String, Object> resItem = new HashMap<>();
            resItem.put("meunname", menulist.getMenuName());
            resItem.put("menuvalue", menulist.getMenuKey());
            List<Map<String, Object>> resListsSon = new ArrayList<>();
            for (int j = 0, lengthj = soMenuListsTwo.size(); j < lengthj; j++) {
                Map<String, Object> resItemSon = new HashMap<>();
                SoMenulist soMenuList2 = soMenuListsTwo.get(j);
                if (soMenuList2.getParentMent() == menulist.getId()) {
                    resItemSon.put("meunname", soMenuList2.getMenuName());
                    resItemSon.put("menuvalue", soMenuList2.getMenuKey());
                    resListsSon.add(resItemSon);
                    soMenuListsTwo.remove(soMenuList2);
                    lengthj--;
                    j--;
                }
            }
            resItem.put("menusonlist", resListsSon);
            resLists.add(resItem);
        }
        return resLists;
    }
}
