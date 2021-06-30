import co.com.cache.CacheHandler;
import co.com.cache.CacheModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.fail;

public class CacheTest {

    private CacheHandler cacheHandler =  CacheHandler.getInstance();
    @Test
    public void addToCacheTest(){
        HashMap<String, String > data =  new HashMap<>();
        data.put("123","Alll");
        System.out.println(data);
        cacheHandler.put("key1",data);
        CacheModel cacheModel = cacheHandler.get("key1");
        Assert.assertEquals(data,cacheModel.getCache());
    }

    @Test
    public void validateExpirationTimeTest() {
        Long mills = System.currentTimeMillis() - 200;
        Boolean result  = cacheHandler.isExpired(mills);
        Assert.assertEquals(Boolean.TRUE,result);

        mills = System.currentTimeMillis() + 200;
        result  = cacheHandler.isExpired(mills);
        Assert.assertEquals(Boolean.FALSE,result);
    }

    @Test
    public void getDataInCacheTest(){

    }
}
