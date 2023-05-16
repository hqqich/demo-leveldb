package com.tsinglink.leveldb;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBFactory;
import org.iq80.leveldb.DBIterator;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.impl.Iq80DBFactory;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

  /**
   * Rigorous Test :-)
   */
  @Test
  public void shouldAnswerWithTrue() throws Exception {
    DBFactory factory = new Iq80DBFactory();
    Options options = new Options();
    options.createIfMissing(true);
    //folder 是db存储目录
    DB db = factory.open(new File("F:\\project\\go\\go-fastdfs\\data\\fileserver.db"), options);

    LinkedHashMap<String, String> stringStringLinkedHashMap = iteratorDb(db);
    System.out.println(stringStringLinkedHashMap);

  }

  public LinkedHashMap<String, String> iteratorDb(DB db) {
    DBIterator iterator = db.iterator();
    LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
    while (iterator.hasNext()) {
      Map.Entry<byte[], byte[]> next = iterator.next();
      String key = Iq80DBFactory.asString(next.getKey());
      String value = Iq80DBFactory.asString(next.getValue());
      linkedHashMap.put(key, value);
    }
    return linkedHashMap;
  }

}
