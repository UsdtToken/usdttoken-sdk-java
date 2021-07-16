import com.usdttoken.sdk.client.UsdtTokenClient;
import com.usdttoken.sdk.domain.Address;
import com.usdttoken.sdk.domain.Coin;
import com.usdttoken.sdk.domain.ResultMsg;

import java.math.BigDecimal;
import java.util.List;

public class UsdtTokenDemo {
    public static void main(String[] args) {
        //初始化
        UsdtTokenClient usdtTokenClient = new UsdtTokenClient("http://127.0.0.1:8088",
                "630723",
                "ZfJnR2GaMEn8yRB8PfTTjQy3Sk9Di8fY",
                "");
        //获取商户支持币种
        List<Coin> coinList = usdtTokenClient.listSupportCoin(true);
        for (Coin coin:coinList){
            System.out.println(coin.getMainCoinType());
        }
        //创建地址
        Address address3 = usdtTokenClient.createAddress(1, "test","");
        System.out.println(address3);
        //检验地址合法性
        boolean b = usdtTokenClient.checkAddress(1,"0xe4f88880eee0e7bf7aa0f4b0f2fcf4df6a0d5427");
        System.out.println(b);
        //提币
       ResultMsg withdrawResult2 = usdtTokenClient.withdraw("0xa09921e9a3886e1b2b79e8fcd27d3a61ebe0ecd9", BigDecimal.TEN,
                1, 1,
                "630723", "");
       System.out.println(withdrawResult2);
    }
}
