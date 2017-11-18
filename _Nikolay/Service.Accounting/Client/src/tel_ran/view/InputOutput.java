package tel_ran.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

public interface InputOutput {
	String WRONG_INPUT = "Wrong input please try again";
	
	public String getString(String prompt);
	public void put(Object object);
	
	/// String
	default public String getString(String prompt, int minLength, int maxLength) {
		return getString(prompt, s -> s.length() >= minLength && s.length() < maxLength);
	}
	
	default public String getString(String prompt, Predicate<String> predicate) {
		String str = null;
		while(true) {
			str = getString(prompt);
			if (predicate.test(str)) break;
			put(WRONG_INPUT);
		}
		return str;
	}
	
	default public String getString(String prompt, String[] from) {
		return getString(prompt,
				s -> new HashSet<String>(Arrays.asList(from)).contains(s));
	}
	
	/// Integer
	default public Integer getInteger(String prompt) {
		return Integer.parseInt(getString(prompt,
				s -> { try {
							Integer.parseInt(s);
							return true;
					} catch (Exception e) { return false; }}));
	}
	
	default public Integer getInteger(String prompt, Integer minValue, Integer maxValue) {
		return getInteger(prompt, i -> i >= minValue && i < maxValue);
	}
	
	default public Integer getInteger(String prompt, Predicate<Integer> predicate) {
		Integer num = null;
		while(true) {
			num = getInteger(prompt);
			if (predicate.test(num)) break;
			put(WRONG_INPUT);
		}
		return num;
	}
	
	/// Long
	default public Long getLong(String prompt) {
		return Long.parseLong(getString(prompt,
				s -> { try {
							Long.parseLong(s);
							return true;
					} catch (Exception e) { return false; }}));
	}
	
	default public Long getLong(String prompt, Long minValue, Long maxValue) {
		return getLong(prompt, l -> l >= minValue && l < maxValue);
	}
	
	default public Long getLong(String promt, Predicate<Long> predicate) {
		Long num = null;
		while(true) {
			num = getLong(promt);
			if (predicate.test(num)) break;
			put(WRONG_INPUT);
		}
		return num;
	}
	
	/// LocalDate
	default public LocalDate getDate(String prompt, String format) {
		String str = getString(prompt + " " + "in format " + format,
				s -> { try {
							LocalDate.parse(s, DateTimeFormatter.ofPattern(format));
							return true;
					} catch (Exception e) { return false; }});
		return LocalDate.parse(str, DateTimeFormatter.ofPattern(format));
	}
	
	default public LocalDate getDate(String prompt, String format, 
									LocalDate fromInclusive, LocalDate toExclusive) {
		String str = getString(prompt + " " + "in format " + format,
				s -> { try {
							LocalDate date =
									LocalDate.parse(s, DateTimeFormatter.ofPattern(format));
							return date.isAfter(fromInclusive) && date.isBefore(toExclusive);
					} catch (Exception e) {return false;}});
		return LocalDate.parse(str, DateTimeFormatter.ofPattern(format));
	}
}
