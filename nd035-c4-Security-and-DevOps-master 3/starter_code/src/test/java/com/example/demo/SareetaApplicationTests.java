package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SareetaApplicationTests {

	@Test

	public static void injectObjects(Object target, String fieldName, Object toInject){

		boolean wasPrivate = false;

		try {
			Field f = target.getClass().getDeclaredField(fieldName);
			if (!f.canAccess(target)){
				f.setAccessible(true);
				wasPrivate = true;
			}
			f.set(target, toInject);
			if (wasPrivate){
				f.setAccessible(false);
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
