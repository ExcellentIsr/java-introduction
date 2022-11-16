import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MatricesTest {
	@Test
	void transpTest() {
		int[][] matrix = { 
				{ 1, 2 }, 
				{ 3, 4 }, 
				{ 5, 6 } 
		};
		
		int[][] expected = { 
				{ 1, 3, 5 },
				{ 2, 4, 6 } 
		};
		
		assertArrayEquals(expected, MyArrays.transp(matrix));
		
		int[][] matrix1 = { 
				{ 1, 2, 3 }, 
				{ 4, 5, 6 }
		};
		
		int[][] expected1 = { 
				{ 1, 4 },
				{ 2, 5 },
				{ 3, 6 }  
		};
		
		assertArrayEquals(expected1, MyArrays.transp(matrix1));
		
	}
	
}
