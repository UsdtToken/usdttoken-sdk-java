/*
import com.google.gson.Gson;
import com.utoken.common.core.exception.BusinessException;
import com.utoken.common.utils.StringUtil;
import com.utoken.common.web.util.ResultUtil;
import com.utoken.sys.common.utils.MD5Util;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * 回调控制器事例
 *
 * @author UTokenPay
 * @date 2018-07-01
 *//*

@RestController
public class CallbackTestController {


    public Object callback(RequestParams requestParams){
        if(StringUtil.isBlank(requestParams.getBody())){
            return ResultUtil.fail(4003,"PARAM_ERROR");
        }
        BodyVo bodyVo = new Gson().fromJson(requestParams.getBody(),BodyVo.class);
        checkSign("603454","TEFHREWNBGR",requestParams.getTimestamp(),requestParams.getBody(),requestParams.getNonce(),requestParams.getBody());
        //TODO 业务处理
        //处理完成后返回状态码
        Map<String,Object> result = new HashMap<>();
        result.put("code",200);
        result.put("data","success");
        return result;
    }


    private void checkSign(String merchantId,String key,String timestamp,String body,String nonce,String sgin)throws BusinessException {
        if(StringUtil.isBlank(merchantId)){
            throw new BusinessException(4001,"merchantId not null");
        }
        if(StringUtil.isBlank(timestamp)){
            throw new BusinessException(4002,"timestamp not null");
        }
        if(StringUtil.isBlank(body)){
            throw new BusinessException(4003,"body not null");
        }
        if(StringUtil.isBlank(nonce)){
            throw new BusinessException(4004,"nonce not null");
        }
        if(StringUtil.isBlank(sgin)){
            throw new BusinessException(4005,"sgin not null");
        }
        String checkSign = MD5Util.MD5(body+key+nonce+timestamp).toLowerCase();
        if(!checkSign.equals(sgin)){
            throw new BusinessException(4007,"sign error");
        }
    }


    public class RequestParams implements Serializable{

        private String timestamp;

        private String nonce;

        private String sign;

        private String body;

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getNonce() {
            return nonce;
        }

        public void setNonce(String nonce) {
            this.nonce = nonce;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

    public class BodyVo{

        private String address;

        private String amount;

        private Integer coinType;

        private Integer decimals;

        private String fee;

        private Integer mainCoinType;

        private String status;

        private String txId;

        private String businessId;

        private String memo;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public Integer getCoinType() {
            return coinType;
        }

        public void setCoinType(Integer coinType) {
            this.coinType = coinType;
        }

        public Integer getDecimals() {
            return decimals;
        }

        public void setDecimals(Integer decimals) {
            this.decimals = decimals;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public Integer getMainCoinType() {
            return mainCoinType;
        }

        public void setMainCoinType(Integer mainCoinType) {
            this.mainCoinType = mainCoinType;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTxId() {
            return txId;
        }

        public void setTxId(String txId) {
            this.txId = txId;
        }

        public String getBusinessId() {
            return businessId;
        }

        public void setBusinessId(String businessId) {
            this.businessId = businessId;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }
    }

}
*/
