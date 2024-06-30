package com.blog;

import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.entities.Users;
import com.blog.repository.UserRepo;

@SpringBootTest
class BlogApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
		String targetClassName = AopUtils.getTargetClass(userRepo).getName();
	    String targetPackageName = AopUtils.getTargetClass(userRepo).getPackage().getName();
	    
	    System.out.println("Target PackageName: " + targetPackageName + ", Target ClassName: " + targetClassName);
	}

}
