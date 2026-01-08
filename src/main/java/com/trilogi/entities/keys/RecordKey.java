package com.trilogi.entities.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RecordKey implements Serializable {

    @Column(name = "researcher_id")
    private Long researcherId;

    @Column(name = "oddity_id")
    private Long oddityId;

    public RecordKey() {}

    public RecordKey(Long researcherId, Long oddityId) {
        this.researcherId = researcherId;
        this.oddityId = oddityId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecordKey)) return false;
        RecordKey that = (RecordKey) o;
        return researcherId.equals(that.researcherId) &&
                oddityId.equals(that.oddityId);
    }

    @Override
    public int hashCode() {
        return researcherId.hashCode() + oddityId.hashCode();
    }
}
