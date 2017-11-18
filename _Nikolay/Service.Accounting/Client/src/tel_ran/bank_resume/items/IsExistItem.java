package tel_ran.bank_resume.items;

import tel_ran.bank_resume.api.dto.AccountDto;
import tel_ran.bank_resume.model.BankResumeWebProxy;
import tel_ran.view.InputOutput;
import tel_ran.view.menu.Item;

public class IsExistItem implements Item {

	private InputOutput io;
	private BankResumeWebProxy proxy;

	public IsExistItem(InputOutput io, BankResumeWebProxy proxy) {
		this.io = io;
		this.proxy = proxy;
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String displayedName() {
		return "is exist";
	}

	@Override
	public void perform() {
		AccountDto account = new AccountDto(io.getString("login"), null);
		System.out.println(proxy.isExists(account));
	}

	@Override
	public boolean isExit() {
		// TODO Auto-generated method stub
		return false;
	}

}
