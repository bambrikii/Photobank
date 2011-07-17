package org.bambrikii.lang.translation.translationmodule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.google.gson.Gson;

public class AMDictionaryTests {

	@Test
	public void test1() throws ClientProtocolException, IOException {

		GoogleTranslator tr = new GoogleTranslator();
		String result = tr.translate(null, "phrase", "hy");
		System.out.println(result);
		FileWriter fw = new FileWriter("a1.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(result);
		bw.close();
		fw.close();

	}

	private String readResult2() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(new File("a1.txt"));

		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		String result = sb.toString();
		return result;
	}

	@Test
	public void test2() throws IOException {

		String result = readResult2();

		System.out.println(result);
		System.out.println(StringUtils.U2U(result));

	}

	@Test
	public void test3() throws FileNotFoundException, IOException {
		String result = readResult2();
		Gson gson = new Gson();
		Object obj = gson.fromJson(result, Object.class);
		System.out.println(obj.toString());
	}
}
