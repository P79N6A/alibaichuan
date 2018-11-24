package com.example.alibaichuansdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.android.trade.page.AlibcDetailPage;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;
import com.example.alibaichuansdk.listeners.SimpleAlibcTradeCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:heinigger 2018/11/23  17:00
 * @function: 支付宝相关文档：
 * http://baichuan.taobao.com/docs/doc.htm?spm=a3c0d.7629140.0.0.27f0be481Iy9jA&treeId=129&articleId=105647&docType=1
 */
public class AliSdkUtils {
    //    "2100502266765", "37196464781", "2100502166202", "2100502146518"
    private static final String TAG = "AliSdkUtils";


   /* //提供给三方传递配置参数
    Map<String, String> exParams = new HashMap<>();
    exParams.put(AlibcConstants.ISV_CODE, "appisvcode");



    //实例化店铺打开page
    AlibcBasePage shopPage = new AlibcShopPage(shopId);

    //实例化添加购物车打开page
    AlibcBasePage addCardPage = new AlibcAddCartPage(itemId)

    //实例化我的订单打开page
    AlibcBasePage ordersPage = new AlibcMyOrdersPage(status, allOrder);

    //实例化我的购物车打开page
    AlibcBasePage myCartsPage = new AlibcMyCartsPage();

    //实例化URL打开page
    AlibcBasePage page = new AlibcPage(taokeUrl);

    //设置页面打开方式
    AlibcShowParams showParams = new AlibcShowParams(OpenType.Native, false);

    //使用百川sdk提供默认的Activity打开detail
    AlibcTrade.show(context, detailPage, showParams, null, exParams ,
            new AlibcTradeCallback() {
        @Override
        public void onTradeSuccess(TradeResult tradeResult) {
            //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
        }

        @Override
        public void onFailure(int code, String msg) {
            //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
        }
    });

    /使用自己的Activity & webview打开detail
    AlibcTrade.show(context, webView, webViewClient, webChromeClien, tdetailPage, showParams, null, exParams ,
            new AlibcTradeCallback() {
        @Override
        public void onTradeSuccess(TradeResult tradeResult) {
            //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
        }

        @Override
        public void onFailure(int code, String msg) {
            //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
        }
    });*/

    /**
     * 打开淘宝商品详情页
     */
    public static void goodsDetail(Activity mActivity, String itemId) {
        Map<String, String> exParams = new HashMap<>();
//        exParams.put(AlibcConstants.ISV_CODE, "appisvcode");
        //商品详情page
        AlibcBasePage detailPage = new AlibcDetailPage(itemId);
        //设置页面打开方式
        AlibcShowParams showParams = new AlibcShowParams(OpenType.Native, false);

        //使用百川sdk提供默认的Activity打开detail
        AlibcTrade.show(mActivity, detailPage, showParams, null, exParams, new SimpleAlibcTradeCallback());
    }

    /**
     * 阿里百川sdk初始化
     */
    public static void init(Application mContext) {
        AlibcTradeSDK.asyncInit(mContext, new AlibcTradeInitCallback() {
            @Override
            public void onSuccess() {
                //初始化成功，设置相关的全局配置参数

                // ...
                log("阿里百川初始化成功！");
            }

            @Override
            public void onFailure(int code, String msg) {
                //初始化失败，可以根据code和msg判断失败原因，详情参见错误说明
                log("阿里百川初始失败" + code + ":" + msg);
            }
        });
    }

    public static void log(String tag) {
        Log.v(TAG, tag);
    }
}
