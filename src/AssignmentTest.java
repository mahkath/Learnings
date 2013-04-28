import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class AssignmentTest {

	
	
	@Test
	public void testFailNULLIndexOfSubList() {
		List<String> source = new ArrayList<String>();
		List<String> target = null;
		int index = Assignment.indexOfSubList(source, target);
		System.out.println("Index is " + index);
		assertEquals("Index -1 expected", -1, index);
	}
	
	@Test
	public void testSuccessStringIndexOfSubList() {
		String arrSource[] = {"1","2","3","4","5","6"};
		String arrTarget[] = {"3","4","5"};
		List<String> source = Arrays.asList(arrSource);
		List<String> target = Arrays.asList(arrTarget);
		int index = Assignment.indexOfSubList(source, target);
		System.out.println("Index is " + index);
		assertEquals("Index 2 expected", 2, index);
	}
	
	@Test
	public void testSuccessEdgeCaseStringIndexOfSubList() {
		String arrSource[] = {"1","2","3","4","5","6"};
		String arrTarget[] = {"5","6"};
		List<String> source = Arrays.asList(arrSource);
		List<String> target = Arrays.asList(arrTarget);
		int index = Assignment.indexOfSubList(source, target);
		System.out.println("Index is " + index);
		assertEquals("Index 4 expected", 4, index);
	}
	
	@Test
	public void testSuccessStartCaseStringIndexOfSubList() {
		String arrSource[] = {"1","2","3","4","5","6"};
		String arrTarget[] = {"1","2"};
		List<String> source = Arrays.asList(arrSource);
		List<String> target = Arrays.asList(arrTarget);
		int index = Assignment.indexOfSubList(source, target);
		System.out.println("Index is " + index);
		assertEquals("Index 0 expected", 0, index);
	}
	
	@Test
	public void testSuccessMultipleOccuranceIndexOfSubList() {
		String arrSource[] = {"1","2","3","4","5","6","3","4","10"};
		String arrTarget[] = {"3","4"};
		List<String> source = Arrays.asList(arrSource);
		List<String> target = Arrays.asList(arrTarget);
		int index = Assignment.indexOfSubList(source, target);
		System.out.println("Index is " + index);
		assertEquals("Index 2 expected", 2, index);
	}
	
	@Test
	public void testSuccessIntegerIndexOfSubList() {
		Integer arrSource[] = {1,2,3,4,5,6};
		Integer arrTarget[] = {3,4,5};
		List<Integer> source = Arrays.asList(arrSource);
		List<Integer> target = Arrays.asList(arrTarget);
		int index = Assignment.indexOfSubList(source, target);
		System.out.println("Index is " + index);
		assertEquals("Index 2 expected", 2, index);
	}
	
	@Test
	public void testFailStringIntegerIndexOfSubList() {
		String arrSource[] = {"1","2","3","4","5","6"};
		Integer arrTarget[] = {3,4,5};
		List<String> source = Arrays.asList(arrSource);
		List<Integer> target = Arrays.asList(arrTarget);
		int index = Assignment.indexOfSubList(source, target);
		System.out.println("Index is " + index);
		assertEquals("Index -1 expected", -1, index);
	}
	
	@Test
	public void testFailLengthStringIndexOfSubList() {
		String arrSource[] = {"4","5","6"};
		String arrTarget[] = {"1","2","3","4","5","6"}; 
		List<String> source = Arrays.asList(arrSource);
		List<String> target = Arrays.asList(arrTarget);
		int index = Assignment.indexOfSubList(source, target);
		System.out.println("Index is " + index);
		assertEquals("Index -1 expected", -1, index);
	}
	
	@Test
	public void testNotFound1StringIndexOfSubList() {
		String arrSource[] = {"1","2","3","4","5","6"};
		String arrTarget[] = {"10"};
		List<String> source = Arrays.asList(arrSource);
		List<String> target = Arrays.asList(arrTarget);
		int index = Assignment.indexOfSubList(source, target);
		System.out.println("Index is " + index);
		assertEquals("Index -1 expected", -1, index);
	}
	
	@Test
	public void testNotFound2StringIndexOfSubList() {
		String arrSource[] = {"1","2","3","4","5","6"};
		String arrTarget[] = {"5","6","7"};
		List<String> source = Arrays.asList(arrSource);
		List<String> target = Arrays.asList(arrTarget);
		int index = Assignment.indexOfSubList(source, target);
		System.out.println("Index is " + index);
		assertEquals("Index -1 expected", -1, index);
	}

}
