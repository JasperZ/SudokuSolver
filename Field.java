public class Field {
	private SmallNumbers smallNumbers;
	private int number;
	private boolean isEmpty;
	private Row row;
	private Desk desk;
	private Group group;

	public Field() {
		this.smallNumbers = new SmallNumbers(this);
		this.number = 0;
		this.isEmpty = true;
	}

	/**
	 * Legt die Reihe fest, in welcher dich das Feld befindet.
	 * 
	 * @param row
	 *            Die zugehoerige Reihe
	 */
	public void setRow(Row row) {
		this.row = row;
	}

	/**
	 * Legt die Spalte fest, in welcher dich das Feld befindet.
	 * 
	 * @param desk
	 *            Die zugehoerige Spalte
	 */
	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	/**
	 * Legt die Gruppe fest, in welcher dich das Feld befindet.
	 * 
	 * @param group
	 *            Die zugehoerige Gruppe
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * Gibt die Reihe zurueck in welcher sich das Feld befindet.
	 * 
	 * @return Die zum Feld gehörende Reihe
	 */
	public Row getRow() {
		return this.row;
	}

	/**
	 * Gibt die Spalte zurueck in welcher sich das Feld befindet.
	 * 
	 * @return Die zum Feld gehörende Spalte
	 */
	public Desk getDesk() {
		return this.desk;
	}

	/**
	 * Gibt die Gruppe zurueck in welcher sich das Feld befindet.
	 * 
	 * @return Die zum Feld gehörende Gruppe
	 */
	public Group getGroup() {
		return this.group;
	}

	/**
	 * Gibt zurueck ob eine Zahl eingetragen ist.
	 * 
	 * @return True wenn eine Zahl eingetragen ist, sonst False
	 */
	public boolean isEmpty() {
		return this.isEmpty;
	}

	/**
	 * Gibt die eingetragene Zahl zurueck.
	 * 
	 * @return Die eingetragene Zahl, wenn leer 0
	 */
	public int getNumber() {
		if (this.isEmpty) {
			return 0;
		} else {
			return this.number;
		}
	}

	/**
	 * Gibt das zugehoerige Objekt zurueck, welches die kleinen Zahlen enthaelt.
	 * 
	 * @return Das zugehörige Objekt
	 */
	public SmallNumbers getSmallNumbers() {
		return this.smallNumbers;
	}

	/**
	 * Traegt die uebergebene Zahl in das Feld ein.
	 * 
	 * @param number
	 *            die einzutragende Zahl
	 */
	public void setNumber(int number) {
		if (number > 0 && number < 10) {
			this.number = number;
			this.isEmpty = false;

			this.row.unsetSmallNumber(number);
			this.desk.unsetSmallNumber(number);
			this.group.unsetSmallNumber(number);

			this.smallNumbers.clearAllNumbers();
		}
	}
}