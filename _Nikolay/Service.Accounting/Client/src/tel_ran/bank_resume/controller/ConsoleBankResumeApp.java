package tel_ran.bank_resume.controller;

import java.util.*;

import tel_ran.bank_resume.items.LoginItem;
import tel_ran.bank_resume.items.RegistrationItem;
import tel_ran.bank_resume.items.IsExistItem;
import tel_ran.bank_resume.model.BankResumeWebProxy;
import tel_ran.view.*;
import tel_ran.view.menu.*;

public class ConsoleBankResumeApp {
	private static InputOutput io = new ConsoleInputOutput();
	private static BankResumeWebProxy proxy = new BankResumeWebProxy();
	
	public static void main(String[] args) {
		Menu menu = new Menu(io , getItems());
		menu.runMenu();
	}

	private static Iterable<Item> getItems() {
		List<Item> items = new ArrayList<>();
		items.add(new LoginItem(io, proxy));
		items.add(new IsExistItem(io, proxy));
		items.add(new RegistrationItem(io, proxy));
		return items;
	}

}
