package data.other;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache<String, String> lruCache = new LRUCache<String, String>(3);
        lruCache.put("111", "aaa");
        lruCache.put("222", "bbb");
        lruCache.put("333", "ccc");
        lruCache.put("444", "ddd");
        String expect = lruCache.get("333");
        System.out.println(expect);
        Assert.assertEquals("ccc", expect);
        lruCache.put("555", "age");
        expect = lruCache.get("222");
        System.out.println(expect);
        Assert.assertNull(expect);
        expect = lruCache.get("444");
        System.out.println(expect);
        Assert.assertEquals("ddd", expect);
        lruCache.remove("444");
        expect = lruCache.get("444");
        Assert.assertNull(expect);
        Assert.assertEquals(2,lruCache.size());
        lruCache.put("123", "567");
        Assert.assertEquals(3,lruCache.size());
        Assert.assertEquals("567",lruCache.get("123"));
        Assert.assertEquals("ccc",lruCache.get("333"));
    }
}
