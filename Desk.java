public class Desk {
	private Field[] fields;

	public Desk() {
		this.fields = new Field[9];
	}
	
	public Field getField(int row) {
		return this.fields[row];
	}
	
	public void setField(int row, Field field) {
		this.fields[row] = field;
		field.setDesk(this);
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
		if (number > 0 && number <= 9) {
			for (int i = 0; i < 9; i++) {
				this.fields[i].getSmallNumbers().unsetNumber(number);
			}
		}
	}
	
	public boolean isNumberInDesk(int number) {
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
		
		System.out.println(" - ");
		
		for (int i = 0; i < 9; i++) {
			field = this.fields[i];
			
			if (!field.isEmpty()) {
				System.out.println(" " + field.getNumber() + " ");
			} else {
				System.out.println("   ");
			}

			if ((i + 1) % 3 == 0) {
				System.out.println(" - ");
			}
		}
		
		System.out.println();
	}
}
