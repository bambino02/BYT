package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals("Amount zero",  Integer.valueOf(0), EUR0.getAmount());

	}

	@Test
	public void testGetCurrency() {
		assertEquals("Currency not equal","SEK", SEK100.getCurrency().getName());
	}

	@Test
	public void testToString() {
		assertEquals("test toString", "10 EUR", EUR10.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals("Value is not equal", Integer.valueOf(0), EUR0.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		assertFalse("Not Equal", SEK100.equals(EUR20));}

	@Test
	public void testAdd() {
		assertEquals("Amount not equal with add",Integer.valueOf(30000), SEK100.add(SEK200).getAmount());
	}

	@Test
	public void testSub() {
		assertEquals("Amount not equal with sub",Integer.valueOf(10000), SEK200.sub(EUR10).getAmount());
	}

	@Test
	public void testIsZero() {
		assertTrue("not equal zero",SEK0.isZero());
		assertFalse("equal zero",EUR10.isZero());

	}

	@Test
	public void testNegate() {
		assertEquals("Amount is not equal with negate",Integer.valueOf(10000), SEKn100.negate().getAmount());
	}

	@Test
	public void testCompareTo() {
		assertEquals("test compare equal", 0, EUR10.compareTo(EUR10));
	}
}
