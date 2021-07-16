package com.usdttoken.sdk.client;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.usdttoken.sdk.constant.ApiPath;
import com.usdttoken.sdk.domain.Address;
import com.usdttoken.sdk.domain.Coin;
import com.usdttoken.sdk.domain.ResultMsg;
import com.usdttoken.sdk.util.UsdtTokenUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsdtTokenClient implements UsdtTokenApi {
    /**
     * 网关
     */
    private final String gateway;
    /**
     * 商户编号
     */
    private final String merchantId;
    /**
     * 商户key
     */
    private final String merchantKey;
    /**
     * 默认回调地址
     */
    private final String defaultCallBackUrl;

    public UsdtTokenClient(String gateway, String merchantId, String merchantKey, String defaultCallBackUrl) {
        this.gateway = gateway;
        this.merchantId = merchantId;
        this.merchantKey = merchantKey;
        this.defaultCallBackUrl = defaultCallBackUrl;
    }


    @Override
    public Address createAddress(Integer mainCoinType,String alias) {
        return createAddress(mainCoinType, alias,defaultCallBackUrl);
    }

    @Override
    public Address createAddress(Integer mainCoinType, String alias, String callUrl) {
        Map<String, Object> params = new HashMap<>();
        params.put("merchantId", merchantId);
        params.put("mainCoinType", mainCoinType);
        params.put("callUrl", callUrl);
        params.put("alias", alias);

        ResultMsg result = JSONUtil.toBean(UsdtTokenUtils.post(gateway, merchantKey, ApiPath.CREATE_ADDRESS, StrUtil.format("[{}]", JSONUtil.toJsonStr(params))), ResultMsg.class);
        if (result.getCode() != HttpStatus.HTTP_OK) {
            Console.error(JSONUtil.toJsonStr(result));
            return null;
        }
        return JSONUtil.toBean(result.getData(), Address.class);
    }

    @Override
    public ResultMsg withdraw(String address, BigDecimal amount, Integer mainCoinType, Integer coinType, String businessId, String memo) {
        return withdraw(address, amount, mainCoinType, coinType, businessId, memo, defaultCallBackUrl);
    }

    @Override
    public ResultMsg withdraw(String address, BigDecimal amount, Integer mainCoinType, Integer coinType, String businessId, String memo, String callUrl) {
        Map<String, Object> params = new HashMap<>();
        params.put("address", address);
        params.put("amount", amount);
        params.put("merchantId", merchantId);
        params.put("mainCoinType", mainCoinType);
        params.put("coinType", coinType);
        params.put("callUrl", callUrl);
        params.put("businessId", businessId);
        params.put("memo", memo);
        return JSONUtil.toBean(UsdtTokenUtils.post(gateway, merchantKey, ApiPath.WITHDRAW, StrUtil.format("[{}]", JSONUtil.toJsonStr(params))), ResultMsg.class);
    }

    @Override
    public boolean checkAddress(Integer mainCoinType, String address) {
        Map<String, Object> params = new HashMap<>();
        params.put("merchantId", merchantId);
        params.put("mainCoinType", mainCoinType);
        params.put("address", address);
        ResultMsg result = JSONUtil.toBean(UsdtTokenUtils.post(gateway, merchantKey, ApiPath.CHECK_ADDRESS, StrUtil.format("[{}]", JSONUtil.toJsonStr(params))), ResultMsg.class);
        return result.getCode() == HttpStatus.HTTP_OK;
    }

    @Override
    public List<Coin> listSupportCoin(boolean showBalance) {
        Map<String, Object> params = new HashMap<>();
        params.put("merchantId", merchantId);
        params.put("showBalance", showBalance);
        ResultMsg result = JSONUtil.toBean(UsdtTokenUtils.post(gateway, merchantKey, ApiPath.SUPPORT_COIN, JSONUtil.toJsonStr(params)), ResultMsg.class);
        if (result.getCode() != HttpStatus.HTTP_OK) {
            Console.error(JSONUtil.toJsonStr(result));
            return null;
        }
        return JSONUtil.toList(JSONUtil.parseArray(result.getData()), Coin.class);
    }
}
