package com.belonk.designpattern.decorator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sun on 2020/11/5.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class DecoratorInJdkDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(DecoratorInJdkDemo.class.getResource("test").getFile()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

	}
}