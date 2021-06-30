package co.com.cache;

import java.util.Date;


public class CacheModel<T> {
    private long expirationTime;
    private T  cache;


    public static class Builder {
        private long expirationTime;
        private Object  cache;

        public Builder() { }

        public Builder setCache(Object cache){
            this.cache = cache;
            return this;
        }

        public Builder setExpirationTime(long maxTimeToLive){
            this.expirationTime  = System.currentTimeMillis() + maxTimeToLive;
            return this;
        }
        public CacheModel build() {
            CacheModel cacheModel = new CacheModel();
            cacheModel.cache = this.cache;
            cacheModel.expirationTime = System.currentTimeMillis();
            return cacheModel;
        }
    }
    public void setCache(T cache){
        this.cache = cache;
    }

    public long getExpirationTime(){
        return this.expirationTime;
    }
    public void setExpirationTime(long mills){
        this.expirationTime = System.currentTimeMillis() + mills;
    }

    public T getCache(){
        return this.cache;
    }
}
