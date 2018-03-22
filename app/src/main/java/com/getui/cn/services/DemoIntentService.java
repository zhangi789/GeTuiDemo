package com.getui.cn.services;

import android.content.Context;
import android.util.Log;

import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;

/**
 * Created by 张茹祥 on 2017/3/22.
 */

public class DemoIntentService extends GTIntentService {

    public DemoIntentService() {
    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {

        Log.i(TAG, "onReceiveServicePid -> " + pid);
    }
    //处理透传消息
    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        byte[] payload = msg.getPayload();
        String data = new String(payload);
        Log.i(TAG, "onReceiveMessageData -> " + msg.getMessageId() + msg.getAppid() + " " + msg.getPayloadId() + " " + msg.getPkgName());
        Log.i(TAG, "透传  " + data);
    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Log.i(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
    }


    //离线上线通知
    @Override
    public void onReceiveOnlineState(Context context, boolean online) {

        Log.i(TAG, "onReceiveOnlineState -> " + "online = " + online);
    }


    //各种事件处理回执  各种事件回执单
    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {


        Log.i(TAG, "onReceiveCommandResult -> " + cmdMessage.getAppid());
    }
}