package pl.edu.agh.domain.common.implementation;

import pl.edu.agh.domain.common.interfaces.IUserVersionedBaseObject;
import pl.edu.agh.domain.useraccounts.UserAccount;

import java.util.Date;

/**
 * Created by Krzysiu on 2014-05-31.
 */
public abstract class UserVersionedBaseObject extends VersionedBaseObject implements IUserVersionedBaseObject {

    protected UserAccount createdByAccount;
    protected UserAccount lastModificationByAccount;
    protected UserAccount removedByAccount;

    public UserVersionedBaseObject() {
    }

    public UserVersionedBaseObject(Long id, Date creationDate, Date lastModificationDate, Date removalDate, UserAccount createdByAccount, UserAccount lastModificationByAccount, UserAccount removedByAccount) {
        super(id, creationDate, lastModificationDate, removalDate);
        this.createdByAccount = createdByAccount;
        this.lastModificationByAccount = lastModificationByAccount;
        this.removedByAccount = removedByAccount;
    }

    public UserAccount getCreatedByAccount() {
        return createdByAccount;
    }
    public void setCreatedByAccount(UserAccount createdByAccount) {
        this.createdByAccount = createdByAccount;
    }

    public UserAccount getLastModificationByAccount() {
        return lastModificationByAccount;
    }
    public void setLastModificationByAccount(UserAccount lastModificationByAccount) {
        this.lastModificationByAccount = lastModificationByAccount;
    }

    public UserAccount getRemovedByAccount() {
        return removedByAccount;
    }
    public void setRemovedByAccount(UserAccount removedByAccount) {
        this.removedByAccount = removedByAccount;
    }

    public void updateInformation(UserAccount executor) {
        if(getId() == null) {
            setCreatedByAccount(executor);
            setCreationDate(new Date());
        }
        setLastModificationByAccount(executor);
        setLastModificationDate(new Date());
    }

}
