import org.omg.PortableInterceptor.SUCCESSFUL;

public class Test {
	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
		
		int[][] numbers = {	{0, 1, 9, 0, 0, 0, 0, 0, 0},
							{0, 0, 8, 0, 0, 3, 0, 5, 0},
							{0, 7, 0, 6, 0, 0, 0, 8, 0},
							{0, 0, 1, 0, 0, 6, 8, 0, 9},
							{8, 0, 0, 0, 4, 0, 0, 0, 7},
							{9, 4, 0, 0, 0, 0, 0, 1, 0},
							{0, 0, 0, 0, 0, 2, 0, 0, 0},
							{0, 0, 0, 0, 8, 0, 5, 6, 1},
							{0, 0, 3, 7, 0, 0, 0, 9, 0}};
		
		sudoku.setSudoku(numbers);
		
		sudoku.print();
		Solver.solve(sudoku);
	}
}
