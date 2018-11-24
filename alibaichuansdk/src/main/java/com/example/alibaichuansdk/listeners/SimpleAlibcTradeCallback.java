package com.example.alibaichuansdk.listeners;

import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;
import com.example.alibaichuansdk.AliSdkUtils;

/**
 * @author:heinigger 2018/11/23  17:44
 * @function:
 */
public class SimpleAlibcTradeCallback implements AlibcTradeCallback {


    @Override
    public void onTradeSuccess(AlibcTradeResult alibcTradeResult) {
        //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）

    }

    @Override
    public void onFailure(int code, String msg) {
        //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
        AliSdkUtils.log("打开商品详情" + ":" + "msg");
    }
}
