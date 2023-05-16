package com.tsinglink.leveldb.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBFactory;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.WriteOptions;
import org.iq80.leveldb.impl.Iq80DBFactory;

/**
 * Created by ChenHao on 2023/5/16 is 13:51.
 *
 * @author tsinglink
 */

public class LevelDBUtil {

    private static final String PATH = "./data/level.db";
    private static final File FILE = new File(PATH);
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    private LevelDBUtilJsonAdapter levelDBUtilJsonAdapter;

    public LevelDBUtil(LevelDBUtilJsonAdapter levelDBUtilJsonAdapter) {
        this.levelDBUtilJsonAdapter = levelDBUtilJsonAdapter;
    }

    public void writeObject(String key, Object object) {
        Options options = new Options();
        DBFactory factory = Iq80DBFactory.factory;
        DB db = null;
        try {
            db = factory.open(FILE, options);

            WriteOptions writeOptions = new WriteOptions();
            writeOptions.snapshot(true);
            db.put(key.getBytes(CHARSET), levelDBUtilJsonAdapter.toJSONBytes(object));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                try {
                    db.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public <T> Optional<T> readObject(String key, Class<T> o) {
        Options options = new Options();
        DBFactory factory = Iq80DBFactory.factory;
        DB db = null;
        try {
            db = factory.open(FILE, options);
            byte[] valueByte = db.get(key.getBytes(CHARSET));
            T t = levelDBUtilJsonAdapter.parseObject(valueByte, o);
            return Optional.of(t);
        } catch (NullPointerException e) {
            return Optional.empty();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                try {
                    db.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Optional.empty();
    }

/*
    public <T> List<T> readObjectList(String key, Class<T> o) {
        Options options = new Options();
        DBFactory factory = Iq80DBFactory.factory;
        DB db = null;
        try {
            db = factory.open(FILE, options);
            byte[] valueByte = db.get(key.getBytes(CHARSET));
            //JSONObject jsonObject = JSON.parseObject(valueByte);
            List<T> ts = JSON.parseArray(valueByte, o);
            return ts;
            //ByteArrayInputStream bais = new ByteArrayInputStream(valueByte);
            //ObjectInputStream ois = new ObjectInputStream(bais);
            //return (List<T>) ois.readObject();
        } catch (NullPointerException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                try {
                    db.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ArrayList<>();
    }

    public static synchronized void  writeObjectList(String key, List<Object> value) {
        Options options = new Options();
        DBFactory factory = Iq80DBFactory.factory;
        DB db = null;
        try {
            db = factory.open(FILE, options);

            WriteOptions writeOptions = new WriteOptions();
            writeOptions.snapshot(true);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(value);

            db.put(key.getBytes(CHARSET), baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                try {
                    db.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
*/


    public static synchronized void remove(String key) {
        Options options = new Options();
        DBFactory factory = Iq80DBFactory.factory;
        DB db = null;
        try {
            db = factory.open(FILE, options);
            db.delete(key.getBytes(CHARSET));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                try {
                    db.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
