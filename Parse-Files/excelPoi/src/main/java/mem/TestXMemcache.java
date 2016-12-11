package mem ;

import net.rubyeye.xmemcached.utils.AddrUtil;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;



public class TestXMemcache {

    public static void main(String[] args) throws Throwable{

        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("10.0.0.115:11315"));

        MemcachedClient memcachedClient = builder.build();

        Object rfc = memcachedClient.get("RecommendFootHc_38");
        System.out.println(rfc);


    }

}  