package co.com.hirarchyprefix;

import org.graalvm.compiler.lir.StandardOp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prefix implements  IPrefix{


    public List<Integer> getArrayOfPrefix(List<String> names, List<String> query) {
        return query.stream().map( q -> getNumberOfPrefixByName(names,q)
            ).collect(Collectors.toList());
    }
    public Integer  getNumberOfPrefixByName(List<String> names,String query) {
        Integer counter = 0 ;
        for ( String name: names ) {
                    if( isPrefixOf(name, query)) {
                     counter ++;
                    }
                }
        return counter;
    }

    public Boolean isPrefixOf(String name,String query) {
        if(name.length() > query.length()) {
            for ( int i = 0 ; i < query.length(); i++ ) {
                    if( query.charAt(i) != name.charAt(i) ){
                        return Boolean.FALSE;
                    }
            }
            return Boolean.TRUE;
           // return name.startsWith(query);
        }else{
            return Boolean.FALSE;
        }
    }
}
