package org.example;

import com.tsinglink.leveldb.util.LevelDBUtil;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(App.class, args);


		LevelDBUtil levelDBUtil = (LevelDBUtil) run.getBean("levelDBUtil");

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


		System.out.println(LocalDateTime.now().format(dateTimeFormatter));

		// 写 1_000_000 条数据
		for (int i = 0; i < 1000; i++) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("age", i);
			map.put("name", "test"+i);

			levelDBUtil.writeObject("key:"+i, map);

		}

		System.out.println(LocalDateTime.now().format(dateTimeFormatter));



		Optional<HashMap> test = levelDBUtil.readObject("key:12", HashMap.class);

		HashMap hashMap = test.get();

		Object name = hashMap.get("name");
		int age = (int) hashMap.get("age");

		System.out.println(hashMap);

		System.out.println(LocalDateTime.now().format(dateTimeFormatter));

	}
}
