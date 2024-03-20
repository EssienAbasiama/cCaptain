package io.veasna.ccaptain.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePasswordForm {
    @NotEmpty(message = "Current Password cannot be empty")
    private String currentPassword;

    @NotEmpty(message = "New Password cannot be empty")
    private String newPassword;

    @NotEmpty(message = "Comfirm password be empty")
    private String comfirmNewPassword;

}
