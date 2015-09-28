package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is the same as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSame<T> extends TypeSafeDiagnosingMatcher<T> {

	private final TemporalWrapper<T> expected;
	private final TemporalFormatter<T> describer;

	public IsSame(final TemporalWrapper<T> expected, final TemporalFormatter<T> describer) {
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(T actual, Description mismatchDescription) {
		if (!expected.isSame(actual)) {
			mismatchDescription.appendText("date is " + describer.describe(expected.unwrap()));
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same date as " + describer.describe(expected.unwrap()));
	}
}