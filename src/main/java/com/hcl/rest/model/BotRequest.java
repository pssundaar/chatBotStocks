
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
    "lang",
    "status",
    "timestamp",
    "sessionId",
    "queryResult",
    "id",
    "originalRequest",
    "originalDetectIntentRequest",
    "data"
})
public class BotRequest {

    @JsonProperty("lang")
    private String lang;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("sessionId")
    private String sessionId;
    @JsonProperty("queryResult")
    private QueryResult queryResult;
    @JsonProperty("id")
    private String id;
    @JsonProperty("originalRequest")
    private OriginalRequest originalRequest;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("originalDetectIntentRequest")
    private OriginalDetectIntentRequest originalDetectIntentRequest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

   
   
    @JsonProperty("queryResult")
	public QueryResult getQueryResult() {
		return queryResult;
	}
    @JsonProperty("queryResult")
	public void setQueryResult(QueryResult queryResult) {
		this.queryResult = queryResult;
	}

	@JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("originalRequest")
    public OriginalRequest getOriginalRequest() {
        return originalRequest;
    }

    @JsonProperty("originalRequest")
    public void setOriginalRequest(OriginalRequest originalRequest) {
        this.originalRequest = originalRequest;
    }
    
    @JsonProperty("originalDetectIntentRequest")
    public OriginalDetectIntentRequest getOriginalDetectIntentRequest() {
		return originalDetectIntentRequest;
	}
    @JsonProperty("originalDetectIntentRequest")
	public void setOriginalDetectIntentRequest(OriginalDetectIntentRequest originalDetectIntentRequest) {
		this.originalDetectIntentRequest = originalDetectIntentRequest;
	}

	@JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
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
        return new ToStringBuilder(this).append("lang", lang).append("status", status).append("timestamp", timestamp).append("sessionId", sessionId).append("queryResult", queryResult).append("id", id).append("originalRequest", originalRequest).append("originalDetectIntentRequest",originalDetectIntentRequest).append("data", data).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(timestamp).append(queryResult).append(sessionId).append(status).append(additionalProperties).append(originalRequest).append(originalDetectIntentRequest).append(data).append(lang).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BotRequest) == false) {
            return false;
        }
        BotRequest rhs = ((BotRequest) other);
        return new EqualsBuilder().append(id, rhs.id).append(timestamp, rhs.timestamp).append(queryResult, rhs.queryResult).append(sessionId, rhs.sessionId).append(status, rhs.status).append(additionalProperties, rhs.additionalProperties).append(originalRequest, rhs.originalRequest).append(originalDetectIntentRequest, rhs.originalDetectIntentRequest).append(data,rhs.data).append(lang, rhs.lang).isEquals();
    }

}
