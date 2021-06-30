import co.com.cache.CacheHandler;
import co.com.cache.CacheModel;

import java.util.HashMap;


public class Main {
    public static void main(String args[] )  {
        CacheHandler cacheHandler = CacheHandler.getInstance();
        Thread removeCache =  new Thread(cacheHandler);
        removeCache.start();

        HashMap<String,String> data = new HashMap<>();
        data.put("name","Sebastian");


        char a[][] = { { 'd' , 's' , 'e' }, { 'b' , 'd' , 'a'} , { 'e' , 'a' , 'f'} };
        boolean isSimetric = true;
        for ( int x= 0; x < a.length; x ++) {
            for ( int y= 0; y < a.length; y ++) {
                if(a[x][y] != a[y][x]) {
                    isSimetric = false;
                }
            }
        }
        if( isSimetric) {
            System.out.println("Es simetrica");
        }else {
            System.out.println("No es simetrica");
        }

        int[] b = { 1,1,2,2,3,4,5,5,5,2,2 };

        int aux = b[0];
        int count = 0;
        for ( int z = 0; z < b.length ; z++) {
            if(aux == b[z]){
                count ++;
            }else {
                System.out.println(""+aux + count);
                count = 1;
                aux = b[z];
            }
        }

        String aa = "10";
        String bb = "20";
        bb = aa;
        bb.replace('1','0');

        System.out.println(aa);
        System.out.println(bb);

    }
}


