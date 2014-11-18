package pl.edu.agh.domain.common.implementation;


import pl.edu.agh.domain.common.interfaces.IVersionedBaseObject;

import java.util.Date;

/**
 * Created by Krzysiu on 2014-05-30.
 */
public abstract class VersionedBaseObject extends BaseObject implements IVersionedBaseObject {

    protected Date creationDate;
    protected Date lastModificationDate;
    protected Date removalDate;

    public VersionedBaseObject() {
    }

    public VersionedBaseObject(Long id, Date creationDate, Date lastModificationDate, Date removalDate) {
        super(id);
        this.creationDate = creationDate;
        this.lastModificationDate = lastModificationDate;
        this.removalDate = removalDate;
    }


    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public Date getLastModificationDate() {
        return lastModificationDate;
    }
    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Date getRemovalDate() {
        return removalDate;
    }
    public void setRemovalDate(Date removalDate) {
        this.removalDate = removalDate;
    }
}
