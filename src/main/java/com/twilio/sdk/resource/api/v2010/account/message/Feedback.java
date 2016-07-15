/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.resource.api.v2010.account.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.converter.DateConverter;
import com.twilio.sdk.creator.api.v2010.account.message.FeedbackCreator;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.Resource;
import com.twilio.sdk.resource.RestException;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feedback extends Resource {
    private static final long serialVersionUID = 255348385418437L;

    public enum Outcome {
        CONFIRMED("confirmed"),
        UMCONFIRMED("umconfirmed");
    
        private final String value;
        
        private Outcome(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a Outcome from a string.
         * @param value string value
         * @return generated Outcome
         */
        @JsonCreator
        public static Outcome forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return Outcome.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    /**
     * Create a FeedbackCreator to execute create.
     * 
     * @param accountSid The account_sid
     * @param messageSid The message_sid
     * @return FeedbackCreator capable of executing the create
     */
    public static FeedbackCreator create(final String accountSid, 
                                         final String messageSid) {
        return new FeedbackCreator(accountSid, messageSid);
    }

    /**
     * Create a FeedbackCreator to execute create.
     * 
     * @param messageSid The message_sid
     * @return FeedbackCreator capable of executing the create
     */
    public static FeedbackCreator create(final String messageSid) {
        return new FeedbackCreator(messageSid);
    }

    /**
     * Converts a JSON String into a Feedback object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Feedback object represented by the provided JSON
     */
    public static Feedback fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Feedback.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Feedback object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Feedback object represented by the provided JSON
     */
    public static Feedback fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Feedback.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String messageSid;
    private final Feedback.Outcome outcome;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String uri;

    @JsonCreator
    private Feedback(@JsonProperty("account_sid")
                     final String accountSid, 
                     @JsonProperty("message_sid")
                     final String messageSid, 
                     @JsonProperty("outcome")
                     final Feedback.Outcome outcome, 
                     @JsonProperty("date_created")
                     final String dateCreated, 
                     @JsonProperty("date_updated")
                     final String dateUpdated, 
                     @JsonProperty("uri")
                     final String uri) {
        this.accountSid = accountSid;
        this.messageSid = messageSid;
        this.outcome = outcome;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.uri = uri;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The message_sid.
     * 
     * @return The message_sid
     */
    public final String getMessageSid() {
        return this.messageSid;
    }

    /**
     * Returns The The outcome.
     * 
     * @return The outcome
     */
    public final Feedback.Outcome getOutcome() {
        return this.outcome;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The uri.
     * 
     * @return The uri
     */
    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Feedback other = (Feedback) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(messageSid, other.messageSid) && 
               Objects.equals(outcome, other.outcome) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            messageSid,
                            outcome,
                            dateCreated,
                            dateUpdated,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("messageSid", messageSid)
                          .add("outcome", outcome)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("uri", uri)
                          .toString();
    }
}