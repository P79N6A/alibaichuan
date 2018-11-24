package com.eelly.yiliantong;

import android.app.Application;
import android.widget.Toast;

import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.alibaba.baichuan.trade.biz.AlibcTradeBiz;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:heinigger 2018/11/24  17:31
 * @function:
 */
public class AppManager extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AlibcTradeCommon.turnOnDebug();
        AlibcTradeBiz.turnOnDebug();

        //电商SDK初始化
        AlibcTradeSDK.asyncInit(this, new AlibcTradeInitCallback() {
            @Override
            public void onSuccess() {
                Toast.makeText(AppManager.this, "初始化成功", Toast.LENGTH_SHORT).show();
                Map utMap = new HashMap<>();
                utMap.put("debug_api_url", "http://muvp.alibaba-inc.com/online/UploadRecords.do");
                utMap.put("debug_key", "baichuan_sdk_utDetection");
                AlibcUserTracker.getInstance().sendInitHit4DAU("19", "3.1.1.100");

            }

            @Override
            public void onFailure(int code, String msg) {
                Toast.makeText(AppManager.this, "初始化失败,错误码=" + code + " / 错误消息=" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
