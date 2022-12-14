package com.so.studyonline.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.util.Auth;
import com.so.studyonline.annotation.PassToken;
import com.qiniu.storage.UploadManager;
import com.so.studyonline.config.ErrorCode;
import com.so.studyonline.config.QiNiuYun;
import com.so.studyonline.config.UserConfig;
import com.so.studyonline.enhance.ResMessage;
import com.so.studyonline.entity.SoConfig;
import com.so.studyonline.entity.SoUser;
import com.so.studyonline.exception.ExUserException;
import com.so.studyonline.enhance.RedisService;
import com.so.studyonline.service.SoConfigService;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@Slf4j
@Controller
public class SystemController {
    private SoConfigService soConfigService;

    @Autowired
    public void setSoConfigMapper(SoConfigService soConfigService) {
        this.soConfigService = soConfigService;
    }

    private QiNiuYun qiniuyun;

    @Autowired
    public void setQiNiuYun(QiNiuYun qiniuyun) {
        this.qiniuyun = qiniuyun;
    }

    private UserConfig userConfig;

    @Autowired
    public void setUserConfig(UserConfig userConfig) {
        this.userConfig = userConfig;
    }

    private RedisService redisService;

    @Autowired
    public void setRedisTemplate(RedisService redisService) {
        this.redisService = redisService;
    }


    /**
     * ????????????????????????
     *
     * @return ??????????????????
     */
    @PassToken
    @RequestMapping("api/systemService/getHomeCarouselImg")
    @ResponseBody
    public String getHomeCarouselImg() {
        JSONArray jsonArray;
        String homeCarouselImg = redisService.get("home_carousel_img");
        if (StringUtil.isNullOrEmpty(homeCarouselImg)) {
            log.info("redis ????????? home_carousel_img???????????????????????????");
            SoConfig soConfig = new SoConfig();
            soConfig.setGroup("home_carousel_img");
            soConfig.setStatus("1");
            List<SoConfig> soConfigList = soConfigService.getConfigList(soConfig);
            jsonArray = (JSONArray) JSONObject.toJSON(soConfigList);
            redisService.set5ks("home_carousel_img", jsonArray.toJSONString());
        } else {
            log.info("redis ?????? home_carousel_img??????????????????");
            jsonArray = JSON.parseArray(homeCarouselImg);
        }

        return ResMessage.success(jsonArray);
    }

    /**
     * ???????????????????????????
     *
     * @return ???????????????
     */
    @PassToken
    @RequestMapping("api/systemService/getSelectClassCarouselImg")
    @ResponseBody
    public String getSelectClassCarouselImg() {
        JSONArray jsonArray;
        String selectClassCarouseImg = redisService.get("select_class_carouse_img");
        if (StringUtil.isNullOrEmpty(selectClassCarouseImg)) {
            log.info("redis ????????? select_class_carouse_img???????????????????????????");
            SoConfig soConfig = new SoConfig();
            soConfig.setGroup("select_class_carouse_img");
            soConfig.setStatus("1");
            List<SoConfig> soConfigList = soConfigService.getConfigList(soConfig);
            jsonArray = (JSONArray) JSONObject.toJSON(soConfigList);
            redisService.set5ks("select_class_carouse_img", jsonArray.toJSONString());
        } else {
            log.info("redis ?????? select_class_carouse_img??????????????????");
            jsonArray = JSON.parseArray(selectClassCarouseImg);
        }

        return ResMessage.success(jsonArray);
    }

    /**
     * ??????????????????
     *
     * @return ????????????
     */
    @PassToken
    @RequestMapping("api/systemService/configInfoNeedVerifyCode")
    @ResponseBody
    public String configInfoNeedVerifyCode() {
        JSONObject jsonObject;
        String appConfigVerifyCode = redisService.get("app_config_verify_code");
        if (StringUtil.isNullOrEmpty(appConfigVerifyCode)) {
            log.info("redis ????????? app_config_verify_code???????????????????????????");
            SoConfig soConfig = new SoConfig();
            soConfig.setGroup("app_config");
            soConfig.setKey("verify_code");
            soConfig.setStatus("1");
            soConfig = soConfigService.getConfigItem(soConfig);
            jsonObject = (JSONObject) JSONObject.toJSON(soConfig);
            redisService.set5ks("app_config_verify_code", jsonObject.toJSONString());
        } else {
            log.info("redis ?????? app_config_verify_code??????????????????");
            jsonObject = JSON.parseObject(appConfigVerifyCode);
        }

        return ResMessage.success(jsonObject);
    }

