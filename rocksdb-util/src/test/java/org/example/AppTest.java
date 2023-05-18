package org.example;

import org.example.util.CacheManager;
import org.example.util.GsonUtil;
import org.example.util.LoginUser;
import org.example.util.RocksDBUtil;
import org.junit.Test;
import org.rocksdb.RocksDBException;

public class AppTest {

  @Test
  public void shouldAnswerWithTrue() throws RocksDBException {


      RocksDBUtil.put("default", "name", "陈哈哈");

      String s = RocksDBUtil.get("default", "name");

      System.out.println(s);

  }

  @Test
  public void test01() throws RocksDBException {
    for (String a : RocksDBUtil.getAllKey("a")) {

      System.out.println(a);

    }
  }


  @Test
  public void test02() {
    String s = GsonUtil.toJsonString(new LoginUser(1l, 12l));

    System.out.println(s);

    LoginUser loginUser = (LoginUser) GsonUtil.fromJson(s, LoginUser.class);

    System.out.println(loginUser);

  }

  @Test
  public void test03() throws InterruptedException {

    System.out.println(CacheManager.get("name"));

    CacheManager.put("name", "陈浩");

    System.out.println(CacheManager.get("name"));

    Thread.sleep(6000);

    CacheManager.put("name", "陈哈哈");

    System.out.println(CacheManager.get("name"));

    Thread.sleep(6000);

    System.out.println(CacheManager.get("name"));

    Thread.sleep(6000);

    System.out.println(CacheManager.get("name"));

  }

}
