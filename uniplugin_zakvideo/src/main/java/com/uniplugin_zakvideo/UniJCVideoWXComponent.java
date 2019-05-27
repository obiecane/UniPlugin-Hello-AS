package com.uniplugin_zakvideo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;

import java.util.Map;


public class UniJCVideoWXComponent extends WXComponent<UniJCVideoPlayerStandard> {

    private static final String TAG = UniJCVideoWXComponent.class.getSimpleName();
    private UniJCVideoPlayerStandard videoPlayer;


    public UniJCVideoWXComponent(WXSDKInstance instance, WXVContainer parent, BasicComponentData basicComponentData) {
        super(instance, parent, basicComponentData);
    }

    public UniJCVideoWXComponent(WXSDKInstance instance, WXVContainer parent, int type, BasicComponentData basicComponentData) {
        super(instance, parent, type, basicComponentData);
    }

    @WXComponentProp(name = "src")
    public void initSrc(String src) {
        Log.i(TAG, "setSrc: " + src);
        videoPlayer.setVideoSrc(src);
    }

    @WXComponentProp(name = "title")
    public void setTitle(String title) {
        Log.i(TAG, "setTitle: " + title);
//        videoPlayer.setTitle(title);
    }

    @WXComponentProp(name = "cover")
    public void initCover(String cover) {
        Log.i(TAG, "setCover: " + cover);
        videoPlayer.setThumbImage("http://153.0.171.158:8002/2019/05/22/701b9c2183a54939a698f1543658767d.jpg");
    }

    @WXComponentProp(name = "playStatus")
    public void initPlayStatus(String status) {
        if ("play".equalsIgnoreCase(status)) {
            videoPlayer.startPlay();
        } else if ("pause".equalsIgnoreCase(status)) {
            videoPlayer.pausePlay();
        }
    }

    @WXComponentProp(name = "autoPlay")
    public void initAutoPlay(String autoPlay) {
        Log.i(TAG, "setAutoPlay: " + autoPlay);
        videoPlayer.setAutoPlay(Boolean.parseBoolean(autoPlay));
    }

    @WXComponentProp(name = "style")
    public void initStyle(Map<String, Object> style) {
        Log.i(TAG, "initStyle: " + style);
    }

    @Override
    protected UniJCVideoPlayerStandard initComponentHostView(@NonNull Context context) {
        UniJCVideoPlayerStandard.ACTION_BAR_EXIST = false;
        UniJCVideoPlayerStandard.TOOL_BAR_EXIST = false;
        videoPlayer = new UniJCVideoPlayerStandard(context);
//        videoPlayer.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4",
//                UniJCVideoPlayerStandard.SCREEN_LAYOUT_LIST, "无敌霸王枪");

//        videoPlayer.setThumbImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        return videoPlayer;
    }

    @Override
    public void onActivityDestroy() {
        super.onActivityDestroy();
        UniJCVideoPlayerStandard.releaseAllVideos();
    }


    @Override
    public void onActivityPause() {
        super.onActivityPause();
        UniJCVideoPlayerStandard.releaseAllVideos();
    }
}
