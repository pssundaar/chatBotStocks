package com.hcl.rest.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
  "payload"
})
public class OriginalDetectIntentRequest {
	 @JsonProperty("payload")
	    private Payload payload;
	    @JsonIgnore
	    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
		
	    @JsonProperty("payload")
	    public Payload getPayload() {
			return payload;
		}
		
	    @JsonProperty("payload")
	    public void setPayload(Payload payload) {
			this.payload = payload;
		}
	    @JsonAnyGetter
	    public Map<String, Object> getAdditionalProperties() {
	        return this.additionalProperties;
	    }

	    @JsonAnySetter
	    public void setAdditionalProperty(String name, Object value) {
	        this.additionalProperties.put(name, value);
	    }

	    @Override
	    public String toString() {
	        return new ToStringBuilder(this).append("payload",payload).append("additionalProperties", additionalProperties).toString();
	    }

	    @Override
	    public int hashCode() {
	        return new HashCodeBuilder().append(additionalProperties).append(payload).toHashCode();
	    }

	    @Override
	    public boolean equals(Object other) {
	        if (other == this) {
	            return true;
	        }
	        if ((other instanceof OriginalDetectIntentRequest) == false) {
	            return false;
	        }
	        OriginalDetectIntentRequest rhs = ((OriginalDetectIntentRequest) other);
	        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(payload, rhs.payload).isEquals();
	    }

	}


