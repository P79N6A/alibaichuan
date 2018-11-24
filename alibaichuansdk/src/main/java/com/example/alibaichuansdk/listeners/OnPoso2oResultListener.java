package com.example.alibaichuansdk.listeners;

import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;

/**
 * @author:heinigger 2018/11/23  17:45
 * @function:
 */
public interface OnPoso2oResultListener {
    public void onTradeSuccess(AlibcTradeResult alibcTradeResult);

    public void onFailure(int code, String msg);
}
