package BookRecommender;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//import arraypractice.ArrayPractice;

import java.util.Arrays;


import java.util.Arrays;
class BookTest2 {

	@Test
	void testMain() {
		fail("Not yet implemented");
	}

	@Test
	void testBookNames() {
		fail("Not yet implemented");
	}

	@Test
	void testBookRating() {
		fail("Not yet implemented");
	}

	@Test
	void testUserRating() {
		fail("Not yet implemented");
	}

	@Test
	void testUserSimilarity() {
		//fail("Not yet implemented");
	System.out.println("UserSumilarity");
	int[] A = {4,3}; 
	double result = 0;
	result = Book.userSimilarity(A);
	double EXPresult = 5.0;
	assertEquals(result,EXPresult,0);
	}    
	
	@Test
	void testBookSimilarity() {
		//fail("Not yet implemented");
	System.out.println("BookSumilarity");
	int[][] A = {{4,3},{4,3}}; 
	double [] result = new double [A.length];
	result = Book.bookSimilarity(A);
	double []EXPresult = {5.0,5.0};
	assertArrayEquals(result,EXPresult); 
	}

	@Test
	void testBoth() {
		fail("Not yet implemented");
	}

	@Test
	void testSum() {
		fail("Not yet implemented");
	}

	@Test
	void testW() {
		fail("Not yet implemented");
	}

	@Test
	void testBookFind() {
		fail("Not yet implemented");
	}

	@Test
	void testMultBooks() {
		fail("Not yet implemented");
	}

}
