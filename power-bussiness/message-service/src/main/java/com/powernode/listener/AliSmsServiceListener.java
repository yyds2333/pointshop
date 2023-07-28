package com.powernode.listener;


import com.alibaba.fastjson.JSON;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.powernode.constant.BusConstant;
import com.powernode.model.AliSmsModel;
import com.powernode.service.SmsLogService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 实现 RocketMQListener 接口以达到监听 rocketMQ的目的能用于接收信息
 */
@Component
@RocketMQMessageListener(topic = BusConstant.ALI_SMS_SEND_TOPIC,
        consumerGroup = "ali_sms_consumer_group",
        namespace = "power-shop")
public class AliSmsServiceListener implements RocketMQListener<String> {

    @Autowired
    private SmsLogService smsLogService;

    @Autowired
    private Client client;


    @Override
    public void onMessage(String s) {
        // 将接收到的JSON字符串转化为 AliSmsModel对象
        AliSmsModel aliSmsModel = JSON.parseObject(s, AliSmsModel.class);
        // 创建一个向阿里云发短信的请求
        SendSmsRequest request = new SendSmsRequest();
//        request.setPhoneNumbers(aliSmsModel.getPhoneNumber());
        request.setPhoneNumbers("15565972862");
        request.setSignName(aliSmsModel.getSignName());
        request.setTemplateCode(aliSmsModel.getTemplateCode());
        request.setTemplateParam(aliSmsModel.getTemplateParam());
        System.out.println(s);

        try {
            SendSmsResponse smsResponse = client.sendSms(request);
            SendSmsResponseBody body = smsResponse.getBody();
            System.out.println(body);
            System.out.println("============");
            //
            smsLogService.addSmsLog(aliSmsModel,smsResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
