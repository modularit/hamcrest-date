/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static java.util.Calendar.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsNot.*;
import static uk.co.it.modular.hamcrest.date.AbstractDateMatcherTestUtils.*;
import static uk.co.it.modular.hamcrest.date.DateMatchers.*;
import java.util.Date;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameHour} class
 * 
 * @author Stewart Bissett
 */
public class IsSameHourTest {

	@Test
	public void canCompareTheSameHour() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameHour(date));
	}

	@Test
	public void canDetectDifferentHour() {
		Date date = new Date(), other = addDateField(date, HOUR, 1);
		assertThat(other, not(sameHour(date)));
	}
}