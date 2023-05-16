package org.example.adap;

import com.alibaba.fastjson2.JSON;
import com.tsinglink.leveldb.util.LevelDBUtilJsonAdapter;

/**
 * Created by ChenHao on 2023/5/16 is 14:42.
 *
 * @author tsinglink
 */

public class FastJsonAdapter implements LevelDBUtilJsonAdapter {

    @Override
    public byte[] toJSONBytes(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T parseObject(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }

}
