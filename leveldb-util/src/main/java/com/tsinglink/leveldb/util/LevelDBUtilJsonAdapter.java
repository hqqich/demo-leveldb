package com.tsinglink.leveldb.util;

public interface LevelDBUtilJsonAdapter {


	byte[] toJSONBytes(Object object);


	<T> T parseObject(byte[] bytes, Class<T> clazz);


}
