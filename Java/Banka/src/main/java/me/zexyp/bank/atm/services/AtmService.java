package me.zexyp.bank.atm.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.zexyp.bank.atm.AtmFactory;
import me.zexyp.bank.atm.BaseAtm;
import me.zexyp.bank.cards.BaseCard;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class AtmService {
    @Inject
    private AtmFactory factory;

    List<BaseAtm> atms = new ArrayList<>();

    public void addAtm(BaseAtm atm) {
        atms.add(atm);
    }

    public void removeAtm(BaseAtm atm) {
        atms.remove(atm);
    }

    public BaseAtm[] getAtms() {
        return atms.toArray(new BaseAtm[0]);
    }

    public BaseAtm createAtm() {
        var atm = factory.createAtm();
        addAtm(atm);
        return atm;
    }
}
