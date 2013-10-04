package lcojtest;

import static org.junit.Assert.*;
import lcoj.DecodeWays;

import org.junit.Test;

public class DecodeWaysTest {

	@Test
	public void testNumDecodings() {
		//assertEquals(DecodeWays.numDecodings(null), -1);
		assertEquals(DecodeWays.numDecodings(""), 0);
		assertEquals(DecodeWays.numDecodings("0"), 0);
		assertEquals(DecodeWays.numDecodings("1"), 1);
		assertEquals(DecodeWays.numDecodings("00"), 0);
		assertEquals(DecodeWays.numDecodings("01"), 0);
		assertEquals(DecodeWays.numDecodings("10"), 1);
		assertEquals(DecodeWays.numDecodings("12"), 2);
		assertEquals(DecodeWays.numDecodings("27"), 1);
		assertEquals(DecodeWays.numDecodings("100"), 0);
		assertEquals(DecodeWays.numDecodings("123"), 3);
//		assertEquals(DecodeWays.numDecodings("1168963884134125126536966946586868418993819971673459188478711546479621135253876271366851168524933185"), 138240);
		assertEquals(DecodeWays.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"), 3981312);
	}
}