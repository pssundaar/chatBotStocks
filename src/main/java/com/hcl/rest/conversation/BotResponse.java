package com.hcl.rest.conversation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class BotResponse implements Serializable {
	
	
	
		@JsonProperty("fulfillmentText")
		private String fulfillmentText;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	
		@JsonProperty("fulfillmentText")
		public String getFulfillmentText() {
			return fulfillmentText;
		}
		@JsonProperty("fulfillmentText")
		public void setFulfillmentText(String fulfillmentText) {
			this.fulfillmentText = fulfillmentText;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		}

		
		


}