    /**
     * ??????????????????
     *
     * @return ????????????
     */
    @PassToken
    @RequestMapping("api/systemService/getRemoteImgDomain")
    @ResponseBody
    public String getRemoteImgDomain() {
        SoUser soUser = new SoUser();
        SoConfig soConfig = new SoConfig();
        String remoteImgDomainType = redisService.get("app_config_img_save_type");
        if (StringUtil.isNullOrEmpty(remoteImgDomainType)) {
            log.info("redis ????????? app_config_img_save_type???????????????????????????");
            soConfig.setGroup("app_config");
            soConfig.setKey("img_save_type");
            remoteImgDomainType = soConfigService.getConfigValue(soConfig); // ????????????????????????
            redisService.set5ks("app_config_img_save_type", remoteImgDomainType);
        }

        // TODO ?????? remoteImgDomainType ???????????????????????????

        String remoteImgDomain = null;
        if (remoteImgDomainType.equals("qnu_img_save")) { // ???????????????
            remoteImgDomain = redisService.get("qnu_img_save_base_url");
            log.info("redis ?????? qnu_img_save_base_url --- {}", remoteImgDomain);
            if (StringUtil.isNullOrEmpty(remoteImgDomain)) {
                log.info("redis ????????? qnu_img_save_base_url???????????????????????????");
                soConfig.setGroup("qnu_img_save");
                soConfig.setKey("base_url");
                remoteImgDomain = soConfigService.getConfigValue(soConfig);
                redisService.set5ks("qnu_img_save_base_url", remoteImgDomain);
            }
        }
        soUser.setRemoteImgDomain(remoteImgDomain);
        return ResMessage.success(soUser);
    }

    /**
     * ????????????
     *
     * @return ??????????????????
     */
    @PassToken
    @RequestMapping("api/systemService/getArticleType")
    @ResponseBody
    public String getArticleType() {
        JSONArray jsonArray;
        String article_type = redisService.get("article_type");
        if (StringUtil.isNullOrEmpty(article_type)) {
            log.info("redis ????????? article_type???????????????????????????");
            SoConfig soConfig = new SoConfig();
            soConfig.setGroup("article_type");
            soConfig.setStatus("1");
            List<SoConfig> soConfigList = soConfigService.getConfigList(soConfig);
            jsonArray = (JSONArray) JSON.toJSON(soConfigList);
            redisService.set5ks("article_type", jsonArray.toJSONString());
        } else {
            log.info("redis ?????? article_type??????????????????");
            jsonArray = JSON.parseArray(article_type);
        }

        return ResMessage.success(jsonArray);
    }

