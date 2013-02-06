public class Group {
	private Field[][] fields = new Field[3][3];

	public Group() {
	}

	public void setField(int innerRow, int innerDesk, Field field) {
		this.fields[innerRow][innerDesk] = field;
		field.setGroup(this);
	}

	public Field getField(int innerRow, int innerDesk) {
		return this.fields[innerRow][innerDesk];
	}

	public int countSmallNumbersOf(int number) {
		int count = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.fields[i][j].isEmpty()
						&& this.fields[i][j].getSmallNumbers().isNumberSet(number)) {
					count++;
				}
			}
		}

		return count;
	}

	public void unsetSmallNumber(int number) {
		if (number > 0 && number < 10) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					this.fields[i][j].getSmallNumbers().unsetNumber(number);
				}
			}
		}
	}

	public boolean isNumberInGroup(int number) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!this.fields[i][j].isEmpty()) {
					if (this.fields[i][j].getNumber() == number) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public void print() {
		Field field;

		for (int i = 0; i < 3; i++) {
			if (i % 3 == 0) {
				System.out.print("  ");

				for (int j = 0; j < 3; j++) {
					System.out.print(" - ");
				}

				System.out.println();
			}

			System.out.print("|");

			for (int j = 0; j < 3; j++) {
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

		for (int j = 0; j < 3; j++) {
			System.out.print(" - ");
		}

		System.out.println();
	}
}
