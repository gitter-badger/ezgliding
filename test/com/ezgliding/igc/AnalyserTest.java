package com.ezgliding.igc;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class AnalyserTest {

	private ArrayList<Fix> fixes;

	private Analyser analyser;

	@Before
	public void setUp() {
		fixes = new ArrayList<Fix>();
		fixes.add(new Fix(1000, 40.0, 105.0, 1000, 1100, 'V'));
		fixes.add(new Fix(1005, 40.0, 115.0, 1020, 1120, 'V'));
		fixes.add(new Fix(1015, 39.0, 115.0, 1050, 1150, 'V'));

		Flight flight = new Flight();
		for (Fix fix: fixes) flight.addFix(fix);
		analyser = new Analyser(flight);
	}

	@Test
	public void testStat() {
		Stat[] expected = { 
			new Stat(5, 20, Util.distance(fixes.get(0), fixes.get(1)), 90),
			new Stat(10, 30, Util.distance(fixes.get(1), fixes.get(2)), 180)
		};
		for (int i=1; i < expected.length; i++) {
			Stat result = analyser.getStat(fixes.get(i-1), fixes.get(i));
			assertEquals(expected[i], result);
		}
	}

	@Test
	public void testStatNullFirst() {
		assertNull(analyser.getStat(null, fixes.get(0)));
	}

	@Test
	public void testStatNullSecond() {
		assertNull(analyser.getStat(fixes.get(0), null));
	}
}
