package com.hdfclife.model;

public class Claim {
    private String claimId;
    private int amount;
    private String policyId;
    private String name;
    private Urgency urgency;

    public Claim(String claimId, int amount, String policyId, String name, Urgency urgency) {
        this.claimId = claimId;
        this.amount = amount;
        this.policyId = policyId;
        this.name = name;
        this.urgency = urgency;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return claimId + " | " + amount + " | " + policyId + " | "
                + name + " | " + urgency;
    }
}
