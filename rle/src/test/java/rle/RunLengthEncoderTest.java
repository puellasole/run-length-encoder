package rle;

import static org.junit.Assert.*;

import org.junit.Test;

public class RunLengthEncoderTest {

	@Test
	public void test1() {
		final RunLengthEncoder runLengthEncoder = new RunLengthEncoder();
		final String testData = "aaaaaaaaaaaaaaaaaaaa";
		final String encodedData = runLengthEncoder.encode(testData);
		final String decodedData = runLengthEncoder.decode(encodedData);
		
		assertEquals(testData.length(), 20);
		assertEquals(encodedData.length(), 3);
		assertEquals(testData, decodedData);
		assertEquals(testData.length(), decodedData.length());
		
		printStats(testData, encodedData);
	}
	
	private static void printStats(final String testData, final String encodedData) {
		System.out.println("testData = " + testData);
		System.out.println("encodedData = " + encodedData);
		
		final float savings = (1.0f - ((float)encodedData.length()/testData.length()))*100;
		System.out.println("Savings = " + savings + "%");
	}

}
