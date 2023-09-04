package com.borges.Rotininha.dto;

import com.borges.Rotininha.model.Routine;

public record TaskDTO(Long id, String title, boolean isCompleted, Routine routine) {
}
