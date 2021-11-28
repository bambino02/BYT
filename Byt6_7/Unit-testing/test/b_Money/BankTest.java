package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("Bank name are not equal","SweBank",SweBank.getName());
        assertEquals("Bank name are not equa","Nordea",Nordea.getName());}

	@Test
	public void testGetCurrency() {
		assertEquals("currency are not equal","SEK",SweBank.getCurrency().getName());
        assertEquals("currency are not equal","SEK",Nordea.getCurrency().getName());	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		try {
			SweBank.openAccount("Varvara");
		} catch (AccountExistsException e) {
			fail("Account already exist");
		}	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(10000, SEK));
			}
	@Test
	public void testWithdraw() throws AccountDoesNotExistException {

		SweBank.withdraw("Ulrika", new Money(10000, SEK));
		}	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		try {
			assertEquals("Balance are not equal", Integer.valueOf(0), DanskeBank.getBalance("unknown"));
		} catch (AccountDoesNotExistException e) {
		}	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {

		try {
			SweBank.transfer("Ulrika", DanskeBank, "unknown", new Money(1234_00, SEK));
			fail("Account not exist");
			SweBank.transfer("unknown", DanskeBank, "Gertrud", new Money(1234_00, SEK));
			fail("Account not exist");

		} catch (AccountDoesNotExistException e) {
		}
}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {

		SweBank.addTimedPayment(
				"Bob", "payment", 1, 1, new Money(1234_00, SEK), DanskeBank, "Gertrud");
		
	}
}
