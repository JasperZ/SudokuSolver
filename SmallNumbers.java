public class SmallNumbers {
	private Field field;
	private int[] smallNumbers;

	/**
	 * Konstruktor ein Objekt der kleinen Zahlen erzeugt.
	 * 
	 * @param field
	 *            Das mit den kleinen Zahlen verknuepfte Feld
	 */
	public SmallNumbers(Field field) {
		this.field = field;
		this.smallNumbers = new int[9];
		clearAllNumbers();
	}

	/**
	 * Loescht alle kleinen Zahlen.
	 */
	public void clearAllNumbers() {
		for (int i = 0; i < 9; i++) {
			this.smallNumbers[i] = 0;
		}
	}

	/**
	 * Fügt alle Zahlen zu den kleinen Zahlen hinzu.
	 */
	public void setAllNumbers() {
		for (int i = 0; i < 9; i++) {
			this.smallNumbers[i] = i + 1;
		}
	}

	/**
	 * Fügt die uebergebene Zahl zu den kleinen Zahlen hinzu.
	 * 
	 * @param number
	 *            Die zu setzende Zahl
	 */
	public void setNumber(int number) {
		if (number > 0 && number < 10) {
			this.smallNumbers[number - 1] = number;
		}
	}

	/**
	 * Entfernt die uebergebene Zahl aus den kleinen Zahlen.
	 * 
	 * @param number
	 *            Die zu entfernende Zahll
	 */
	public void unsetNumber(int number) {
		if (number > 0 && number < 10) {
			this.smallNumbers[number - 1] = 0;
		}
	}

	/**
	 * Ueberprueft ob die uebergebene Zahl eine kleine Zahl ist.
	 * 
	 * @param number
	 *            Die zu ueberpruefende Zahl
	 * @return True wenn die Zahl eine kleine Zahl ist, sonst False
	 */
	public boolean isNumberSet(int number) {
		if (number > 0 && number < 10) {
			if (this.smallNumbers[number - 1] > 0) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Gibt die anzahl der kleinen Zahlen zuruek.
	 * 
	 * @return Die Anzahl der kleinen Zahlen
	 */
	public int countSetNumbers() {
		int count = 0;

		for (int i = 0; i < 9; i++) {
			if (this.smallNumbers[i] > 0) {
				count++;
			}
		}

		return count;
	}

	/**
	 * Gibt die kleinen Zahlen in der Konsole aus.
	 */
	public void printAll() {
		for (int i = 0; i < 9; i++) {
			if (this.smallNumbers[i] > 0) {
				System.out.print((i + 1) + " ");
			}
		}

		System.out.println();
	}
}
