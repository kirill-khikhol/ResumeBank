package tel_ran.view.menu;

public interface Item extends Comparable<Item>{
	String displayedName();
	void perform();
	boolean isExit();

	@Override
	default int compareTo(Item i) {
		boolean iIsExit = i.displayedName().equals("Exit");
		if (displayedName().equals("Exit")) {
			if (iIsExit) { return 0; }
			else { return 1; }
		} else if (iIsExit) return -1;
		return displayedName().compareTo(i.displayedName());
	}
}
