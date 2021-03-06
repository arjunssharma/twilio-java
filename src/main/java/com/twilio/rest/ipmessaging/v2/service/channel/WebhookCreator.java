/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.ipmessaging.v2.service.channel;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.List;

public class WebhookCreator extends Creator<Webhook> {
    private final String pathServiceSid;
    private final String pathChannelSid;
    private final Webhook.Type type;
    private String configurationUrl;
    private Webhook.Method configurationMethod;
    private List<String> configurationFilters;
    private List<String> configurationTriggers;
    private String configurationFlowSid;
    private Integer configurationRetryCount;

    /**
     * Construct a new WebhookCreator.
     * 
     * @param pathServiceSid The service_sid
     * @param pathChannelSid The channel_sid
     * @param type The type
     */
    public WebhookCreator(final String pathServiceSid, 
                          final String pathChannelSid, 
                          final Webhook.Type type) {
        this.pathServiceSid = pathServiceSid;
        this.pathChannelSid = pathChannelSid;
        this.type = type;
    }

    /**
     * The configuration.url.
     * 
     * @param configurationUrl The configuration.url
     * @return this
     */
    public WebhookCreator setConfigurationUrl(final String configurationUrl) {
        this.configurationUrl = configurationUrl;
        return this;
    }

    /**
     * The configuration.method.
     * 
     * @param configurationMethod The configuration.method
     * @return this
     */
    public WebhookCreator setConfigurationMethod(final Webhook.Method configurationMethod) {
        this.configurationMethod = configurationMethod;
        return this;
    }

    /**
     * The configuration.filters.
     * 
     * @param configurationFilters The configuration.filters
     * @return this
     */
    public WebhookCreator setConfigurationFilters(final List<String> configurationFilters) {
        this.configurationFilters = configurationFilters;
        return this;
    }

    /**
     * The configuration.filters.
     * 
     * @param configurationFilters The configuration.filters
     * @return this
     */
    public WebhookCreator setConfigurationFilters(final String configurationFilters) {
        return setConfigurationFilters(Promoter.listOfOne(configurationFilters));
    }

    /**
     * The configuration.triggers.
     * 
     * @param configurationTriggers The configuration.triggers
     * @return this
     */
    public WebhookCreator setConfigurationTriggers(final List<String> configurationTriggers) {
        this.configurationTriggers = configurationTriggers;
        return this;
    }

    /**
     * The configuration.triggers.
     * 
     * @param configurationTriggers The configuration.triggers
     * @return this
     */
    public WebhookCreator setConfigurationTriggers(final String configurationTriggers) {
        return setConfigurationTriggers(Promoter.listOfOne(configurationTriggers));
    }

    /**
     * The configuration.flow_sid.
     * 
     * @param configurationFlowSid The configuration.flow_sid
     * @return this
     */
    public WebhookCreator setConfigurationFlowSid(final String configurationFlowSid) {
        this.configurationFlowSid = configurationFlowSid;
        return this;
    }

    /**
     * The configuration.retry_count.
     * 
     * @param configurationRetryCount The configuration.retry_count
     * @return this
     */
    public WebhookCreator setConfigurationRetryCount(final Integer configurationRetryCount) {
        this.configurationRetryCount = configurationRetryCount;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Webhook
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Webhook create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.IPMESSAGING.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Channels/" + this.pathChannelSid + "/Webhooks",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Webhook creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Webhook.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (type != null) {
            request.addPostParam("Type", type.toString());
        }

        if (configurationUrl != null) {
            request.addPostParam("Configuration.Url", configurationUrl);
        }

        if (configurationMethod != null) {
            request.addPostParam("Configuration.Method", configurationMethod.toString());
        }

        if (configurationFilters != null) {
            for (String prop : configurationFilters) {
                request.addPostParam("Configuration.Filters", prop);
            }
        }

        if (configurationTriggers != null) {
            for (String prop : configurationTriggers) {
                request.addPostParam("Configuration.Triggers", prop);
            }
        }

        if (configurationFlowSid != null) {
            request.addPostParam("Configuration.FlowSid", configurationFlowSid);
        }

        if (configurationRetryCount != null) {
            request.addPostParam("Configuration.RetryCount", configurationRetryCount.toString());
        }
    }
}