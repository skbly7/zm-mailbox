/*
 * ***** BEGIN LICENSE BLOCK *****
 * Zimbra Collaboration Suite Server
 * Copyright (C) 2011 Zimbra, Inc.
 * 
 * The contents of this file are subject to the Zimbra Public License
 * Version 1.3 ("License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 * http://www.zimbra.com/license.
 * 
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * ***** END LICENSE BLOCK *****
 */

package com.zimbra.soap.mail.type;

import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.zimbra.common.soap.MailConstants;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExpandedRecurrenceInstance {

    @XmlAttribute(name=MailConstants.A_CAL_START_TIME /* s */, required=false)
    private Long startTime;

    @XmlAttribute(name=MailConstants.A_CAL_NEW_DURATION /* dur */,
                    required=false)
    private Long duration;

    @XmlAttribute(name=MailConstants.A_CAL_ALLDAY /* allDay */, required=false)
    private Boolean allDay;

    @XmlAttribute(name=MailConstants.A_CAL_TZ_OFFSET /* tzo */, required=false)
    private Integer tzOffset;

    @XmlAttribute(name=MailConstants.A_CAL_RECURRENCE_ID_Z /* ridZ */,
                    required=false)
    private String recurIdZ;

    public ExpandedRecurrenceInstance() {
    }

    public void setStartTime(Long startTime) { this.startTime = startTime; }
    public void setDuration(Long duration) { this.duration = duration; }
    public void setAllDay(Boolean allDay) { this.allDay = allDay; }
    public void setTzOffset(Integer tzOffset) { this.tzOffset = tzOffset; }
    public void setRecurIdZ(String recurIdZ) { this.recurIdZ = recurIdZ; }
    public Long getStartTime() { return startTime; }
    public Long getDuration() { return duration; }
    public Boolean getAllDay() { return allDay; }
    public Integer getTzOffset() { return tzOffset; }
    public String getRecurIdZ() { return recurIdZ; }

    public Objects.ToStringHelper addToStringInfo(
                Objects.ToStringHelper helper) {
        return helper
            .add("startTime", startTime)
            .add("duration", duration)
            .add("allDay", allDay)
            .add("tzOffset", tzOffset)
            .add("recurIdZ", recurIdZ);
    }

    @Override
    public String toString() {
        return addToStringInfo(Objects.toStringHelper(this))
                .toString();
    }
}
