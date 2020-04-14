package edu.depaul.triangle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleTest {

	@Test
	@DisplayName("Should recognize Isosceles triangles")
	void testIsosceles() {
		String[] args = {"4","3","4"};
		Triangle T = new Triangle(args);
		TriangleType type = T.classify();
		assertEquals(TriangleType.ISOSCELES, type);
	}

	@Test
	@DisplayName("Should recognize Equilateral triangles")
	void testEquilateral(){
		String[] args = {"3","3","3"};
		Triangle T1= new Triangle(args);
		TriangleType type1 = T1.classify();
		assertEquals(TriangleType.EQUILATERAL, type1);
	}
	@Test
	@DisplayName("Should recognize Scalene triangles")
	void testSCALENE(){
		String[] args = {"2","7","6"};
		Triangle T2= new Triangle(args);
		TriangleType type2 = T2.classify();
		assertEquals(TriangleType.SCALENE, type2);
	}

	@Test
	@DisplayName("should throw IlligalArgumentExeption because null is not allowed")
	void testExpectedException() {
		 String[] args = {"2","7", null };

		 assertThrows(IllegalArgumentException.class, () -> { new Triangle(args);

		 });
	}
	// commit testing

	@Test
	@DisplayName("should not throw any exeptions")
	void validateMaxForArgs(){
		String[]  args = {"101","7","3"};
		assertThrows(IllegalArgumentException.class,()-> {
			new Triangle(args);
		});
	}
}
