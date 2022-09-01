package com.vegait.timesheet.model.dto.request;

import javax.validation.constraints.NotNull;

public class UpdateClientRequest extends ClientRequest {

    @NotNull(message = "Version can not be null")
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
