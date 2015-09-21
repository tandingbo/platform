package com.tdb.base.commons.utils.dbupdate;

import com.tdb.base.commons.db.Entity;
import com.tdb.base.commons.db.annotation.Column;
import com.tdb.base.commons.db.annotation.Id;
import com.tdb.base.commons.db.annotation.Relation;

/**
 * ClassName: DbVersion
 * Description: 数据库版本pojo对象
 * Author: Tandingbo
 * Date: 2015/9/18 16:02
 */
@Relation("SYS_DBVERSION")
public class DbVersion extends Entity {
    private static final long serialVersionUID = -7994526227425075013L;
    /**
     * ID
     */
    @Id
    @Column(COL_ID)
    private Long id;
    /**
     * 版本号
     */
    @Column(COL_VERSIONNUMBER)
    private Integer versionNumber = 0;
    public static final String TABLENAME = "SYS_DBVERSION";
    /**
     * 对应ID列名常量
     */
    private static final String COL_ID = "ID";
    /**
     * 对应版本号列名常量
     */
    private static final String COL_VERSIONNUMBER = "VERSIONNUMBER";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

}
