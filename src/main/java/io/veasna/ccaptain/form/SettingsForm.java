package io.veasna.ccaptain.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SettingsForm {
    @NotNull(message="Not Locked cannot be null or Empty")
    private Boolean isNotLocked;
    @NotNull(message="Enabled cannot be null or Empty")
    private Boolean enabled;

}
