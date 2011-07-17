package org.bambrikii.photobank.web.tests;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CollectionsTests {
	@Test
	public void updateMapValue() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer int1 = 1;
		map.put(int1, 1);
		map.put(int1, 2);
		// System.out.printf("%s", map.get(1));
		Assert.assertTrue(map.get(int1).equals(2));
	}
}
