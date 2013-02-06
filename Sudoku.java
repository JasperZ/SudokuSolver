public class Sudoku {
	private Field[][] fields = new Field[9][9];
	private Row[] rows = new Row[9];
	private Desk[] desks = new Desk[9];
	private Group[][] groups = new Group[3][3];

	public Sudoku() {
		init();
	}

	public void init() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.fields[i][j] = new Field();
			}
		}

		for (int i = 0; i < 9; i++) {
			this.rows[i] = new Row();
		}

		for (int i = 0; i < 9; i++) {
			this.desks[i] = new Desk();
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.groups[i][j] = new Group();
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.rows[i].setField(j, this.fields[i][j]);
				this.desks[j].setField(i, this.fields[i][j]);
				this.groups[i / 3][j / 3].setField(i % 3, j % 3,
						this.fields[i][j]);
			}
		}
	}
	
	public Sudoku getCopy() {
		Sudoku copy = new Sudoku();
		
		int[][] numbers = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				numbers[i][j] = this.getField(i, j).getNumber();
			}
		}

		copy.setSudoku(numbers);
		
		return copy;
	}

	public Field getField(int row, int desk) {
		return this.fields[row][desk];
	}

	public Row getRow(int row) {
		return this.rows[row];
	}

	public Desk getDesk(int desk) {
		return this.desks[desk];
	}

	public Group getGroup(int innerRow, int innerDesk) {
		return this.groups[innerRow][innerDesk];
	}

	public int countEmptyFields() {
		int count = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.fields[i][j].isEmpty()) {
					count++;
				}
			}
		}

		return count;
	}

	public void print() {
		Field field;

		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				System.out.print("  ");

				for (int j = 0; j < 9; j++) {
					System.out.print(" - ");
				}

				System.out.println();
			}

			System.out.print("|");

			for (int j = 0; j < 9; j++) {
				field = this.fields[i][j];

				if (!field.isEmpty()) {
					System.out.print(" " + field.getNumber() + " ");
				} else {
					System.out.print("   ");
				}

				if ((j + 1) % 3 == 0) {
					System.out.print("|");
				}
			}

			System.out.println();
		}

		System.out.print("  ");

		for (int j = 0; j < 9; j++) {
			System.out.print(" - ");
		}

		System.out.println();
	}

	public void setSudoku(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.fields[i][j].setNumber(sudoku[i][j]);
			}
		}
	}
}
