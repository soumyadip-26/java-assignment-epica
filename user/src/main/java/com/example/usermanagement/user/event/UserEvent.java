package com.example.usermanagement.user.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
    private Long userId;
    private String username;
    private String eventType;  // e.g., "CREATED", "UPDATED", "DELETED"
    private String timestamp;
}
