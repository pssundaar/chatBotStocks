
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
    "conversation_id",
    "type",
    "conversation_token"
})
public class Conversation {

    @JsonProperty("conversation_id")
    private String conversationId;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("conversation_token")
    private String conversationToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("conversation_id")
    public String getConversationId() {
        return conversationId;
    }

    @JsonProperty("conversation_id")
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Integer type) {
        this.type = type;
    }

    @JsonProperty("conversation_token")
    public String getConversationToken() {
        return conversationToken;
    }

    @JsonProperty("conversation_token")
    public void setConversationToken(String conversationToken) {
        this.conversationToken = conversationToken;
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
        return new ToStringBuilder(this).append("conversationId", conversationId).append("type", type).append("conversationToken", conversationToken).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(conversationToken).append(additionalProperties).append(conversationId).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Conversation) == false) {
            return false;
        }
        Conversation rhs = ((Conversation) other);
        return new EqualsBuilder().append(conversationToken, rhs.conversationToken).append(additionalProperties, rhs.additionalProperties).append(conversationId, rhs.conversationId).append(type, rhs.type).isEquals();
    }

}
