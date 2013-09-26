package lcoj;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecodeWaysTest {

	@Test
	public void testNumDecodings() {
		assertEquals(DecodeWays.numDecodings(null), -1);
		assertEquals(DecodeWays.numDecodings(""), 0);
		assertEquals(DecodeWays.numDecodings("0"), 0);
		assertEquals(DecodeWays.numDecodings("1"), 1);
		assertEquals(DecodeWays.numDecodings("12"), 2);
		assertEquals(DecodeWays.numDecodings("123"), 3);
		assertEquals(DecodeWays.numDecodings("1168963884134125126536966946586868418993819971673459188478711546479621135253876271366851168524933185"), 591230);
	}

}