    /**
     * ??????vide????????????
     */
    @PassToken
    @RequestMapping("api/systemService/getVideoUrl")
    @ResponseBody
    public String getVideoUrl(@RequestBody JSONObject jsonObject) {
        String fileName = jsonObject.getString("videoName");
        String fileUrl = "";
        SoConfig soConfig = new SoConfig();
        soConfig.setStatus("1");
        String videSaveConfig = redisService.get("app_config_video_save_type");
        if (StringUtil.isNullOrEmpty(videSaveConfig)) {
            soConfig.setGroup("app_config");
            soConfig.setKey("video_save_type");
            videSaveConfig = soConfigService.getConfigValue(soConfig);
            redisService.set5ks("app_config_video_save_type", videSaveConfig);
        }

        if (videSaveConfig.equals("qnu_video_save")) { // ?????????????????????
            soConfig.setGroup(videSaveConfig);
            String baseUrl = redisService.get("qnu_video_save_base_url");
            if (StringUtil.isNullOrEmpty(baseUrl)) {
                soConfig.setKey("base_url"); // ??????
                baseUrl = soConfigService.getConfigValue(soConfig);
                redisService.set5ks("qnu_video_save_base_url", baseUrl);
            }
            String dirName = redisService.get("qnu_video_save_dir_name");
            if (StringUtil.isNullOrEmpty(dirName)) {
                soConfig.setKey("dir_name"); // ????????????
                dirName = soConfigService.getConfigValue(soConfig);
                redisService.set5ks("qnu_video_save_dir_name", dirName);
            }
            String validity = redisService.get("qnu_video_save_term_of_validity");
            if (StringUtil.isNullOrEmpty(validity)) {
                soConfig.setKey("term_of_validity"); // ?????????????????????
                validity = soConfigService.getConfigValue(soConfig);
                redisService.set5ks("qnu_video_save_term_of_validity", validity);
            }
            fileName = dirName + "/" + fileName;
            try {
                fileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String publicUrl = baseUrl.endsWith("/") ? String.format("%s%s", baseUrl, fileName) : String.format("%s/%s", baseUrl, fileName);
            log.info("{} -- {} -- {}", publicUrl, baseUrl, fileName);
            Auth auth = Auth.create(qiniuyun.getQnu_access_key(), qiniuyun.getQnu_secret_key());
            fileUrl = auth.privateDownloadUrl(publicUrl, Long.parseLong(validity));
        }

        log.info("???????????????{} --- {}", fileName, fileUrl);

        return ResMessage.success(fileUrl);
    }

    /**
     * ??????????????????
     *
     * @param file ??????
     * @return ????????????
     */
    @PassToken
    @RequestMapping("api/systemService/uploadImg")
    @ResponseBody
    public String uploadImg(@RequestPart("file") MultipartFile file, String remotePath) {
        log.info("{} -- {}", remotePath, 1);
        String imgName;
        if (Objects.equals(file.getContentType(), "image/png")) {
            imgName = UUID.randomUUID().toString() + ".png";
        } else {
            imgName = UUID.randomUUID().toString() + ".jpg";
        }
        String imgFilePath = userConfig.getUp_file_path() + "/" + imgName;
        try {
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(file.getBytes());
            out.flush();
            out.close();
            // ?????????????????????????????????????????????
            SoConfig soConfig = new SoConfig();
            soConfig.setStatus("1");
            String imgSaveConfig = redisService.get("app_config_img_save_type");
            if (StringUtil.isNullOrEmpty(imgSaveConfig)) {
                soConfig.setGroup("app_config");
                soConfig.setKey("img_save_type");
                imgSaveConfig = soConfigService.getConfigValue(soConfig);
                redisService.set5ks("app_config_img_save_type", imgSaveConfig);
            }

            if (imgSaveConfig.equals("qnu_img_save")) { // ???????????????????????????????????????
                String spaceName = redisService.get("qnu_img_save_space_name");
                if (StringUtil.isNullOrEmpty(spaceName)) {
                    soConfig.setGroup("qnu_img_save");
                    soConfig.setKey("space_name");
                    spaceName = soConfigService.getConfigValue(soConfig);
                    redisService.set5ks("qnu_img_save_space_name", spaceName);
                }
                Auth auth = Auth.create(qiniuyun.getQnu_access_key(), qiniuyun.getQnu_secret_key());
                String token = auth.uploadToken(spaceName);
                if (StringUtils.isEmpty(token)) {
                    throw new ExUserException(ErrorCode.UP_IMG_REMOTE_ERROR);
                }
                Configuration cfg = new Configuration(Region.autoRegion());
                UploadManager uploadManager = new UploadManager(cfg);
                if (!StringUtils.isEmpty(remotePath)) {
                    imgName = remotePath + "/" + imgName;
                }
                log.info("remote ---- {}", imgName);
                Response response = uploadManager.put(imgFilePath, imgName, token);
                JSONObject res = (JSONObject) JSONObject.toJSON(response);
                log.info(JSONObject.toJSONString(res));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExUserException(ErrorCode.UP_IMG_ERROR);
        }
        return ResMessage.success(imgName);
    }
}
