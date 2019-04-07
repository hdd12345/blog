package com.blog.mapper.test;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

public class OtherTest {

	@Test
	public void test() {
		System.out.println(UUID.randomUUID().toString().replace("-",""));
	}

}
