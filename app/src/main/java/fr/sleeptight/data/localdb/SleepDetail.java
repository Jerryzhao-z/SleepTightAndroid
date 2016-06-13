package fr.sleeptight.data.localdb;

import de.greenrobot.dao.AbstractDao;
import fr.sleeptight.data.localdb.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "SLEEPDETAIL".
 */
public class SleepDetail {

    public static final int REALLYAWAKE = 0x0003;
    public static final int AWAKE = 0x0002;

    private Long id;
    private Integer state;
    private java.util.Date time;
    private long sleepId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient SleepDetailDao myDao;

    private Sleep sleep;
    private Long sleep__resolvedKey;


    public SleepDetail() {
    }

    public SleepDetail(Long id) {
        this.id = id;
    }

    public SleepDetail(Long id, Integer state, java.util.Date time, long sleepId) {
        this.id = id;
        this.state = state;
        this.time = time;
        this.sleepId = sleepId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSleepDetailDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public java.util.Date getTime() {
        return time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public long getSleepId() {
        return sleepId;
    }

    public void setSleepId(long sleepId) {
        this.sleepId = sleepId;
    }

    /** To-one relationship, resolved on first access. */
    public Sleep getSleep() {
        long __key = this.sleepId;
        if (sleep__resolvedKey == null || !sleep__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SleepDao targetDao = daoSession.getSleepDao();
            Sleep sleepNew = targetDao.load(__key);
            synchronized (this) {
                sleep = sleepNew;
            	sleep__resolvedKey = __key;
            }
        }
        return sleep;
    }

    public void setSleep(Sleep sleep) {
        if (sleep == null) {
            throw new DaoException("To-one property 'sleepId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.sleep = sleep;
            sleepId = sleep.getId();
            sleep__resolvedKey = sleepId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
