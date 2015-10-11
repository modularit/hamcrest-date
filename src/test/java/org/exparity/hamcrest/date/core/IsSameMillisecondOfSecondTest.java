package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.exparity.hamcrest.date.DateMatchers;
import org.junit.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
public class IsSameMillisecondOfSecondTest {

	// Date Matchers
	@Test
	public void isDateSameMillisecond() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameMillisecond(date));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameMillisecond() {
		Date date = new Date(), other = addDateField(date, Calendar.MILLISECOND, 1);
		assertThat(other, DateMatchers.sameMillisecond(date));
	}

	@Test
	public void isDateSameMillisecondDifferentSecond() {
		Date date = new Date(), other = addDateField(date, Calendar.SECOND, 1);
		assertThat(other, DateMatchers.sameMillisecond(date));
	}

	@Test
	public void isDateSameMillisecondOfSecond() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameMillisecondOfSecond(date));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameMillisecondOfSecond() {
		Date date = new Date(), other = addDateField(date, Calendar.MILLISECOND, 1);
		assertThat(other, DateMatchers.sameMillisecondOfSecond(date));
	}

	@Test
	public void isDateSameMillisecondOfSecondDifferentSecond() {
		Date date = new Date(), other = addDateField(date, Calendar.SECOND, 1);
		assertThat(other, DateMatchers.sameMillisecondOfSecond(date));
	}
}
