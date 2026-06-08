package com.example.orbitguardplatform.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NotificationDTO {
    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("messageType")
    private String messageType;

    @JsonProperty("messageIssueTime")
    private String messageIssueTime;

    @JsonProperty("messageURL")
    private String messageURL;

    @JsonProperty("messageBody")
    private String messageBody;
}
