import co.com.hirarchyprefix.Prefix;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PrefixTest {

    private final List<String> names = Arrays.asList("sebastian", "oscar", "mike", "luke", "sebas", "mik", "mi");
    private final List<String> queries = Arrays.asList("seb", "os", "mi");

    private Prefix prefix =  new Prefix();


    @Test
    public void getArrayOfPrefixTest() {
        List<Integer> response =  prefix.getArrayOfPrefix(names,queries);
        List<Integer> expected = Arrays.asList(2,1,2);
        Assert.assertEquals(response,expected);
    }

    public void getNumberOfPrefixByNameTest() {

        Integer response =  prefix.getNumberOfPrefixByName(names,queries.get(0));
        Integer expected = 2;
        Assert.assertEquals(response,expected);
        Assert.assertEquals(prefix.getNumberOfPrefixByName(names,queries.get(0)),expected);
        Assert.assertEquals(prefix.getNumberOfPrefixByName(names,queries.get(0)),expected);
        Assert.assertEquals(prefix.getNumberOfPrefixByName(names,queries.get(0)),expected);
    }

    public void isPrefixOfTest() {
        Boolean response =  prefix.isPrefixOf(names.get(0),queries.get(0));
        Boolean expected = Boolean.TRUE;
        Assert.assertEquals(response,expected);
        Assert.assertEquals(prefix.isPrefixOf(names.get(1),queries.get(0)),false);
        Assert.assertEquals(prefix.isPrefixOf(names.get(1),queries.get(1)),true);
        Assert.assertEquals(prefix.isPrefixOf(names.get(2),queries.get(1)),false);

    }
}