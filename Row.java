public class Row {
	private Field[] fields;

	public Row() {
		this.fields = new Field[9];
	}

	public Field getField(int desk) {
		return this.fields[desk];
	}

	public void setField(int desk, Field field) {
		this.fields[desk] = field;
		field.setRow(this);
	}

	public int countSmallNumbersOf(int number) {
		int count = 0;

		for (int i = 0; i < 9; i++) {
			if (this.fields[i].isEmpty()
					&& this.fields[i].getSmallNumbers().isNumberSet(number)) {
				count++;
			}
		}

		return count;
	}

	public void unsetSmallNumber(int number) {
		if (number > 0 && number < 10) {
			for (int i = 0; i < 9; i++) {
				this.fields[i].getSmallNumbers().unsetNumber(number);
			}
		}
	}

	public boolean isNumberInRow(int number) {
		for (int i = 0; i < 9; i++) {
			if (!this.fields[i].isEmpty()) {
				if (this.fields[i].getNumber() == number) {
					return true;
				}
			}
		}

		return false;
	}

	public void print() {
		Field field;

		System.out.print("|");

		for (int i = 0; i < 9; i++) {
			field = this.fields[i];

			if (!field.isEmpty()) {
				System.out.print(" " + field.getNumber() + " ");
			} else {
				System.out.print("   ");
			}

			if ((i + 1) % 3 == 0) {
				System.out.print("|");
			}
		}

		System.out.println();
	}
}
