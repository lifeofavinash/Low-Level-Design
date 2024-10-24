package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public record Bill(User user, long amount) { }
