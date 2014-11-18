package pl.edu.agh.domain.eventshistory;


import pl.edu.agh.domain.common.implementation.BaseObject;
import pl.edu.agh.domain.useraccounts.UserAccount;

import java.util.Date;

/**
 * Created by Krzysiu on 2014-06-09.
 */
public class UserAccountStatusEvent extends BaseObject {

    private UserAccount userAccount;
    private UserAccount.Status status;
    private Date startDate;
    private Date endDate;


    public UserAccountStatusEvent() {
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public UserAccount.Status getStatus() {
        return status;
    }
    public void setStatus(UserAccount.Status status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
