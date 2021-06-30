package co.com.hirarchyprefix;

import java.util.List;

public interface IPrefix {

    public List<Integer> getArrayOfPrefix(List<String> names,List<String> query);
    public Integer  getNumberOfPrefixByName(List<String> name,String query);
    public Boolean isPrefixOf(String name,String query);
}
