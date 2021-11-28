package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("Names are not equal","SEK",SEK.getName());
	}
	
	@Test
	public void testGetRate() {
		assertEquals("Rates are`t equal",Double.valueOf(0.20),DKK.getRate());

	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.25);
		assertEquals("Rates are not equal",Double.valueOf(0.25),SEK.getRate());
	}
	
	@Test
	public void testGlobalValue() {
		assertEquals("Global values are not equal", Integer.valueOf(15), SEK.universalValue(100));
	}
	
	@Test
	public void testValueInThisCurrency() {
			assertEquals("test value in this currency 1", Integer.valueOf(10), SEK.valueInThisCurrency(100, EUR));
	}

}
