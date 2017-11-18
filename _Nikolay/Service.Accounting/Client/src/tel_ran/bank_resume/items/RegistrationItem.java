package tel_ran.bank_resume.items;

import tel_ran.bank_resume.api.TypeQuestion;
import tel_ran.bank_resume.api.TypeRole;
import tel_ran.bank_resume.api.dto.FullAccountDto;
import tel_ran.bank_resume.model.BankResumeWebProxy;
import tel_ran.view.InputOutput;
import tel_ran.view.menu.Item;

public class RegistrationItem implements Item {

	private InputOutput io;
	private BankResumeWebProxy proxy;

	public RegistrationItem(InputOutput io, BankResumeWebProxy proxy) {
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
		return "registration job seeker";
	}

	@Override
	public void perform() {
		FullAccountDto account = new FullAccountDto(
				io.getString("login"),
				io.getString("password"),
				TypeRole.JOB_SEEKER,
				null,
				TypeQuestion.ON_WHAT_STREET_DID_YOU_LIVE_AS_A_CHILD,
				"question",
				123);
		System.out.println(proxy.registration(account ));

	}

	@Override
	public boolean isExit() {
		// TODO Auto-generated method stub
		return false;
	}

}
