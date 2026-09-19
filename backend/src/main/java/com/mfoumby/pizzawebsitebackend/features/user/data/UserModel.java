package com.mfoumby.pizzawebsitebackend.features.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserModel(
        @JsonProperty(UserFields.USER_ID)
        Long userId,
        @JsonProperty(UserFields.USER_FIRST_NAME)
        String userFirstName,
        @JsonProperty(UserFields.USER_LAST_NAME)
        String userLastName,
        @JsonProperty(UserFields.USER_EMAIL)
        String userEmail,
        @JsonProperty(UserFields.USER_PASSWORD)
        String userPassword,
        @JsonProperty(UserFields.USER_PHONE_NUMBER)
        String userPhoneNumber,
        @JsonProperty(UserFields.USER_ADDRESS)
        String userAddress,
        @JsonProperty(UserFields.USER_ROLE_ID)
        int userRoleId,
        @JsonProperty(UserFields.USER_DISCOUNT)
        int userDiscount
) {
}
