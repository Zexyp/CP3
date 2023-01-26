package me.zexyp.bank.checks.services;

import me.zexyp.bank.accounts.BaseAccount;
import me.zexyp.bank.checks.Check;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class CheckService {
    @Inject
    private CheckCreationService creationService;

    private Map<String, Check> checks = new HashMap<>();

    public void addCheck(Check check) {
        checks.put(check.getId(), check);
    }

    public void removeCheck(Check check) {
        checks.remove(check.getId());
    }

    public Check getCheck(String number) {
        return checks.get(number);
    }

    public Check[] getChecks() {
        return checks.values().toArray(new Check[0]);
    }

    public Check createCheck(BaseAccount account) {
        var check = creationService.createCheck(account);
        addCheck(check);
        account.assignCheck(check);
        return check;
    }

    public boolean validateCheck(Check check) {
        return check.getAccount() != null &&
                check.getId() != null &&
                checks.containsKey(check.getId()) &&
                checks.containsValue(check);
    }

    public void useCheck(Check check) {
        var account = check.getAccount();
        removeCheck(check);
        account.removeCheck(check);
    }
}
