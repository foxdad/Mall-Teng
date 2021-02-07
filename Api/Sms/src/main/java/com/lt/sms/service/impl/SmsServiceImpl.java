package com.lt.sms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.lt.sms.service.SmsService;
import com.lt.sms.utils.SmsConfig;
import com.lt.sms.utils.SmsConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/7 21:03
 */
@Service
@Slf4j
public class SmsServiceImpl implements SmsService {
    @Override
    public Boolean send(String phone, Map<String, Integer> code) {
        DefaultProfile profile =
                DefaultProfile.getProfile(SmsConfig.regionId, SmsConfig.accessKeyId,SmsConfig.accessKeySecret);

        try {
            DefaultProfile.addEndpoint(SmsConfig.endpointName, SmsConfig.regionId, SmsConfig.product, SmsConfig.defaultDomain );
        } catch (ClientException e) {
            e.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
//        CommonRequest request = new CommonRequest();
        SendSmsRequest request = new SendSmsRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);

        //手机号
        //可以抽取出来到全局配置里面去

        request.setPhoneNumbers(phone);
        request.setSignName(SmsConfig.signName);
        request.setTemplateCode(SmsConfig.templateCode);
        request.setTemplateParam(JSONObject.toJSONString(code));
        try {
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals(SmsConstant.SMS_STATUS_OK)) {
                log.info("短信发送成功");
                return true;
            }
        } catch (ClientException e) {
            log.error("短信发送失败,状态码：{}，失败返回的信息：{}",e.getErrCode(),e.getErrMsg());
            e.printStackTrace();
        }
        return false;
    }
}
