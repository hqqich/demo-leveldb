package com.tsinglink.leveldb.util;


// 接口，需要自己实现，完成需求
public interface LevelDBUtilJsonAdapter {


	// 将对象转化为字节数据
	byte[] toJSONBytes(Object object);

	// 将字节数组转化为对象
	<T> T parseObject(byte[] bytes, Class<T> clazz);


}
