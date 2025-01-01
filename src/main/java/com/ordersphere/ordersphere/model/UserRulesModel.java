package com.ordersphere.ordersphere.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserRulesModel {

    private Integer ruleId;

    private String ruleName;

    private String ruleDescription;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private UserModel userModel;

    public UserRulesModel() {
    }

    public UserRulesModel(Integer ruleId, String ruleName, String ruleDescription, LocalDateTime createdAt, LocalDateTime updatedAt, UserModel userModel) {
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.ruleDescription = ruleDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userModel = userModel;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserRulesModel that = (UserRulesModel) o;
        return Objects.equals(ruleId, that.ruleId) && Objects.equals(ruleName, that.ruleName) && Objects.equals(userModel, that.userModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleId, ruleName, userModel);
    }

    @Override
    public String toString() {
        return "UserRulesModel{" +
                "ruleId=" + ruleId +
                ", ruleName='" + ruleName + '\'' +
                ", ruleDescription='" + ruleDescription + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userModel=" + userModel +
                '}';
    }
}
