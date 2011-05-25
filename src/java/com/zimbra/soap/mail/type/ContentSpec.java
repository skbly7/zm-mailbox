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
import javax.xml.bind.annotation.XmlValue;

import com.zimbra.common.soap.MailConstants;

@XmlAccessorType(XmlAccessType.FIELD)
public class ContentSpec {

    @XmlAttribute(name=MailConstants.A_ATTACHMENT_ID /* aid */, required=false)
    private String attachmentId;

    @XmlAttribute(name=MailConstants.A_MESSAGE_ID /* mid */, required=false)
    private String messageId;

    @XmlAttribute(name=MailConstants.A_PART /* part */, required=false)
    private String part;

    @XmlValue
    private String text;

    public ContentSpec() {
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }
    public void setMessageId(String messageId) { this.messageId = messageId; }
    public void setPart(String part) { this.part = part; }
    public void setText(String text) { this.text = text; }
    public String getAttachmentId() { return attachmentId; }
    public String getMessageId() { return messageId; }
    public String getPart() { return part; }
    public String getText() { return text; }

    public Objects.ToStringHelper addToStringInfo(
                Objects.ToStringHelper helper) {
        return helper
            .add("attachmentId", attachmentId)
            .add("messageId", messageId)
            .add("part", part)
            .add("text", text);
    }

    @Override
    public String toString() {
        return addToStringInfo(Objects.toStringHelper(this))
                .toString();
    }
}
