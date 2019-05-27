package com.uniplugin_zakvideo;

import android.app.Application;

import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

import io.dcloud.weex.AppHookProxy;

public class UniJCVideoWXComponent_AppProxy implements AppHookProxy {

    @Override
    public void onCreate(Application application) {
        try {
            WXSDKEngine.registerComponent("zakvideo", UniJCVideoWXComponent.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }

}
