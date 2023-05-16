package org.example.config;

import com.tsinglink.leveldb.util.LevelDBUtil;
import org.example.adap.FastJsonAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ChenHao on 2023/5/16 is 14:50.
 *
 * @author tsinglink
 */

@Configuration
public class BeanConfig {

    @Bean
    public LevelDBUtil levelDBUtil() {
        return new LevelDBUtil(new FastJsonAdapter());
    }

}
