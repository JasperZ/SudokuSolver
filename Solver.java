public class Solver {
	public static int solve(Sudoku sudoku) {
		int steps;
		int changes;

		changes = 0;
		steps = 0;

		do {
			changes = foo(sudoku);
			steps += changes;
		} while (changes > 0);

		System.out.println("Schritte: " + steps);
		sudoku.print();

		return steps;
	}

	public static int solveFields(Sudoku sudoku) {
		int changes = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku.getField(i, j).getSmallNumbers().countSetNumbers() == 1) {
					for (int k = 0; k < 9; k++) {
						if (sudoku.getField(i, j).getSmallNumbers()
								.isNumberSet(k)) {
							sudoku.getField(i, j).setNumber(k);
							changes++;
							break;
						}
					}
				}
			}
		}

		return changes;
	}

	public static int solveRows(Sudoku sudoku) {
		int changes = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 1; j < 10; j++) {
				if (sudoku.getRow(i).countSmallNumbersOf(j) == 1) {
					for (int k = 0; k < 9; k++) {
						if (sudoku.getRow(i).getField(k).getSmallNumbers()
								.isNumberSet(j)) {
							sudoku.getRow(i).getField(k).setNumber(j);
							changes++;
							continue;
						}
					}
				}
			}
		}

		return changes;
	}

	public static int solveDesks(Sudoku sudoku) {
		int changes = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 1; j < 10; j++) {
				if (sudoku.getDesk(i).countSmallNumbersOf(j) == 1) {
					for (int k = 0; k < 9; k++) {
						if (sudoku.getDesk(i).getField(k).getSmallNumbers()
								.isNumberSet(j)) {
							sudoku.getDesk(i).getField(k).setNumber(j);
							changes++;
							continue;
						}
					}
				}
			}
		}

		return changes;
	}

	public static int solveGroups(Sudoku sudoku) {
		int changes = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 1; k < 10; k++) {
					if (sudoku.getGroup(i, j).countSmallNumbersOf(k) == 1) {
						for (int l = 0; l < 3; l++) {
							for (int m = 0; m < 3; m++) {
								if (sudoku.getGroup(i, j).getField(l, m)
										.getSmallNumbers().isNumberSet(k)) {
									sudoku.getGroup(i, j).getField(l, m)
											.setNumber(k);
									changes++;
									continue;
								}
							}
						}
					}
				}
			}
		}

		return changes;
	}

	public static int foo(Sudoku sudoku) {
		int changes = 0;

		calcSmallNumbers(sudoku);
		changes += solveFields(sudoku);
		calcSmallNumbers(sudoku);
		changes += solveRows(sudoku);
		calcSmallNumbers(sudoku);
		changes += solveDesks(sudoku);
		calcSmallNumbers(sudoku);
		changes += solveGroups(sudoku);

		return changes;
	}

	public static void calcSmallNumbers(Sudoku sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 1; k < 10; k++) {
					if (sudoku.getField(i, j).isEmpty()
							&& !(sudoku.getField(i, j).getRow()
									.isNumberInRow(k)
									|| sudoku.getField(i, j).getDesk()
											.isNumberInDesk(k) || sudoku
									.getField(i, j).getGroup()
									.isNumberInGroup(k))) {
						sudoku.getField(i, j).getSmallNumbers().setNumber(k);
					}
				}
			}
		}
	}
}
