package co.com.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheHandler implements Runnable {

    private HashMap<String,CacheModel> cacheRecords;
    private static  CacheHandler instance = null;
    private long maxTimeToLive;

    private CacheHandler(){

        this.cacheRecords =  new HashMap<>();
        this.maxTimeToLive = 5000;
    }
    public static CacheHandler getInstance() {
        if( instance == null) {
            instance = new CacheHandler();
        }
        return instance;
    }
    public void put(String key, Object value) {
        this.cacheRecords.put(key,new CacheModel.Builder().setExpirationTime(maxTimeToLive).setCache(value).build());
    }

    public CacheModel get(String key) {
            CacheModel cacheModel = cacheRecords.get(key);
            if( cacheModel !=  null) {
                cacheModel.setExpirationTime(maxTimeToLive);
                return cacheModel;
            }else {
                return null;
            }
    }

    public void removeFromCache() {
        List<String> listOfKeys = new ArrayList<>();
        for (Map.Entry<String, CacheModel> entry : cacheRecords.entrySet()) {
            CacheModel value = entry.getValue();
            if (isExpired(value.getExpirationTime())){
                listOfKeys.add(entry.getKey());
            }
        }

        synchronized (cacheRecords) {
            for (String key : listOfKeys) {
                cacheRecords.remove(key);
            }
        }
    }
    private void  setMaxTimeToLive(long maxTimeToLive) {
        this.maxTimeToLive = maxTimeToLive;
    }
    public Boolean isExpired(Long mills) {
        return mills <= System.currentTimeMillis();
    }

    public void run() {
        try {
            while( true ) {
                this.removeFromCache();
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
