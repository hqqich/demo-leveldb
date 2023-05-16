package org.example;

import com.tsinglink.leveldb.util.LevelDBUtil;
import java.util.HashMap;
import java.util.Optional;
import org.example.adap.FastJsonAdapter;
import org.junit.Test;

/**
 * Created by ChenHao on 2023/5/16 is 14:20.
 *
 * @author tsinglink
 */

public class MyTest {

    @Test
    public void putTest() {

        FastJsonAdapter fast = new FastJsonAdapter();

        LevelDBUtil levelDB = new LevelDBUtil(fast);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("age", 18);
        map.put("name", "test");


        levelDB.writeObject("test", map);

        Optional<HashMap> test = levelDB.readObject("test", HashMap.class);

        HashMap hashMap = test.get();

        Object name = hashMap.get("name");
        int age = (int) hashMap.get("age");

        System.out.println(hashMap);


    }

}
