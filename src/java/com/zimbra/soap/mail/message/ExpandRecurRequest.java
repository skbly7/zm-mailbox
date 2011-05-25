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

package com.zimbra.soap.mail.message;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.zimbra.common.soap.MailConstants;
import com.zimbra.soap.mail.type.CalTZInfo;
import com.zimbra.soap.mail.type.ExpandedRecurrenceCancel;
import com.zimbra.soap.mail.type.ExpandedRecurrenceComponent;
import com.zimbra.soap.mail.type.ExpandedRecurrenceException;
import com.zimbra.soap.mail.type.ExpandedRecurrenceInvite;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name=MailConstants.E_EXPAND_RECUR_REQUEST)
public class ExpandRecurRequest {

    @XmlAttribute(name=MailConstants.A_CAL_START_TIME /* s */, required=true)
    private final long startTime;

    @XmlAttribute(name=MailConstants.A_CAL_END_TIME /* e */, required=true)
    private final long endTime;

    @XmlElement(name=MailConstants.E_CAL_TZ /* tz */, required=false)
    private List<CalTZInfo> timezones = Lists.newArrayList();

    @XmlElements({
        @XmlElement(name=MailConstants.E_CAL_CANCEL /* cancel */,
            type=ExpandedRecurrenceCancel.class),
        @XmlElement(name=MailConstants.E_INVITE_COMPONENT /* comp */,
            type=ExpandedRecurrenceInvite.class),
        @XmlElement(name=MailConstants.E_CAL_EXCEPT /* except */,
            type=ExpandedRecurrenceException.class)
    })
    private List<ExpandedRecurrenceComponent> components = Lists.newArrayList();

    /**
     * no-argument constructor wanted by JAXB
     */
    @SuppressWarnings("unused")
    private ExpandRecurRequest() {
        this(-1L, -1L);
    }

    public ExpandRecurRequest(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setTimezones(Iterable <CalTZInfo> timezones) {
        this.timezones.clear();
        if (timezones != null) {
            Iterables.addAll(this.timezones,timezones);
        }
    }

    public ExpandRecurRequest addTimezone(CalTZInfo timezone) {
        this.timezones.add(timezone);
        return this;
    }

    public void setComponents(
                    Iterable <ExpandedRecurrenceComponent> components) {
        this.components.clear();
        if (components != null) {
            Iterables.addAll(this.components,components);
        }
    }

    public ExpandRecurRequest addComponent(
                    ExpandedRecurrenceComponent component) {
        this.components.add(component);
        return this;
    }

    public long getStartTime() { return startTime; }
    public long getEndTime() { return endTime; }
    public List<CalTZInfo> getTimezones() {
        return Collections.unmodifiableList(timezones);
    }
    public List<ExpandedRecurrenceComponent> getComponents() {
        return Collections.unmodifiableList(components);
    }

    public Objects.ToStringHelper addToStringInfo(
                Objects.ToStringHelper helper) {
        return helper
            .add("startTime", startTime)
            .add("endTime", endTime)
            .add("timezones", timezones)
            .add("components", components);
    }

    @Override
    public String toString() {
        return addToStringInfo(Objects.toStringHelper(this))
                .toString();
    }
}
